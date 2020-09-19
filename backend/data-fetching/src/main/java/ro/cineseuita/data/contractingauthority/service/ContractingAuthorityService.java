package ro.cineseuita.data.contractingauthority.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.cineseuita.data.contract.entity.direct.DirectAcquisitionContractDetails;
import ro.cineseuita.data.contract.repository.DirectAcquisitionContractDetailsRepository;
import ro.cineseuita.data.contractingauthority.entity.ContractingAuthorityDetails;
import ro.cineseuita.data.contractingauthority.entity.components.ContractingAuthorities;
import ro.cineseuita.data.contractingauthority.repository.ContractingAuthorityDetailsRepository;
import ro.cineseuita.data.contractingauthority.repository.ContractingAuthorityDataRepository;
import ro.cineseuita.data.essentials.entity.DirectAcquisitionContractMinimal;
import ro.cineseuita.data.essentials.entity.contractingauthority.ContractingAuthorityEssentials;
import ro.cineseuita.data.essentials.repository.ContractingAuthorityEssentialsRepository;
import ro.cineseuita.data.essentials.service.ContractingAuthorityEssentialsMapperService;
import ro.cineseuita.data.essentials.service.DirectAcquisitionEssentialsMapperService;
import ro.cineseuita.data.shared.HttpService;
import ro.cineseuita.data.shared.ObjectMapperService;
import ro.cineseuita.data.shared.requests.FetchContractingAuthorities;
import ro.cineseuita.data.shared.requests.FetchContractingAuthorityDetails;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static java.util.stream.Collectors.toList;

@Service
public class ContractingAuthorityService {

    private final HttpService httpService;
    private final ObjectMapperService objectMapperService;
    private final ContractingAuthorityEssentialsMapperService contractingAuthorityEssentialsMapperService;
    private final DirectAcquisitionEssentialsMapperService directAcquisitionEssentialsMapperService;
    private final ContractingAuthorityDataRepository contractingAuthorityRepository;
    private final ContractingAuthorityDetailsRepository contractingAuthorityDetailsRepository;
    private final ContractingAuthorityEssentialsRepository contractingAuthorityEssentialsRepository;
    private final DirectAcquisitionContractDetailsRepository directAcquisitionContractDetailsRepository;

    @Autowired
    public ContractingAuthorityService(ObjectMapperService objectMapperService,
                                       HttpService httpService,
                                       ContractingAuthorityEssentialsMapperService contractingAuthorityEssentialsMapperService, DirectAcquisitionEssentialsMapperService directAcquisitionEssentialsMapperService, ContractingAuthorityDataRepository contractingAuthorityRepository, ContractingAuthorityDetailsRepository contractingAuthorityDetailsRepository, ContractingAuthorityEssentialsRepository contractingAuthorityEssentialsRepository, DirectAcquisitionContractDetailsRepository directAcquisitionContractDetailsRepository) {
        this.objectMapperService = objectMapperService;
        this.httpService = httpService;
        this.contractingAuthorityEssentialsMapperService = contractingAuthorityEssentialsMapperService;
        this.directAcquisitionEssentialsMapperService = directAcquisitionEssentialsMapperService;
        this.contractingAuthorityRepository = contractingAuthorityRepository;
        this.contractingAuthorityDetailsRepository = contractingAuthorityDetailsRepository;
        this.contractingAuthorityEssentialsRepository = contractingAuthorityEssentialsRepository;
        this.directAcquisitionContractDetailsRepository = directAcquisitionContractDetailsRepository;
    }

    public void fetchAllContractingAuthoritiesLite() throws IOException {
        FetchContractingAuthorities fetchContractingAuthoritiesRequest;
        ContractingAuthorities contractingAuthorities;
        int pageIndex = 0;
        do {
            fetchContractingAuthoritiesRequest = new FetchContractingAuthorities(pageIndex++);
            String content = httpService.doRequest(fetchContractingAuthoritiesRequest);
            contractingAuthorities = objectMapperService.mapToContractingAuthorities(content);
            contractingAuthorityRepository.saveAll(contractingAuthorities.getContractingAuthorities());
            System.out.println("Fetched " + (pageIndex + 1) * fetchContractingAuthoritiesRequest.getPageSize() + "/" + contractingAuthorities.getTotal() + " contractingAuthorities");

        } while (contractingAuthorities.getContractingAuthorities().size() > 0);

        System.out.println("Done fetching lightweight contracting authorities");
    }

