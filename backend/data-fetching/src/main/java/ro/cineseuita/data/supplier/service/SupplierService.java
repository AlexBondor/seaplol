package ro.cineseuita.data.supplier.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.cineseuita.data.contract.entity.direct.DirectAcquisitionContractDetails;
import ro.cineseuita.data.contract.repository.DirectAcquisitionContractDetailsRepository;
import ro.cineseuita.data.essentials.entity.DirectAcquisitionContractMinimal;
import ro.cineseuita.data.essentials.entity.supplier.SupplierEssentials;
import ro.cineseuita.data.essentials.repository.SupplierEssentialsRepository;
import ro.cineseuita.data.essentials.service.DirectAcquisitionEssentialsMapperService;
import ro.cineseuita.data.essentials.service.SupplierEssentialsMapperService;
import ro.cineseuita.data.supplier.repository.SupplierDataRepository;
import ro.cineseuita.data.shared.HttpService;
import ro.cineseuita.data.shared.ObjectMapperService;
import ro.cineseuita.data.shared.requests.seap.FetchParticipants;
import ro.cineseuita.data.shared.requests.seap.FetchSupplierDetails;
import ro.cineseuita.data.shared.requests.seap.FetchSuppliers;
import ro.cineseuita.data.supplier.entity.SupplierDetails;
import ro.cineseuita.data.supplier.entity.components.Suppliers;
import ro.cineseuita.data.supplier.repository.SupplierDetailsRepository;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static java.util.stream.Collectors.toList;

@Service
public class SupplierService {
    private final SupplierEssentialsMapperService supplierEssentialsMapperService;
    private final DirectAcquisitionEssentialsMapperService directAcquisitionEssentialsMapperService;
    private final SupplierDetailsRepository supplierDetailsRepository;
    private final SupplierDataRepository supplierDataRepository;
    private final DirectAcquisitionContractDetailsRepository directAcquisitionContractDetailsRepository;
    private final SupplierEssentialsRepository supplierEssentialsRepository;
    private final HttpService httpService;
    private final ObjectMapperService objectMapperService;

    @Autowired
    public SupplierService(SupplierEssentialsMapperService supplierEssentialsMapperService, DirectAcquisitionEssentialsMapperService directAcquisitionEssentialsMapperService, SupplierDetailsRepository supplierDetailsRepository, SupplierDataRepository supplierDataRepository, DirectAcquisitionContractDetailsRepository directAcquisitionContractDetailsRepository, SupplierEssentialsRepository supplierEssentialsRepository, HttpService httpService, ObjectMapperService objectMapperService) {
        this.supplierEssentialsMapperService = supplierEssentialsMapperService;
        this.directAcquisitionEssentialsMapperService = directAcquisitionEssentialsMapperService;
        this.supplierDetailsRepository = supplierDetailsRepository;
        this.supplierDataRepository = supplierDataRepository;
        this.directAcquisitionContractDetailsRepository = directAcquisitionContractDetailsRepository;
        this.supplierEssentialsRepository = supplierEssentialsRepository;
        this.httpService = httpService;
        this.objectMapperService = objectMapperService;
    }

    public void mapSuppliersToEssentials() {
        List<SupplierDetails> suppliersDetails = supplierDetailsRepository.findAll();

        for (int i = 0; i < suppliersDetails.size(); i++) {
            SupplierDetails supplierDetails = suppliersDetails.get(i);
            SupplierEssentials supplierEssentials = supplierEssentialsMapperService.mapToSupplierWithContractsForDirectAcquisitionEssentials(supplierDetails);

            List<DirectAcquisitionContractDetails> directAcquisitionContractsForContractingAuthority = directAcquisitionContractDetailsRepository.findAllBySupplierId(supplierDetails.getId());

            List<DirectAcquisitionContractMinimal> minimalContracts = directAcquisitionContractsForContractingAuthority.stream()
                    .filter(DirectAcquisitionContractDetails::isAcceptedContract)
                    .map(directAcquisitionEssentialsMapperService::mapToDirectAcquisitionContractMinimal).collect(toList());
            double totalValue = minimalContracts.stream().mapToDouble(DirectAcquisitionContractMinimal::getClosingValue).sum();

            supplierEssentials.setContracts(minimalContracts);
            supplierEssentials.setTotalContractsValue(totalValue);
            supplierEssentials.setTotalContractsCount((long) minimalContracts.size());

            supplierEssentialsRepository.save(supplierEssentials);

            System.out.println("Mapped supplierDetails " + i + "/" + suppliersDetails.size());
        }
    }

    public void getAllSuppliersLite() throws IOException {
        FetchParticipants fetchSuppliersRequest;
        Suppliers suppliers;
        int pageIndex = 30;
        do {
            fetchSuppliersRequest = new FetchSuppliers(pageIndex++);
            String content = httpService.doRequest(fetchSuppliersRequest);
            suppliers = objectMapperService.mapToSuppliers(content);
            supplierDataRepository.saveAll(suppliers.getSuppliers());
            System.out.println("Fetched " + (pageIndex + 1) * fetchSuppliersRequest.getPageSize() + "/" + suppliers.getTotal() + " suppliers");
        } while (suppliers.getSuppliers().size() > 0);

        System.out.println("Done fetching lightweight suppliers");
    }

    public void getAllSupplierDetails() {
        AtomicInteger i = new AtomicInteger();
        supplierDataRepository.findAll()
                .stream()
                .parallel()
                .forEach(supplier -> {
                    i.getAndIncrement();
                    SupplierDetails supplierDetails = getSupplierDetails(supplier.getId());
                    supplierDetailsRepository.save(supplierDetails);
                    System.out.println("Fetched and saved details for " + supplier.getName() + " " + i);
                });
    }

    public SupplierDetails getSupplierDetails(Long supplierId) {
        SupplierDetails supplier = supplierDetailsRepository.findById(supplierId).orElse(null);
        if (supplier != null) {
            return supplier;
        }
        String supplierDetailsJsonContent;
        try {
            supplierDetailsJsonContent = httpService.doRequest(new FetchSupplierDetails(supplierId));
            return objectMapperService.mapToSupplier(supplierDetailsJsonContent);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
