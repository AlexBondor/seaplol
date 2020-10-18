package ro.cineseuita.data.contractingauthority.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.cineseuita.data.contract.direct.entity.DirectAcquisitionContractDetails;
import ro.cineseuita.data.contract.direct.repository.DirectAcquisitionContractDetailsRepository;
import ro.cineseuita.data.contract.direct.service.DirectAcquisitionContractFetchService;
import ro.cineseuita.data.contractingauthority.entity.ContractingAuthorityDetails;
import ro.cineseuita.data.contractingauthority.entity.components.ContractingAuthorities;
import ro.cineseuita.data.contractingauthority.repository.ContractingAuthorityDataRepository;
import ro.cineseuita.data.contractingauthority.repository.ContractingAuthorityDetailsRepository;
import ro.cineseuita.data.essentials.contractingauthority.entity.ContractingAuthorityEssentials;
import ro.cineseuita.data.essentials.contractingauthority.repository.ContractingAuthorityEssentialsRepository;
import ro.cineseuita.data.essentials.mappers.ContractingAuthorityEssentialsMapperService;
import ro.cineseuita.data.essentials.mappers.DirectAcquisitionEssentialsMapperService;
import ro.cineseuita.data.shared.HttpService;
import ro.cineseuita.data.shared.ObjectMapperService;
import ro.cineseuita.data.shared.requests.seap.FetchContractingAuthorities;
import ro.cineseuita.data.shared.requests.seap.FetchContractingAuthorityDetails;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static ro.cineseuita.data.contract.direct.entity.components.DirectAcquisitionState.OFERTA_ACCEPTATA;

@Service
public class ContractingAuthorityService {

    private static final double closenessFactorPercentage = 2;
    private static final double max = 5000;
    private static final double min = max - closenessFactorPercentage / 100 * max;
    private final HttpService httpService;
    private final ObjectMapperService objectMapperService;
    private final ContractingAuthorityEssentialsMapperService contractingAuthorityEssentialsMapperService;
    private final DirectAcquisitionEssentialsMapperService directAcquisitionEssentialsMapperService;
    private final ContractingAuthorityDataRepository contractingAuthorityRepository;
    private final ContractingAuthorityDetailsRepository contractingAuthorityDetailsRepository;
    private final ContractingAuthorityEssentialsRepository contractingAuthorityEssentialsRepository;
    private final DirectAcquisitionContractDetailsRepository directAcquisitionContractDetailsRepository;
    private final DirectAcquisitionContractFetchService directAcquisitionContractFetchService;

    @Autowired
    public ContractingAuthorityService(ObjectMapperService objectMapperService,
                                       HttpService httpService,
                                       ContractingAuthorityEssentialsMapperService contractingAuthorityEssentialsMapperService, DirectAcquisitionEssentialsMapperService directAcquisitionEssentialsMapperService, ContractingAuthorityDataRepository contractingAuthorityRepository, ContractingAuthorityDetailsRepository contractingAuthorityDetailsRepository, ContractingAuthorityEssentialsRepository contractingAuthorityEssentialsRepository, DirectAcquisitionContractDetailsRepository directAcquisitionContractDetailsRepository, DirectAcquisitionContractFetchService directAcquisitionContractFetchService) {
        this.objectMapperService = objectMapperService;
        this.httpService = httpService;
        this.contractingAuthorityEssentialsMapperService = contractingAuthorityEssentialsMapperService;
        this.directAcquisitionEssentialsMapperService = directAcquisitionEssentialsMapperService;
        this.contractingAuthorityRepository = contractingAuthorityRepository;
        this.contractingAuthorityDetailsRepository = contractingAuthorityDetailsRepository;
        this.contractingAuthorityEssentialsRepository = contractingAuthorityEssentialsRepository;
        this.directAcquisitionContractDetailsRepository = directAcquisitionContractDetailsRepository;
        this.directAcquisitionContractFetchService = directAcquisitionContractFetchService;
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

    private boolean isWithin5kBounds(Double closingValueInEur) {
        return closingValueInEur >= min && closingValueInEur <= max;
    }

    public void mapContractingAuthoritiesToEssentials() {
        List<ContractingAuthorityDetails> contractingAuthorityDetailsList = contractingAuthorityDetailsRepository.findAll();
        List<ContractingAuthorityEssentials> essentials = new ArrayList<>();
        AtomicInteger i = new AtomicInteger();
        contractingAuthorityDetailsList.stream().parallel().forEach(contractingAuthorityDetails -> {
            ContractingAuthorityEssentials contractingAuthorityEssentials = contractingAuthorityEssentialsMapperService.mapToContractingAuthorityWithContractsEssentials(contractingAuthorityDetails);
            List<DirectAcquisitionContractDetails> contractsForCA =
                    directAcquisitionContractDetailsRepository.findAllBySysDirectAcquisitionStateIDAndContractingAuthorityID(OFERTA_ACCEPTATA.getNumVal(), contractingAuthorityDetails.getId());
            double totalValue = contractsForCA
                    .stream()
                    .mapToDouble(DirectAcquisitionContractDetails::getClosingValue)
                    .sum();
            double totalValueSecondCurrency = contractsForCA
                    .stream()
                    .mapToDouble(DirectAcquisitionContractDetails::getSecondCurrencyClosingValue)
                    .sum();
            contractingAuthorityEssentials.setTotalContractsCount((long) contractsForCA.size());
            contractingAuthorityEssentials.setTotalContractsValue(totalValue);
            contractingAuthorityEssentials.setTotalContractsValueSecondCurrency(totalValueSecondCurrency);
            essentials.add(contractingAuthorityEssentials);
            System.out.println("Done CA essentials " + i.getAndIncrement() + "/" + contractingAuthorityDetailsList.size());
        });
        contractingAuthorityEssentialsRepository.saveAll(essentials);
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