    public void fetchAllContractingAuthorityDetails() {
        AtomicInteger i = new AtomicInteger();
        contractingAuthorityRepository.findAll()
                .stream()
                .parallel()
                .forEach(contractingAuthority -> {
                    i.getAndIncrement();
                    ContractingAuthorityDetails contractingAuthorityDetails = getContractingAuthorityDetails(contractingAuthority.getId());
                    contractingAuthorityDetailsRepository.save(contractingAuthorityDetails);
                    System.out.println("Fetched and saved contracting authority details for " + contractingAuthority.getName() + " " + i);
                });
    }

    public ContractingAuthorityDetails getContractingAuthorityDetails(Long id) {
        ContractingAuthorityDetails contractingAuthorityDetails = contractingAuthorityDetailsRepository.findById(id).orElse(null);
        if (contractingAuthorityDetails != null) {
            return contractingAuthorityDetails;
        }

        String content;
        try {
            content = httpService.doRequest(new FetchContractingAuthorityDetails(id));
            return objectMapperService.mapToContractingAuthorityDetails(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void mapContractingAuthoritiesToEssentials() {
        List<ContractingAuthorityDetails> contractingAuthorityDetailsList = contractingAuthorityDetailsRepository.findAll();
        List<ContractingAuthorityEssentials> essentials = new ArrayList<>();

        for (int i = 0; i < contractingAuthorityDetailsList.size(); i++) {
            ContractingAuthorityDetails contractingAuthorityDetails = contractingAuthorityDetailsList.get(i);
            ContractingAuthorityEssentials contractingAuthorityEssentials = contractingAuthorityEssentialsMapperService.mapToContractingAuthorityWithContractsEssentials(contractingAuthorityDetails);


            List<DirectAcquisitionContractDetails> directAcquisitionContractsForCA =
                    directAcquisitionContractDetailsRepository.findAllByContractingAuthorityID(contractingAuthorityDetails.getId());
            List<DirectAcquisitionContractMinimal> minimalContracts = directAcquisitionContractsForCA
                    .stream()
                    .filter(DirectAcquisitionContractDetails::isAcceptedContract)
                    .map(directAcquisitionEssentialsMapperService::mapToDirectAcquisitionContractMinimal)
                    .collect(toList());
            double totalValue = minimalContracts
                    .stream()
                    .mapToDouble(DirectAcquisitionContractMinimal::getClosingValue)
                    .sum();

            contractingAuthorityEssentials.setContracts(minimalContracts);
            contractingAuthorityEssentials.setTotalContractsCount((long) minimalContracts.size());
            contractingAuthorityEssentials.setTotalContractsValue(totalValue);

            essentials.add(contractingAuthorityEssentials);
            System.out.println("Done CA essentials " + i + "/" + contractingAuthorityDetailsList.size());
        }
        contractingAuthorityEssentialsRepository.saveAll(essentials);
    }

    public void computeContractingAuthorityCorruption() {
        List<ContractingAuthorityDetails> contractingAuthorities = contractingAuthorityDetailsRepository.findAll();
        for (ContractingAuthorityDetails contractingAuthority : contractingAuthorities) {
            List<DirectAcquisitionContractDetails> allContractsOfContractingAuthority = directAcquisitionContractDetailsRepository.findAllByContractingAuthorityID(contractingAuthority.getId());

            double sumOfAllContracts = allContractsOfContractingAuthority.stream().mapToDouble(DirectAcquisitionContractDetails::getClosingValue).sum();


        }

    }


}


/*

  --- check uniqueness of cAs (just safety precaution) ---

  db.getCollection('contractingAuthority').aggregate([
      {$group: {
          _id: {id: "$_id"} ,
          uniqueIds: {$addToSet: "$_id"},
          count: {$sum: 1}
          }
      },
      {$match: {
          count: {"$gt": 1}
          }
      }
  ])


 */
