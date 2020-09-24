package ro.cineseuita.data.contract.service;

import ro.cineseuita.data.contract.entity.direct.DirectAcquisitionContractDetails;
import ro.cineseuita.data.contract.repository.DirectAcquisitionContractDetailsRepository;
import ro.cineseuita.data.shared.HttpService;
import ro.cineseuita.data.shared.ObjectMapperService;
import ro.cineseuita.data.shared.requests.seap.FetchDirectAcquisitionContractDetails;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class DirectAcquisitionContractExecutor implements Runnable {

    private final HttpService httpService;
    private final ObjectMapperService objectMapperService;
    private final DirectAcquisitionContractDetailsRepository directAcquisitionContractDetailsRepository;
    private final Integer yearOfSearch;
    private List<Long> directAcquisitionContractIds;
    private CountDownLatch countDownLatch;


    DirectAcquisitionContractExecutor(HttpService httpService,
                                      ObjectMapperService objectMapperService, DirectAcquisitionContractDetailsRepository directAcquisitionContractDetailsRepository, List<Long> directAcquisitionContractIds,
                                      CountDownLatch countDownLatch, Integer yearOfSearch) {
        this.httpService = httpService;
        this.objectMapperService = objectMapperService;
        this.directAcquisitionContractDetailsRepository = directAcquisitionContractDetailsRepository;
        this.directAcquisitionContractIds = directAcquisitionContractIds;
        this.countDownLatch = countDownLatch;
        this.yearOfSearch = yearOfSearch;
    }

    @Override
    public void run() {
        for (Long directAcquisitionContract : directAcquisitionContractIds) {
            executeFetchDirectAcquisition(directAcquisitionContract);
        }

        countDownLatch.countDown();
    }


    private void executeFetchDirectAcquisition(Long directAcquisitionContractId) {
        if (!directAcquisitionContractDetailsRepository.existsById(directAcquisitionContractId)) {
            try {
                executeGetAndSaveDirectAcquisitionContract(directAcquisitionContractId);
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        } else {
            System.out.println("Direct Aquisition Contract " + directAcquisitionContractId + " already fetched");
        }
    }

    private void executeGetAndSaveDirectAcquisitionContract(Long directAcquisitionId) throws IOException {
        DirectAcquisitionContractDetails directAcquisitionContractDetails = getDirectAcquisitionContractDetails(directAcquisitionId);
        directAcquisitionContractDetails.set_id(directAcquisitionContractDetails.getDirectAcquisitionID());
        directAcquisitionContractDetails.setYear(this.yearOfSearch);
        directAcquisitionContractDetailsRepository.save(directAcquisitionContractDetails);
    }

    private DirectAcquisitionContractDetails getDirectAcquisitionContractDetails(Long directAcquisitionId) throws IOException {
        String directAcquisitionContractDetailsJsonContent = httpService.doRequest(new FetchDirectAcquisitionContractDetails(directAcquisitionId));
        return objectMapperService.mapToDirectAcquisitionContractDetails(directAcquisitionContractDetailsJsonContent);
    }

}
