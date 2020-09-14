package ro.cineseuita.contract.service;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.cineseuita.contract.entity.auction.AuctionAcquisitionContract;
import ro.cineseuita.contract.entity.auction.AuctionAcquisitionContracts;
import ro.cineseuita.contract.entity.auction.detailed.AuctionAcquisitionContractDetails;
import ro.cineseuita.contract.entity.auction.detailed.AuctionAcquisitionLots;
import ro.cineseuita.contract.entity.auction.detailed.AuctionAcquisitionSubcontracts;
import ro.cineseuita.contract.repository.AuctionAcquisitionContractDetailsRepository;
import ro.cineseuita.contract.repository.AuctionAcquisitionContractRepository;
import ro.cineseuita.shared.HttpService;
import ro.cineseuita.shared.ObjectMapperService;
import ro.cineseuita.shared.requests.*;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ForkJoinPool;

import static java.util.stream.Collectors.toList;

@Service
public class AuctionAcquisitionContractService {

    public static final int YEAR_OF_SEARCH = 2019;
    private static final int DAYS_INCREMENT_FOR_FETCHING_CONTRACTS = 1;
    private static final int THREAD_COUNT = 8;
    private final HttpService httpService;
    private final ObjectMapperService objectMapperService;
    private final AuctionAcquisitionContractRepository auctionAcquisitionContractRepository;
    private final AuctionAcquisitionContractDetailsRepository auctionAcquisitionContractDetailsRepository;

    @Autowired
    public AuctionAcquisitionContractService(HttpService httpService, ObjectMapperService objectMapperService, AuctionAcquisitionContractRepository auctionAcquisitionContractRepository, AuctionAcquisitionContractDetailsRepository auctionAcquisitionContractDetailsRepository) {
        this.httpService = httpService;
        this.objectMapperService = objectMapperService;
        this.auctionAcquisitionContractRepository = auctionAcquisitionContractRepository;
        this.auctionAcquisitionContractDetailsRepository = auctionAcquisitionContractDetailsRepository;
    }

    public void fullFetch() throws IOException {
        DateTime startDate = new DateTime().withYear(YEAR_OF_SEARCH).withDayOfYear(1).withTimeAtStartOfDay();
        DateTime endDate = startDate.withYear(YEAR_OF_SEARCH + 1).withDayOfYear(1).minusDays(1).withTime(23, 59, 0, 0);

//        DateTime startDate = new DateTime().withYear(2018).withMonthOfYear(9).withDayOfMonth(5);
//        DateTime endDate = startDate.withYear(2018).withMonthOfYear(9).withDayOfMonth(10);

        for (DateTime currentdate = startDate;
             currentdate.isBefore(endDate) || currentdate.isEqual(endDate);
             currentdate = currentdate.plusDays(DAYS_INCREMENT_FOR_FETCHING_CONTRACTS)) {

            int page = 0;
            int contractsFetchedSoFar = 0;

            AuctionAcquisitionContracts contracts = doFetchAuctionAcquisitionContracts(currentdate, page);

            contractsFetchedSoFar += contracts.getAuctionAcquisitionContracts().size();

            while (contracts.getTotal() > contractsFetchedSoFar) {
                page++;
                contracts = doFetchAuctionAcquisitionContracts(currentdate, page);
                contractsFetchedSoFar += contracts.getAuctionAcquisitionContracts().size();
            }

            System.out.println("Feteched a total of " + contractsFetchedSoFar + " auction contracts on " + currentdate);

        }
    }

    public void fullFetchAuctionAcquisitionContractDetails() {
        List<AuctionAcquisitionContract> auctionAcquisitionContracts = auctionAcquisitionContractRepository.findAll().stream().sorted(Comparator.comparing(AuctionAcquisitionContract::getCaNoticeId)).collect(toList());

        ForkJoinPool customThreadPool = new ForkJoinPool(THREAD_COUNT);
        customThreadPool.submit(
                () -> auctionAcquisitionContracts.parallelStream().forEach(
                        this::tryDoFetchAuctionAcquisitionContractDetails
                ));
    }

