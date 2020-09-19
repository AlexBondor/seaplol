package ro.cineseuita.data.cpv.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.cineseuita.data.contract.entity.direct.DirectAcquisitionContractDetails;
import ro.cineseuita.data.contract.entity.direct.components.DirectAcquisitionItem;
import ro.cineseuita.data.contract.repository.DirectAcquisitionContractRepository;
import ro.cineseuita.data.contract.service.DirectAcquisitionContractService;
import ro.cineseuita.data.contractingauthority.repository.ContractingAuthorityDataRepository;
import ro.cineseuita.data.cpv.entity.ContractingAuthorityCpvData;
import ro.cineseuita.data.cpv.entity.NationalCpvData;
import ro.cineseuita.data.cpv.entity.SupplierCpvData;
import ro.cineseuita.data.cpv.entity.components.CpvDataNode;
import ro.cineseuita.data.cpv.entity.components.CpvSimpleTreeNode;
import ro.cineseuita.data.cpv.repository.ContractingAuthorityCpvDataRepository;
import ro.cineseuita.data.cpv.repository.NationalCpvDataRepository;
import ro.cineseuita.data.cpv.repository.SupplierCpvDataRepository;
import ro.cineseuita.data.supplier.repository.SupplierDataRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import static ro.cineseuita.data.cpv.entity.ContractingAuthorityCpvData.formContractingAuthorityCpvDataFromCpvDataNode;

@Service
public class CpvDataService {

    private final DirectAcquisitionContractService directAcquisitionContractService;
    private final DirectAcquisitionContractRepository directAcquisitionContractRepository;
    private final NationalCpvDataRepository nationalCpvDataRepository;
    private final ContractingAuthorityDataRepository contractingAuthorityRepository;
    private final ContractingAuthorityCpvDataRepository contractingAuthorityCpvDataRepository;
    private final SupplierDataRepository supplierDataRepository;
    private final SupplierCpvDataRepository supplierCpvDataRepository;

    @Autowired
    public CpvDataService(DirectAcquisitionContractService directAcquisitionContractService, DirectAcquisitionContractRepository directAcquisitionContractRepository, NationalCpvDataRepository nationalCpvDataRepository, ContractingAuthorityDataRepository contractingAuthorityRepository, ContractingAuthorityCpvDataRepository contractingAuthorityCpvDataRepository, SupplierDataRepository supplierDataRepository, SupplierCpvDataRepository supplierCpvDataRepository) {
        this.directAcquisitionContractService = directAcquisitionContractService;
        this.directAcquisitionContractRepository = directAcquisitionContractRepository;
        this.nationalCpvDataRepository = nationalCpvDataRepository;
        this.contractingAuthorityRepository = contractingAuthorityRepository;
        this.contractingAuthorityCpvDataRepository = contractingAuthorityCpvDataRepository;
        this.supplierDataRepository = supplierDataRepository;
        this.supplierCpvDataRepository = supplierCpvDataRepository;
    }

    public CpvDataNode computeNationalWideCpvData(CpvSimpleTreeNode rootSimple) {

        CpvDataNode root = CpvDataNode.fromSimpleNode(rootSimple);
        long numberOfContracts = directAcquisitionContractRepository.count();

        Map<String, CpvDataNode> cpvDataNodeMap = new HashMap<>();
        // we create this map which we fill up with contracts data so that we don't have to search for the right node in the created tree
        // after the map is filled, we just feed it to the tree and in one traversal, we extract all the relevant info from the map and then compute whatever is left

        AtomicInteger i = new AtomicInteger();
        directAcquisitionContractService.getAllAcceptedDirectAcquisitionContractDetailsStreamed()
                .forEach(directAcquisitionContractDetails -> {
                            System.out.printf("Processing %d/%d\n", i.getAndIncrement(), numberOfContracts);
                            fillDataNodeMapForContract(directAcquisitionContractDetails, cpvDataNodeMap);
                        }
                );

        // now when we have all the data, we can just feed it to the tree
        root.getChildren().forEach(cpvDataNode -> feedDataToTree(cpvDataNode, cpvDataNodeMap));

        // trickle up the results
        root.getChildren().forEach(this::sumUpToParent);

        // save them in a more DB friendly manner
        root.getChildren().forEach(this::mapAndSaveNational);

        return root;
    }

