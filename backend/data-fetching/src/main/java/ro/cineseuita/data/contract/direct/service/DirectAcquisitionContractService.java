package ro.cineseuita.data.contract.direct.service;

import org.joda.time.DateTime;
import org.joda.time.Interval;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import ro.cineseuita.data.contract.direct.entity.DirectAcquisitionContract;
import ro.cineseuita.data.contract.direct.entity.DirectAcquisitionContractDetails;
import ro.cineseuita.data.contract.direct.entity.components.DirectAcquisitionContracts;
import ro.cineseuita.data.contract.direct.repository.DirectAcquisitionContractDetailsRepository;
import ro.cineseuita.data.contract.direct.repository.DirectAcquisitionContractRepository;
import ro.cineseuita.data.contractingauthority.entity.ContractingAuthority;
import ro.cineseuita.data.contractingauthority.repository.ContractingAuthorityDataRepository;
import ro.cineseuita.data.contractingauthority.repository.ContractingAuthorityDetailsRepository;
import ro.cineseuita.data.essentials.directcontract.repository.DirectContractEssentialsRepository;
import ro.cineseuita.data.essentials.mappers.DirectAcquisitionEssentialsMapperService;
import ro.cineseuita.data.shared.HttpService;
import ro.cineseuita.data.shared.ObjectMapperService;
import ro.cineseuita.data.shared.requests.seap.FetchDirectAcquisitionContracts;
import ro.cineseuita.data.shared.requests.seap.FetchDirectAcquisitionContractsRequestBuilder;
import ro.cineseuita.data.supplier.repository.SupplierDetailsRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Collections.singletonList;
import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;
import static org.springframework.data.domain.PageRequest.of;
import static ro.cineseuita.data.contract.direct.entity.components.DirectAcquisitionState.OFERTA_ACCEPTATA;
import static ro.cineseuita.data.shared.ListManipulator.chunks;

@Service
public class DirectAcquisitionContractService {

    public static final int LIMIT = 50000;
    private static final int MAX_PAGE_SIZE = 2000;
    private static final int MONTH_INTERVAL = 2;
    private static final int NR_THREADS = 4;
    private final HttpService httpService;
    private final ObjectMapperService objectMapperService;
    private final DirectAcquisitionEssentialsMapperService directAcquisitionEssentialsMapperService;
    private final SupplierDetailsRepository supplierDetailsRepository;
    private final ContractingAuthorityDataRepository contractingAuthorityRepository;
    private final ContractingAuthorityDetailsRepository contractingAuthorityDetailsRepository;
    private final DirectContractEssentialsRepository directContractEssentialsRepository;
    private final DirectAcquisitionContractDetailsRepository directAcquisitionContractDetailsRepository;
    private final DirectAcquisitionContractRepository directAcquisitionContractRepository;

    private Integer yearForSearch;

    @Autowired
    public DirectAcquisitionContractService(HttpService httpService, ObjectMapperService objectMapperService, DirectAcquisitionEssentialsMapperService directAcquisitionEssentialsMapperService, SupplierDetailsRepository supplierDetailsRepository, ContractingAuthorityDataRepository contractingAuthorityRepository, ContractingAuthorityDetailsRepository contractingAuthorityDetailsRepository, DirectContractEssentialsRepository directContractEssentialsRepository, DirectAcquisitionContractDetailsRepository directAcquisitionContractDetailsRepository, DirectAcquisitionContractRepository directAcquisitionContractRepository) {
        this.httpService = httpService;
        this.objectMapperService = objectMapperService;
        this.directAcquisitionEssentialsMapperService = directAcquisitionEssentialsMapperService;
        this.supplierDetailsRepository = supplierDetailsRepository;
        this.contractingAuthorityRepository = contractingAuthorityRepository;
        this.contractingAuthorityDetailsRepository = contractingAuthorityDetailsRepository;
        this.directContractEssentialsRepository = directContractEssentialsRepository;
        this.directAcquisitionContractDetailsRepository = directAcquisitionContractDetailsRepository;
        this.directAcquisitionContractRepository = directAcquisitionContractRepository;
    }

    public Stream<DirectAcquisitionContractDetails> getAllAcceptedDirectAcquisitionContractDetailsForContractingAuthorityStreamed(Long contractingAuthorityId) {
        int range = (int) (directAcquisitionContractDetailsRepository.count() / LIMIT) + 1;
        return IntStream.rangeClosed(0, range)
                .mapToObj(skip ->
                        directAcquisitionContractDetailsRepository.findAllBySysDirectAcquisitionStateIDAndContractingAuthorityID(
                                OFERTA_ACCEPTATA.getNumVal(), contractingAuthorityId, of(skip, LIMIT)
                        ).getContent()
                )
                .flatMap(Collection::stream);
    }

