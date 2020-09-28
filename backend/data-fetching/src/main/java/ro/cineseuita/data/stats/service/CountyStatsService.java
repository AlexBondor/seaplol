package ro.cineseuita.data.stats.service;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.cineseuita.data.contractingauthority.entity.ContractingAuthorityDetails;
import ro.cineseuita.data.contractingauthority.repository.ContractingAuthorityDetailsRepository;
import ro.cineseuita.data.essentials.contractingauthority.entity.ContractingAuthorityEssentials;
import ro.cineseuita.data.essentials.contractingauthority.repository.ContractingAuthorityEssentialsRepository;
import ro.cineseuita.data.shared.entityComponents.Address;
import ro.cineseuita.data.stats.repository.CountyStatsRepository;
import ro.cineseuita.data.stats.entity.CountyStats;
import ro.cineseuita.data.stats.entity.CountyStatsBuilder;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CountyStatsService {

    private static final String[] HEADERS = {"NAME", "POP"};
    private final ContractingAuthorityDetailsRepository contractingAuthorityDetailsRepository;
    private final ContractingAuthorityEssentialsRepository contractingAuthorityEssentialsRepository;
    private final CountyStatsRepository countyStatsRepository;

    @Autowired
    public CountyStatsService(ContractingAuthorityDetailsRepository contractingAuthorityDetailsRepository, ContractingAuthorityEssentialsRepository contractingAuthorityEssentialsRepository, CountyStatsRepository countyStatsRepository) {
        this.contractingAuthorityDetailsRepository = contractingAuthorityDetailsRepository;
        this.contractingAuthorityEssentialsRepository = contractingAuthorityEssentialsRepository;
        this.countyStatsRepository = countyStatsRepository;
    }

    public void processCountyCSV() throws IOException {
        Long id = 0L;
        Map<String, CountyStats> statsMap = new HashMap<>();

        Reader in = new FileReader(new File("src/main/resources/counties.csv"));
        Iterable<CSVRecord> records = CSVFormat.DEFAULT
                .withHeader(HEADERS)
                .withFirstRecordAsHeader()
                .parse(in);

        for (CSVRecord record : records) {
            String name = record.get(HEADERS[0]);
            Long population = Long.parseLong(record.get(HEADERS[1]));
            CountyStats cityStats = new CountyStatsBuilder()
                    .withId(id++)
                    .withName(name)
                    .withPopulation(population)
                    .withTotalNumberContracts(0L)
                    .withTotalValueContracts(0.0)
                    .build();

            statsMap.put(name, cityStats);
        }
        List<ContractingAuthorityDetails> contractingAuthorities = contractingAuthorityDetailsRepository.findAll();
        for (ContractingAuthorityDetails contractingAuthority : contractingAuthorities) {
            ContractingAuthorityEssentials essentials = contractingAuthorityEssentialsRepository.findById(Long.valueOf(contractingAuthority.getId())).get();
            essentials.set_id(Long.valueOf(contractingAuthority.getId()));
            Address address = contractingAuthority.getAddress();
            String county = address.getCounty();

            CountyStats stats = statsMap.get(county);

            if (stats != null) {
                stats.incrementNumberContracts(essentials.getTotalContractsCount());
                stats.incrementTotalValue(essentials.getTotalContractsValue());
            }
        }

        for (CountyStats stats : statsMap.values()) {
            stats.setContractCountPowerPerPopulation(((double) stats.getTotalNumberContracts() / stats.getPopulation()));
            stats.setContractValuePowerPerPopulation((stats.getTotalValueContracts() / stats.getPopulation()));
            countyStatsRepository.save(stats);
        }

    }

}