    public void computeContractingAuthorityCpvData(CpvSimpleTreeNode rootSimple) {
        final long count = contractingAuthorityRepository.count();
        AtomicInteger i = new AtomicInteger();
        contractingAuthorityRepository.findAllJustIds()
                .parallelStream()
                .forEach(contractingAuthority -> {
                            CpvDataNode root = CpvDataNode.fromSimpleNode(rootSimple);
                            Map<String, CpvDataNode> cpvDataNodeMap = new HashMap<>();
                            System.out.printf("Computing cpv for contracting authority %d/%d\n", i.getAndIncrement(), count);
                            directAcquisitionContractService.getAllAcceptedDirectAcquisitionContractDetailsForContractingAuthorityStreamed(contractingAuthority.getId())
                                    .forEach(directAcquisitionContractDetails ->
                                    {
                                        fillDataNodeMapForContract(directAcquisitionContractDetails, cpvDataNodeMap);
                                    });

                            root.getChildren().forEach(cpvDataNode -> feedDataToTree(cpvDataNode, cpvDataNodeMap));

                            root.getChildren().forEach(this::sumUpToParent);

                            removeEmptySubtrees(root);
                            compressTree(root);

                            root.getChildren().forEach(cpvDataNode -> mapAndSaveContractingAuthority(cpvDataNode, contractingAuthority.getId()));

                            cpvDataNodeMap.clear();
                        }
                );
    }

    public void computeSupplierCpvData(CpvSimpleTreeNode rootSimple) {
        final long count = supplierDataRepository.count();
        AtomicInteger i = new AtomicInteger();
        supplierDataRepository.findAllJustIds()
                .parallelStream()
                .forEach(supplier -> {
                            CpvDataNode root = CpvDataNode.fromSimpleNode(rootSimple);
                            Map<String, CpvDataNode> cpvDataNodeMap = new HashMap<>();
                            System.out.printf("Computing cpv for supplier %d/%d\n", i.getAndIncrement(), count);
                            directAcquisitionContractService.getAllAcceptedDirectAcquisitionContractDetailsForSupplier(supplier.getId())
                                    .forEach(directAcquisitionContractDetails ->
                                    {
                                        fillDataNodeMapForContract(directAcquisitionContractDetails, cpvDataNodeMap);
                                    });

                            root.getChildren().forEach(cpvDataNode -> feedDataToTree(cpvDataNode, cpvDataNodeMap));

                            root.getChildren().forEach(this::sumUpToParent);

                            removeEmptySubtrees(root);
                            compressTree(root);

                            root.getChildren().forEach(cpvDataNode -> mapAndSaveSupplier(cpvDataNode, supplier.getId()));

                            cpvDataNodeMap.clear();
                        }
                );
    }

    private void fillDataNodeMapForContract(DirectAcquisitionContractDetails contract, Map<String, CpvDataNode> cpvDataNodeMap) {
        String contractCpvCode = contract.getCpvCode().getLocaleKey();

        List<DirectAcquisitionItem> directAcquisitionItems = contract.getDirectAcquisitionItems();

        directAcquisitionItems.forEach(item -> {
            String itemCpv = item.getCpvCode().getLocaleKey();
            if (!itemCpv.equals(contractCpvCode)) {
                System.out.printf("For contract %d, one or more items do not have the same CPV code as the contract\n", contract.get_id());
            }
            fillMapForItem(item, cpvDataNodeMap);
        });

        CpvDataNode dataNodeForContract = cpvDataNodeMap.getOrDefault(contractCpvCode, new CpvDataNode());
        dataNodeForContract.addToContracts(contract.get_id());
        cpvDataNodeMap.put(contractCpvCode, dataNodeForContract);
    }

