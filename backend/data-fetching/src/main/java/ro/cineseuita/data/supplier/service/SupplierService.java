package ro.cineseuita.data.supplier.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.cineseuita.data.contract.direct.entity.DirectAcquisitionContractDetails;
import ro.cineseuita.data.contract.direct.repository.DirectAcquisitionContractDetailsRepository;
import ro.cineseuita.data.essentials.service.DirectAcquisitionEssentialsMapperService;
import ro.cineseuita.data.essentials.service.SupplierEssentialsMapperService;
import ro.cineseuita.data.essentials.supplier.entity.SupplierEssentials;
import ro.cineseuita.data.essentials.supplier.repository.SupplierEssentialsRepository;
import ro.cineseuita.data.shared.HttpService;
import ro.cineseuita.data.shared.ObjectMapperService;
import ro.cineseuita.data.shared.Period;
import ro.cineseuita.data.shared.requests.openapi.FetchSupplierOpenApiBalance;
import ro.cineseuita.data.shared.requests.openapi.FetchSupplierOpenApiDetails;
import ro.cineseuita.data.shared.requests.seap.FetchParticipants;
import ro.cineseuita.data.shared.requests.seap.FetchSupplierDetails;
import ro.cineseuita.data.shared.requests.seap.FetchSuppliers;
import ro.cineseuita.data.supplier.entity.Supplier;
import ro.cineseuita.data.supplier.entity.SupplierDetails;
import ro.cineseuita.data.supplier.entity.SupplierOpenApiBalance;
import ro.cineseuita.data.supplier.entity.SupplierOpenApiDetails;
import ro.cineseuita.data.supplier.entity.components.AverageRevenuePerYearAndEmployeeCount;
import ro.cineseuita.data.supplier.entity.components.Suppliers;
import ro.cineseuita.data.supplier.repository.SupplierDataRepository;
import ro.cineseuita.data.supplier.repository.SupplierDetailsRepository;
import ro.cineseuita.data.supplier.repository.SupplierOpenApiBalanceRepository;
import ro.cineseuita.data.supplier.repository.SupplierOpenApiDetailsRepository;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static java.util.Comparator.comparing;
import static ro.cineseuita.data.contract.direct.entity.components.DirectAcquisitionState.OFERTA_ACCEPTATA;

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
    private final SupplierOpenApiDetailsRepository supplierOpenApiDetailsRepository;
    private final SupplierOpenApiBalanceRepository supplierOpenApiBalanceRepository;

    @Autowired
    public SupplierService(SupplierEssentialsMapperService supplierEssentialsMapperService, DirectAcquisitionEssentialsMapperService directAcquisitionEssentialsMapperService, SupplierDetailsRepository supplierDetailsRepository, SupplierDataRepository supplierDataRepository, DirectAcquisitionContractDetailsRepository directAcquisitionContractDetailsRepository, SupplierEssentialsRepository supplierEssentialsRepository, HttpService httpService, ObjectMapperService objectMapperService, SupplierOpenApiDetailsRepository supplierOpenApiDetailsRepository, SupplierOpenApiBalanceRepository supplierOpenApiBalanceRepository) {
        this.supplierEssentialsMapperService = supplierEssentialsMapperService;
        this.directAcquisitionEssentialsMapperService = directAcquisitionEssentialsMapperService;
        this.supplierDetailsRepository = supplierDetailsRepository;
        this.supplierDataRepository = supplierDataRepository;
        this.directAcquisitionContractDetailsRepository = directAcquisitionContractDetailsRepository;
        this.supplierEssentialsRepository = supplierEssentialsRepository;
        this.httpService = httpService;
        this.objectMapperService = objectMapperService;
        this.supplierOpenApiDetailsRepository = supplierOpenApiDetailsRepository;
        this.supplierOpenApiBalanceRepository = supplierOpenApiBalanceRepository;
    }

    public void fetchAllSuppliersLite() throws IOException {
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

    public void fetchAllSupplierDetails() {
        AtomicInteger i = new AtomicInteger();
        supplierDataRepository.findAll()
                .stream()
                .parallel()
                .forEach(supplier -> {
                    i.getAndIncrement();
                    SupplierDetails supplierDetails = fetchSupplierDetails(supplier.getId());
                    supplierDetailsRepository.save(supplierDetails);
                    System.out.println("Fetched and saved details for " + supplier.getName() + " " + i);
                });
    }

    public SupplierDetails fetchSupplierDetails(Long supplierId) {
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

    public void normalizeCuiForEachSupplier() {
        long count = supplierDataRepository.count();
        List<Supplier> all = supplierDataRepository.findAll();
        AtomicInteger i = new AtomicInteger();
        all.stream().parallel().forEach(supplier -> {
            SupplierDetails details = supplierDetailsRepository.findById(supplier.getId()).get();
            String cui = supplier.getCui();
            String actualCui = cui.replaceAll("\\D+", "");
            actualCui = actualCui.trim();

            supplier.setCui(actualCui);
            details.setCui(actualCui);
            supplierDataRepository.save(supplier);
            supplierDetailsRepository.save(details);

            System.out.printf("Done %d/%d\n", i.getAndIncrement(), count);
        });
    }

    public void fetchAllSupplierOpenApiDetails() {
        long count = supplierDataRepository.count();
        int startFrom = 0;
        AtomicInteger i = new AtomicInteger(startFrom);
        List<Supplier> all = supplierDataRepository.findAll();
        all.subList(startFrom, all.size())
                .stream().parallel().forEach(supplier -> {
            String cui = supplier.getCui();

            if (!supplierOpenApiDetailsRepository.existsById(cui)) {

                System.out.printf("Fetching SupplierOpenAPIDetails %d/%d\n", i.getAndIncrement(), count);


                FetchSupplierOpenApiDetails fetchSupplierOpenApiDetails = new FetchSupplierOpenApiDetails(cui);
                String response = httpService.doRequest(fetchSupplierOpenApiDetails);

                if (!response.equals("") && !response.contains("cif_valid\":false")) {
                    SupplierOpenApiDetails openApiDetails;
                    try {
                        openApiDetails = objectMapperService.mapToSupplierOpenApiDetails(response);
                        supplierOpenApiDetailsRepository.save(openApiDetails);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                System.out.printf("Already did %d\n", i.incrementAndGet());
            }
        });
    }

    public void fetchAllSupplierOpenApiBalances() {
        Period.getYears().forEach(period -> {
            final int year = period.getNumVal();
            long count = supplierOpenApiDetailsRepository.count();
            int startFrom = 0;
            AtomicInteger i = new AtomicInteger(startFrom);
            List<SupplierOpenApiDetails> all = supplierOpenApiDetailsRepository.findAll();
            all.subList(startFrom, all.size())
                    .stream().parallel().forEach(supplier -> {
                String cui = supplier.getCif();

                String id = cui + "-" + year;

                if (!supplierOpenApiBalanceRepository.existsById(id)) {

                    System.out.printf("Fetching SupplierOpenAPIBalance %d/%d\n", i.getAndIncrement(), count);


                    FetchSupplierOpenApiBalance fetchSupplierOpenApiBalance = new FetchSupplierOpenApiBalance(cui, year);
                    String response = httpService.doRequest(fetchSupplierOpenApiBalance);

                    if (!response.equals("") && !response.contains("Balance not available")) {
                        SupplierOpenApiBalance openApiBalance;
                        try {
                            openApiBalance = objectMapperService.mapToSupplierOpenApiBalance(response);
                            openApiBalance.setId(id);
                            supplierOpenApiBalanceRepository.save(openApiBalance);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                } else {
                    System.out.printf("Already did %d\n", i.incrementAndGet());
                }
            });
        });
    }

    public void computeExtraInformationFromOpenApiData() {
        extractGeneralInformationFromOpenApiData();
        extractBalanceInformationFromOpenApiData();
    }

    private void extractGeneralInformationFromOpenApiData() {
//        long count = supplierOpenApiDetailsRepository.count();
//        int startFrom = 0;
//        AtomicInteger i = new AtomicInteger(startFrom);
//        List<SupplierOpenApiDetails> all = supplierOpenApiDetailsRepository.findAll();
//
//        all.stream().parallel().forEach(supplierOpenApiDetails -> {
//            String stare = supplierOpenApiDetails.getStare();
//
//
//        });
    }

    private void extractBalanceInformationFromOpenApiData() {
        long count = supplierDataRepository.count();
        AtomicInteger i = new AtomicInteger();
        List<SupplierDetails> all = supplierDetailsRepository.findAll();
        all.stream().parallel().forEach(supplierDetails -> {
            List<SupplierOpenApiBalance> balancesByCif = supplierOpenApiBalanceRepository.findAllByCif(supplierDetails.getCui());
            balancesByCif.sort(comparing(SupplierOpenApiBalance::getYear));
            for (Iterator<SupplierOpenApiBalance> iterator = balancesByCif.iterator(); iterator.hasNext(); ) {
                SupplierOpenApiBalance balance = iterator.next();
                AverageRevenuePerYearAndEmployeeCount averageRevenuePerYearAndEmployeeCount = new AverageRevenuePerYearAndEmployeeCount();
                Integer year = balance.getYear();
                List<DirectAcquisitionContractDetails> allContractsWithThatSupplierThatYear = directAcquisitionContractDetailsRepository.findAllBySupplierIdAndYearAndSysDirectAcquisitionStateID(supplierDetails.getId(), year, OFERTA_ACCEPTATA.getNumVal());
                double total = allContractsWithThatSupplierThatYear.stream().mapToDouble(DirectAcquisitionContractDetails::getClosingValue).sum();
                double totalSecondCurrency = allContractsWithThatSupplierThatYear.stream().mapToDouble(DirectAcquisitionContractDetails::getSecondCurrencyClosingValue).sum();
                averageRevenuePerYearAndEmployeeCount.setYear(year);
                Long numarMediuDeSalariati = balance.getData().getNumarMediuDeSalariati();
                Integer numarMediuDeSalariatiNormalizat = numarMediuDeSalariati != null ? numarMediuDeSalariati.intValue() == 0 ? 1 : numarMediuDeSalariati.intValue() : 1;
                averageRevenuePerYearAndEmployeeCount.setAverageNumberOfEmployeesThisYear(numarMediuDeSalariatiNormalizat);
                averageRevenuePerYearAndEmployeeCount.setTotalRevenueFromPublicInstitutionsThisYear(total);
                averageRevenuePerYearAndEmployeeCount.setTotalRevenueFromPublicInstitutionsThisYearSecondCurrency(totalSecondCurrency);
                averageRevenuePerYearAndEmployeeCount.computeAverage();

                supplierDetails.addAverageRevenuePerYearAndEmployeeCount(year, averageRevenuePerYearAndEmployeeCount);

                if (!iterator.hasNext()) {
                    supplierDetails.setLatestYearAverageRevenuePerEmployeeCount(averageRevenuePerYearAndEmployeeCount);
                }
            }
            supplierDetailsRepository.save(supplierDetails);
            System.out.printf("Done %d balances for %s (%d) - %d/%d\n", balancesByCif.size(), supplierDetails.getName(), supplierDetails.getId(), i.getAndIncrement(), count);
        });
    }

    public void mapSuppliersToEssentials() {
        List<SupplierDetails> suppliersDetails = supplierDetailsRepository.findAll();

        AtomicInteger i = new AtomicInteger();
        suppliersDetails.stream().parallel().forEach(supplierDetails -> {
            SupplierEssentials supplierEssentials = supplierEssentialsMapperService.mapToSupplierEssentials(supplierDetails);
            List<DirectAcquisitionContractDetails> directAcquisitionContractsForContractingAuthority = directAcquisitionContractDetailsRepository.findAllBySysDirectAcquisitionStateIDAndSupplierId(OFERTA_ACCEPTATA.getNumVal(), supplierDetails.getId());
            double totalValue = directAcquisitionContractsForContractingAuthority.stream().mapToDouble(DirectAcquisitionContractDetails::getClosingValue).sum();
            double totalValueSecondCurrency = directAcquisitionContractsForContractingAuthority.stream().mapToDouble(DirectAcquisitionContractDetails::getSecondCurrencyClosingValue).sum();
            supplierEssentials.setTotalContractsValue(totalValue);
            supplierEssentials.setTotalContractsValueSecondCurrency(totalValueSecondCurrency);
            supplierEssentials.setTotalContractsCount((long) directAcquisitionContractsForContractingAuthority.size());
            AverageRevenuePerYearAndEmployeeCount latestYearAverageRevenuePerEmployeeCount = supplierDetails.getLatestYearAverageRevenuePerEmployeeCount();
            if (latestYearAverageRevenuePerEmployeeCount != null) {
                supplierEssentials.setAverageNumberOfEmployeesLastYear(latestYearAverageRevenuePerEmployeeCount.getAverageNumberOfEmployeesThisYear().longValue());
                supplierEssentials.setAverageRevenueFromPublicInstitutionsPerEmployeeLastYear(latestYearAverageRevenuePerEmployeeCount.getAverageRevenueFromPublicInstitutionsPerEmployeeThisYear());
                supplierEssentials.setAverageRevenueFromPublicInstitutionsPerEmployeeLastYearSecondCurrency(latestYearAverageRevenuePerEmployeeCount.getAverageRevenueFromPublicInstitutionsPerEmployeeThisYearSecondCurrency());
            }
            supplierEssentialsRepository.save(supplierEssentials);

            System.out.println("Mapped supplierDetails " + i.getAndIncrement() + "/" + suppliersDetails.size());
        });
    }

}