    public List<DirectAcquisitionContractDetails> getAllAcceptedDirectAcquisitionContractDetailsForContractingAuthority(Long contractingAuthorityId) {
        return directAcquisitionContractDetailsRepository.findAllBySysDirectAcquisitionStateIDAndContractingAuthorityID(
                OFERTA_ACCEPTATA.getNumVal(), contractingAuthorityId
        );
    }

    public Stream<DirectAcquisitionContractDetails> getAllAcceptedDirectAcquisitionContractDetailsForSupplier(Long supplierId) {
        int range = (int) (directAcquisitionContractDetailsRepository.count() / LIMIT) + 1;
        return IntStream.rangeClosed(0, range)
                .mapToObj(skip ->
                        directAcquisitionContractDetailsRepository.findAllBySysDirectAcquisitionStateIDAndSupplierId(
                                OFERTA_ACCEPTATA.getNumVal(), supplierId, of(skip, LIMIT)
                        ).getContent()
                )
                .flatMap(Collection::stream);
    }

    public Stream<DirectAcquisitionContractDetails> getAllAcceptedDirectAcquisitionContractDetailsStreamed() {
        int range = (int) (directAcquisitionContractDetailsRepository.count() / LIMIT) + 1;
        return IntStream.rangeClosed(0, range)
                .mapToObj(skip ->
                        directAcquisitionContractDetailsRepository.findAllBySysDirectAcquisitionStateID(
                                OFERTA_ACCEPTATA.getNumVal(), of(skip, LIMIT)
                        ).getContent()
                )
                .flatMap(Collection::stream);
    }

    public Stream<DirectAcquisitionContract> getAllDirectAcquisitionContractsStreamed() {
        int range = (int) (directAcquisitionContractRepository.count() / LIMIT) + 1;
        return IntStream.rangeClosed(0, range)
                .mapToObj(skip -> directAcquisitionContractRepository.findAll(PageRequest.of(skip, LIMIT)).getContent())
                .flatMap(Collection::stream);
    }

    public Stream<DirectAcquisitionContractDetails> getAllDirectAcquisitionContractsDetailsStreamed() {
        int range = (int) (directAcquisitionContractDetailsRepository.count() / LIMIT) + 1;
        return IntStream.rangeClosed(0, range)
                .mapToObj(skip -> directAcquisitionContractDetailsRepository.findAll(PageRequest.of(skip, LIMIT)).getContent())
                .flatMap(Collection::stream);
    }

    public void fullFetch(Integer yearForSearch) throws IOException, InterruptedException {
        this.yearForSearch = yearForSearch;
        final DateTime firstDayOfYear = DateTime.parse(yearForSearch.toString() + "-01-01T00:00:00.000Z");
        final DateTime lastDayOfYear = DateTime.parse(yearForSearch.toString() + "-12-31T12:59:00.000Z");
        Interval interval = new Interval(firstDayOfYear, lastDayOfYear);

        int nrContractingAuthorities = 0;

        List<ContractingAuthority> contractingAuthorities = contractingAuthorityRepository.findAll()
                .stream()
                .sorted(comparing(ContractingAuthority::getId))
                .collect(toList());

        for (int i = nrContractingAuthorities; i < contractingAuthorities.size(); i++) { // where we left off
            executeFullFetch(contractingAuthorities, i, interval);
        }
    }


    public void mapDirectAcquisitionsToEssentials() {
        AtomicInteger i = new AtomicInteger();
        getAllDirectAcquisitionContractsDetailsStreamed()
                .parallel()
                .map(directAcquisitionEssentialsMapperService::mapToDirectAcquisitionContractEssentials)
                .forEach(s -> {
                    directContractEssentialsRepository.save(s);
                    System.out.printf("Done contract %d\n", i.getAndIncrement());
                });
    }

    private void executeFullFetch(List<ContractingAuthority> contractingAuthorityIds, int i, Interval interval) throws IOException, InterruptedException {
        ContractingAuthority contractingAuthority = contractingAuthorityIds.get(i);
        Long contractingAuthorityId = contractingAuthority.getId();
        DirectAcquisitionContracts contracts = getAndSaveAllDirectAcquisitionContractsForContractingAuthority(contractingAuthorityId, interval);

        List<DirectAcquisitionContract> directAcquisitionContractsFromCA = contracts.getDirectAcquisitionContracts();

        if (directAcquisitionContractsFromCA.size() > 0) {
            System.out.println("Fetching " + directAcquisitionContractsFromCA.size() + " contracts from contracting authority " + contractingAuthority.getId() + " (" + contractingAuthority.getName() + ")");

            List<Long> contractIds = directAcquisitionContractsFromCA.stream().mapToLong(DirectAcquisitionContract::get_id).boxed().collect(toList());
            executeDetailsFetchingForContracts(contractIds);
        }
        System.out.println("From Contracting Authority " + contractingAuthorityId + " (" + contractingAuthority.getName() + ")" + " there were "
                + directAcquisitionContractsFromCA.size() + " contracts (contr. auth. nr: "
                + i + "/" + contractingAuthorityIds.size() + ")");
    }

