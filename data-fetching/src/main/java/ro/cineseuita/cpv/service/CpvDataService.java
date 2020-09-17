package ro.cineseuita.cpv.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.cineseuita.contract.entity.direct.DirectAcquisitionContractDetails;
import ro.cineseuita.contract.entity.direct.components.DirectAcquisitionItem;
import ro.cineseuita.contract.repository.DirectAcquisitionContractRepository;
import ro.cineseuita.contract.service.DirectAcquisitionContractService;
import ro.cineseuita.contractingauthority.repository.ContractingAuthorityRepository;
import ro.cineseuita.cpv.entity.ContractingAuthorityCpvData;
import ro.cineseuita.cpv.entity.NationalCpvData;
import ro.cineseuita.cpv.entity.components.CpvDataNode;
import ro.cineseuita.cpv.entity.components.CpvSimpleTreeNode;
import ro.cineseuita.cpv.repository.ContractingAuthorityCpvDataRepository;
import ro.cineseuita.cpv.repository.NationalCpvDataRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import static ro.cineseuita.cpv.entity.ContractingAuthorityCpvData.formContractingAuthorityCpvDataFromCpvDataNode;
import static ro.cineseuita.cpv.entity.NationalCpvData.formNationalCpvDataFromCpvDataNode;
import static ro.cineseuita.cpv.entity.components.CpvDataNode.fromSimpleNode;

@Service
public class CpvDataService {

    private final DirectAcquisitionContractService directAcquisitionContractService;
    private final DirectAcquisitionContractRepository directAcquisitionContractRepository;
    private final NationalCpvDataRepository nationalCpvDataRepository;
    private final ContractingAuthorityRepository contractingAuthorityRepository;
    private final ContractingAuthorityCpvDataRepository contractingAuthorityCpvDataRepository;

    @Autowired
    public CpvDataService(DirectAcquisitionContractService directAcquisitionContractService, DirectAcquisitionContractRepository directAcquisitionContractRepository, NationalCpvDataRepository nationalCpvDataRepository, ContractingAuthorityRepository contractingAuthorityRepository, ContractingAuthorityCpvDataRepository contractingAuthorityCpvDataRepository) {
        this.directAcquisitionContractService = directAcquisitionContractService;
        this.directAcquisitionContractRepository = directAcquisitionContractRepository;
        this.nationalCpvDataRepository = nationalCpvDataRepository;
        this.contractingAuthorityRepository = contractingAuthorityRepository;
        this.contractingAuthorityCpvDataRepository = contractingAuthorityCpvDataRepository;
    }

    public CpvDataNode computeNationalWideCpvData(CpvSimpleTreeNode rootSimple) {

        CpvDataNode root = fromSimpleNode(rootSimple);
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
        CpvDataNode root = fromSimpleNode(rootSimple);

        final long count = contractingAuthorityRepository.count();
        AtomicInteger i = new AtomicInteger();
        contractingAuthorityRepository.findAllJustIds()
                .parallelStream()
                .forEach(contractingAuthority -> {
                            Map<String, CpvDataNode> cpvDataNodeMap = new HashMap<>();
                            System.out.printf("Computing cpv for contracting authority %d/%d\n", i.getAndIncrement(), count);
                            directAcquisitionContractService.getAllAcceptedDirectAcquisitionContractDetailsForContractingAuthorityStreamed(contractingAuthority.getId())
                                    .forEach(directAcquisitionContractDetails ->
                                    {
                                        fillDataNodeMapForContract(directAcquisitionContractDetails, cpvDataNodeMap);
                                    });

                            root.getChildren().forEach(cpvDataNode -> feedDataToTree(cpvDataNode, cpvDataNodeMap));

                            root.getChildren().forEach(this::sumUpToParent);

                            root.getChildren().forEach(cpvDataNode -> mapAndSaveContractingAuthority(cpvDataNode, contractingAuthority.getId()));

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
        NationalCpvData nationalCpvData = formNationalCpvDataFromCpvDataNode(cpvDataNode);
        nationalCpvDataRepository.save(nationalCpvData);
        cpvDataNode.getChildren().forEach(this::mapAndSaveNational);
    }

    private void mapAndSaveContractingAuthority(CpvDataNode cpvDataNode, Long contractingAuthorityId) {
        ContractingAuthorityCpvData nationalCpvData = formContractingAuthorityCpvDataFromCpvDataNode(cpvDataNode, contractingAuthorityId);
        contractingAuthorityCpvDataRepository.save(nationalCpvData);
        cpvDataNode.getChildren().forEach(dataNode -> mapAndSaveContractingAuthority(dataNode, contractingAuthorityId));
    }
}
