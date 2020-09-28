package ro.cineseuita.data.contractingauthority.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.cineseuita.data.contract.entity.direct.DirectAcquisitionContractDetails;
import ro.cineseuita.data.contract.repository.DirectAcquisitionContractDetailsRepository;
import ro.cineseuita.data.contract.service.DirectAcquisitionContractService;
import ro.cineseuita.data.contractingauthority.entity.ContractingAuthorityDetails;
import ro.cineseuita.data.contractingauthority.entity.ContractingAuthorityWith5kMarginContracts;
import ro.cineseuita.data.contractingauthority.entity.components.ContractingAuthorities;
import ro.cineseuita.data.contractingauthority.repository.ContractingAuthorityDataRepository;
import ro.cineseuita.data.contractingauthority.repository.ContractingAuthorityDetailsRepository;
import ro.cineseuita.data.contractingauthority.repository.ContractingAuthorityWith5kMarginContractsRepository;
import ro.cineseuita.data.essentials.directcontract.entity.DirectAcquisitionContractMinimal;
import ro.cineseuita.data.essentials.contractingauthority.entity.ContractingAuthorityEssentials;
import ro.cineseuita.data.essentials.contractingauthority.repository.ContractingAuthorityEssentialsRepository;
import ro.cineseuita.data.essentials.service.ContractingAuthorityEssentialsMapperService;
import ro.cineseuita.data.essentials.service.DirectAcquisitionEssentialsMapperService;
import ro.cineseuita.data.shared.HttpService;
import ro.cineseuita.data.shared.ObjectMapperService;
import ro.cineseuita.data.shared.requests.seap.FetchContractingAuthorities;
import ro.cineseuita.data.shared.requests.seap.FetchContractingAuthorityDetails;

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
    private final ContractingAuthorityWith5kMarginContractsRepository contractingAuthorityWith5kMarginContractsRepository;
    private final DirectAcquisitionContractService directAcquisitionContractService;

    @Autowired
    public ContractingAuthorityService(ObjectMapperService objectMapperService,
                                       HttpService httpService,
                                       ContractingAuthorityEssentialsMapperService contractingAuthorityEssentialsMapperService, DirectAcquisitionEssentialsMapperService directAcquisitionEssentialsMapperService, ContractingAuthorityDataRepository contractingAuthorityRepository, ContractingAuthorityDetailsRepository contractingAuthorityDetailsRepository, ContractingAuthorityEssentialsRepository contractingAuthorityEssentialsRepository, DirectAcquisitionContractDetailsRepository directAcquisitionContractDetailsRepository, ContractingAuthorityWith5kMarginContractsRepository contractingAuthorityWith5kMarginContractsRepository, DirectAcquisitionContractService directAcquisitionContractService) {
        this.objectMapperService = objectMapperService;
        this.httpService = httpService;
        this.contractingAuthorityEssentialsMapperService = contractingAuthorityEssentialsMapperService;
        this.directAcquisitionEssentialsMapperService = directAcquisitionEssentialsMapperService;
        this.contractingAuthorityRepository = contractingAuthorityRepository;
        this.contractingAuthorityDetailsRepository = contractingAuthorityDetailsRepository;
        this.contractingAuthorityEssentialsRepository = contractingAuthorityEssentialsRepository;
        this.directAcquisitionContractDetailsRepository = directAcquisitionContractDetailsRepository;
        this.contractingAuthorityWith5kMarginContractsRepository = contractingAuthorityWith5kMarginContractsRepository;
        this.directAcquisitionContractService = directAcquisitionContractService;
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

    public void computeAllContractsWithin5kEurMarginForAllContractingAuthorities() {
        List<ContractingAuthorityDetails> contractingAuthorityDetailsList = contractingAuthorityDetailsRepository.findAll();

        for (int i = 0; i < contractingAuthorityDetailsList.size(); i++) {
            ContractingAuthorityDetails contractingAuthorityDetails = contractingAuthorityDetailsList.get(i);
            List<DirectAcquisitionContractDetails> contracts = directAcquisitionContractService.getAllAcceptedDirectAcquisitionContractDetailsForContractingAuthority(contractingAuthorityDetails.getId());

            List<DirectAcquisitionContractDetails> contractsOfInterest = contracts.stream().filter(contract -> isWithin5kBounds(contract.getSecondCurrencyClosingValue())).collect(toList());

            if (!contractsOfInterest.isEmpty()) {
                ContractingAuthorityWith5kMarginContracts contractingAuthorityWith5kMarginContracts = new ContractingAuthorityWith5kMarginContracts();
                contractingAuthorityWith5kMarginContracts.setContractingAuthorityId(contractingAuthorityDetails.getId());
                contractingAuthorityWith5kMarginContracts.addAllToContracts(contractsOfInterest);
                contractingAuthorityWith5kMarginContractsRepository.save(contractingAuthorityWith5kMarginContracts);
            }
            System.out.println("Done 5k margin computation for CA " + i + "/" + contractingAuthorityDetailsList.size());

        }

    }

    private static final double closenessFactorPercentage = 2;
    private static final double max = 5000;
    private static final double min = max - closenessFactorPercentage / 100 * max;

    private boolean isWithin5kBounds(Double closingValueInEur) {
        return closingValueInEur >= min && closingValueInEur <= max;
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