    private void fillMapForItem(DirectAcquisitionItem item, Map<String, CpvDataNode> cpvDataNodeMap) {
        String itemCpv = item.getCpvCode().getLocaleKey();
        CpvDataNode dataNode = cpvDataNodeMap.getOrDefault(itemCpv, new CpvDataNode());

        dataNode.incrementTotal(item.getTotalItemCost());
        dataNode.feedToMeasurementStats(item);
        dataNode.incrementNumberOfItems(item.getItemQuantity().longValue());

        cpvDataNodeMap.put(itemCpv, dataNode);
    }

    private void feedDataToTree(CpvDataNode root, Map<String, CpvDataNode> cpvDataNodeMap) {
        fillNode(root, cpvDataNodeMap.getOrDefault(root.getCpvCode(), new CpvDataNode()));
        root.getChildren().forEach(child -> feedDataToTree(child, cpvDataNodeMap));
    }

    private void fillNode(CpvDataNode root, CpvDataNode cpvDataNode) {
        root.setNumberOfItems(cpvDataNode.getNumberOfItems());
        root.setTotal(cpvDataNode.getTotal());
        root.setNumberOfItems(cpvDataNode.getNumberOfItems());
        root.setItemMeasurementStats(cpvDataNode.getItemMeasurementStats());
        root.addToContracts(cpvDataNode.getContracts());
    }

    private void sumUpToParent(CpvDataNode child) {
        if (child.hasChildren()) {
            child.getChildren().forEach(this::sumUpToParent);
        }
        child.computeAverage();
        child.feedParent();
    }

    private void mapAndSaveNational(CpvDataNode cpvDataNode) {
        NationalCpvData nationalCpvData = NationalCpvData.formNationalCpvDataFromCpvDataNode(cpvDataNode);
        nationalCpvDataRepository.save(nationalCpvData);
        cpvDataNode.getChildren().forEach(this::mapAndSaveNational);
    }

    private void removeEmptySubtrees(CpvDataNode root) {
        if (root.hasChildren()) {
            root.getChildren().removeIf(node -> node.getNumberOfItems() == 0);
            root.getChildren().forEach(this::removeEmptySubtrees);
        }
    }

    private void compressTree(CpvDataNode root) {
        for (CpvDataNode child : root.getChildren()) {
            if (child.hasOnlyOneChild()) {
                CpvDataNode ancestor = findFurthestAncestorWithMoreThanOneOrNoChildren(child);
                child.getChildren().clear();
                child.getChildren().add(ancestor);
                ancestor.setParent(child);
            }
        }

    }

    private CpvDataNode findFurthestAncestorWithMoreThanOneOrNoChildren(CpvDataNode root) {
        CpvDataNode ancestor = root.getChildren().get(0);
        while (ancestor.hasOnlyOneChild()) {
            ancestor = ancestor.getChildren().get(0);
        }
        return ancestor;
    }

    private void mapAndSaveContractingAuthority(CpvDataNode cpvDataNode, Long contractingAuthorityId) {
        ContractingAuthorityCpvData contractingAuthorityCpvData = formContractingAuthorityCpvDataFromCpvDataNode(cpvDataNode, contractingAuthorityId);
        contractingAuthorityCpvDataRepository.save(contractingAuthorityCpvData);
        cpvDataNode.getChildren().forEach(dataNode -> mapAndSaveContractingAuthority(dataNode, contractingAuthorityId));
    }

    private void mapAndSaveSupplier(CpvDataNode cpvDataNode, Long supplierId) {
        SupplierCpvData supplierCpvData = SupplierCpvData.formSupplierCpvDataFromCpvDataNode(cpvDataNode, supplierId);
        supplierCpvDataRepository.save(supplierCpvData);
        cpvDataNode.getChildren().forEach(dataNode -> mapAndSaveSupplier(dataNode, supplierId));
    }
}