    public void executeDetailsFetchingForContracts(List<Long> directAcquisitionContractIds) throws InterruptedException {
        List<List<Long>> chunks = chunks(directAcquisitionContractIds, NR_THREADS);

        CountDownLatch countDownLatch = new CountDownLatch(NR_THREADS);

        IntStream
                .range(0, NR_THREADS)
                .mapToObj(chunks::get)
                .map(contractList ->
                        new DirectAcquisitionContractExecutor(httpService, objectMapperService, directAcquisitionContractDetailsRepository, contractList, countDownLatch, this.yearForSearch))
                .collect(toList())
                .forEach(DirectAcquisitionContractExecutor::run);


        countDownLatch.await();
    }

    private DirectAcquisitionContracts getAndSaveAllDirectAcquisitionContractsForContractingAuthority(Long contractingAuthorityId, Interval interval) throws IOException {
        DirectAcquisitionContracts contracts = getDirectAcquisitionContractsLite(contractingAuthorityId, interval.getStart(), interval.getEnd());
        List<DirectAcquisitionContracts> directAcquisitionContractsList = new ArrayList<>(singletonList(contracts));

        if (thereAreMoreThanTheMaximumOnOnePage(contracts)) {
            directAcquisitionContractsList.clear();
            fetchAllContractsInSmallerSearchFilterIntervals(contractingAuthorityId, directAcquisitionContractsList);
        }

        DirectAcquisitionContracts allContracts = new DirectAcquisitionContracts();
        allContracts.setTotal(directAcquisitionContractsList
                .stream()
                .mapToInt(DirectAcquisitionContracts::getTotal)
                .sum()
        );
        allContracts.setDirectAcquisitionContracts(directAcquisitionContractsList.stream()
                .map(DirectAcquisitionContracts::getDirectAcquisitionContracts)
                .flatMap(List::stream)
                .collect(toList())
        );
        allContracts.getDirectAcquisitionContracts().forEach(directAcquisitionContract -> {
                    directAcquisitionContract.setYear(this.yearForSearch);
                    directAcquisitionContract.set_id(directAcquisitionContract.getDirectAcquisitionId());
                }
        );
        directAcquisitionContractRepository.saveAll(allContracts.getDirectAcquisitionContracts());
        return allContracts;
    }

    private boolean thereAreMoreThanTheMaximumOnOnePage(DirectAcquisitionContracts contracts) {
        return contracts.getDirectAcquisitionContracts().size() == MAX_PAGE_SIZE;
    }

    private void fetchAllContractsInSmallerSearchFilterIntervals(Long contractingAuthorityId, List<DirectAcquisitionContracts> directAcquisitionContractsList) throws IOException {
        DirectAcquisitionContracts contracts;
        for (int i = 1; i <= 11; i += MONTH_INTERVAL) {
            Interval interval = constructInterval(i);
            contracts = getDirectAcquisitionContractsLite(contractingAuthorityId, interval.getStart(), interval.getEnd());
            directAcquisitionContractsList.add(contracts);
        }
    }

    private Interval constructInterval(int i) {
        DateTime firstDayOfMonth = new DateTime().withYear(this.yearForSearch).withMonthOfYear(i).withDayOfMonth(1).withTimeAtStartOfDay();
        DateTime monthInFuture = new DateTime().withYear(this.yearForSearch).withMonthOfYear(i + MONTH_INTERVAL - 1).withTime(23, 59, 0, 0);
        DateTime lastDayMonthInFuture = monthInFuture.withDayOfMonth(monthInFuture.toLocalDate().dayOfMonth().withMaximumValue().getDayOfMonth());
        return new Interval(firstDayOfMonth, lastDayMonthInFuture);
    }

    private DirectAcquisitionContracts getDirectAcquisitionContractsLite(Long contractingAuthorityId, DateTime firstDayOfMonth, DateTime lastDayInThreeMonths) throws IOException {
        System.out.println("Fetching contracts for Contracting Authority " + contractingAuthorityId);
        FetchDirectAcquisitionContracts fetchDirectAcquisitionContracts = new FetchDirectAcquisitionContractsRequestBuilder().buildDefault();
        fetchDirectAcquisitionContracts.setContractingAuthorityId(contractingAuthorityId);
        fetchDirectAcquisitionContracts.setPageSize(MAX_PAGE_SIZE);
        fetchDirectAcquisitionContracts.setFinalizationDateStart(firstDayOfMonth);
        fetchDirectAcquisitionContracts.setFinalizationDateEnd(lastDayInThreeMonths);
        String content = httpService.doRequest(fetchDirectAcquisitionContracts);
        return objectMapperService.mapToDirectAcquisitionContracts(content);
    }

}