    private void doFetchAuctionAcquisitionContractDetails(AuctionAcquisitionContract auctionAcquisitionContract) throws IOException {
        FetchAuctionAcquisitionContractDetails fetchAuctionAcquisitionContractDetails = new FetchAuctionAcquisitionContractDetails(auctionAcquisitionContract.getCaNoticeId());
        String auctionAcquisitionContractDetailsJsonContent = httpService.doRequest(fetchAuctionAcquisitionContractDetails);
        AuctionAcquisitionContractDetails auctionAcquisitionContractDetails = objectMapperService.mapToAuctionAcquisitionContractDetails(auctionAcquisitionContractDetailsJsonContent);

        AuctionAcquisitionSubcontracts auctionAcquisitionSubcontracts = doFetchAuctionAcquisitionSubcontracts(auctionAcquisitionContractDetails);
        AuctionAcquisitionLots auctionAcquisitionLots = doFetchAuctionAcquisitionLots(auctionAcquisitionContractDetails);

        auctionAcquisitionContractDetails.setAuctionAcquisitionSubcontracts(auctionAcquisitionSubcontracts);
        auctionAcquisitionContractDetails.setAuctionAcquisitionLots(auctionAcquisitionLots);

        System.out.println("Fetched details for " + auctionAcquisitionContract.getCaNoticeId());

        auctionAcquisitionContractDetailsRepository.save(auctionAcquisitionContractDetails);
    }

    private AuctionAcquisitionSubcontracts doFetchAuctionAcquisitionSubcontracts(AuctionAcquisitionContractDetails auctionAcquisitionContractDetails) throws IOException {
        FetchAuctionAcquisitionSubcontracts fetchAuctionAcquisitionSubcontracts = new FetchAuctionAcquisitionSubcontracts(auctionAcquisitionContractDetails.getCaNoticeID());
        String auctionAcquisitionSubcontractsJsonContent = httpService.doRequest(fetchAuctionAcquisitionSubcontracts);
        return objectMapperService.mapToAuctionAcquisitionSubcontracts(auctionAcquisitionSubcontractsJsonContent);
    }

    private AuctionAcquisitionLots doFetchAuctionAcquisitionLots(AuctionAcquisitionContractDetails auctionAcquisitionContractDetails) throws IOException {
        FetchAuctionAcquisitionLots fetchAuctionAcquisitionLots = new FetchAuctionAcquisitionLots(auctionAcquisitionContractDetails.getCaNoticeID());
        String auctionAcquisitionLotsJsonContent = httpService.doRequest(fetchAuctionAcquisitionLots);
        return objectMapperService.mapToAuctionAcquisitionLots(auctionAcquisitionLotsJsonContent);
    }

    private AuctionAcquisitionContracts doFetchAuctionAcquisitionContracts(DateTime currentDate, int page) throws IOException {
        FetchAuctionAcquisitionContracts fetchAuctionAcquisitionContracts = new FetchAuctionAcquisitionContractsRequestBuilder().buildDefault();
        fetchAuctionAcquisitionContracts.setStartPublicationDate(currentDate);
        fetchAuctionAcquisitionContracts.setEndPublicationDate(currentDate);
        fetchAuctionAcquisitionContracts.setPageIndex((long) page);

        String auctionAcquisitionContractsJsonContent = httpService.doRequest(fetchAuctionAcquisitionContracts);
        AuctionAcquisitionContracts contracts = objectMapperService.mapToAuctionAcquisitionContracts(auctionAcquisitionContractsJsonContent);
        contracts.getAuctionAcquisitionContracts().forEach(auctionAcquisitionContract -> auctionAcquisitionContract.setYear(YEAR_OF_SEARCH));
        auctionAcquisitionContractRepository.saveAll(contracts.getAuctionAcquisitionContracts());
        return contracts;
    }

    private void tryDoFetchAuctionAcquisitionContractDetails(AuctionAcquisitionContract contract) {
        try {
            doFetchAuctionAcquisitionContractDetails(contract);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
