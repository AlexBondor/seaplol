package ro.cineseuita.data.stats.service;

import com.mongodb.client.model.geojson.Point;
import com.mongodb.client.model.geojson.Position;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.cineseuita.data.contractingauthority.entity.ContractingAuthorityDetails;
import ro.cineseuita.data.contractingauthority.repository.ContractingAuthorityDetailsRepository;
import ro.cineseuita.data.contractingauthority.service.ContractingAuthorityService;
import ro.cineseuita.data.essentials.contractingauthority.entity.ContractingAuthorityEssentials;
import ro.cineseuita.data.essentials.contractingauthority.repository.ContractingAuthorityEssentialsRepository;
import ro.cineseuita.data.shared.entityComponents.Address;
import ro.cineseuita.data.stats.entity.CityStats;
import ro.cineseuita.data.stats.entity.CityStatsBuilder;
import ro.cineseuita.data.stats.repository.CityStatsRepository;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CityStatsService {

    private static final String[] HEADERS = {"X", "Y", "NUME", "JUDET", "JUDET AUTO", "POPULATIE (in 2002)", "REGIUNE"};
    private final ContractingAuthorityService contractingAuthorityService;
    private final ContractingAuthorityEssentialsRepository contractingAuthorityEssentialsRepository;
    private final CityStatsRepository cityStatsRepository;
    private final ContractingAuthorityDetailsRepository contractingAuthorityDetailsRepository;

    @Autowired
    public CityStatsService(ContractingAuthorityService contractingAuthorityService, ContractingAuthorityEssentialsRepository contractingAuthorityEssentialsRepository, CityStatsRepository cityStatsRepository, ContractingAuthorityDetailsRepository contractingAuthorityDetailsRepository) {
        this.contractingAuthorityService = contractingAuthorityService;
        this.contractingAuthorityEssentialsRepository = contractingAuthorityEssentialsRepository;
        this.cityStatsRepository = cityStatsRepository;
        this.contractingAuthorityDetailsRepository = contractingAuthorityDetailsRepository;
    }

    public void processCityCSV() throws IOException {
        Long id = 0L;
        long notFound = 0L;
        Map<Long, CityStats> statsMap = new HashMap<>();

        Reader in = new FileReader(new File("src/main/resources/cities.csv"));
        Iterable<CSVRecord> records = CSVFormat.DEFAULT
                .withHeader(HEADERS)
                .withFirstRecordAsHeader()
                .parse(in);

        for (CSVRecord record : records) {
            Double xCoord = Double.parseDouble(record.get(HEADERS[0]));
            Double yCoord = Double.parseDouble(record.get(HEADERS[1]));
            String name = record.get(HEADERS[2]);
            String county = record.get(HEADERS[3]);
            Long population = tryParsePopulation(record);
            Point location = new Point(new Position(xCoord, yCoord));
            CityStats cityStats = new CityStatsBuilder()
                    .withLocation(location)
                    .withId(id++)
                    .withName(name)
                    .withCounty(county)
                    .withPopulation(population)
                    .withTotalNumberContracts(0L)
                    .withTotalValueContracts(0.0)
                    .build();
            statsMap.put(id, cityStats);
        }

        List<ContractingAuthorityDetails> contractingAuthorities = contractingAuthorityDetailsRepository.findAll();

        Long countractsMissedOut = 0L;
        for (ContractingAuthorityDetails contractingAuthority : contractingAuthorities) {
            ContractingAuthorityEssentials essentials = contractingAuthorityEssentialsRepository.findById(Long.valueOf(contractingAuthority.getId())).get();
            essentials.set_id(Long.valueOf(contractingAuthority.getId()));
            Address address = contractingAuthority.getAddress();
            String city = address.getCity();
            String county = address.getCounty();
            CityStats stats = findCityByCityAndCounty(statsMap, city, county);
            if (stats != null) {
                stats.incrementNumberContracts(essentials.getTotalContractsCount());
                stats.incrementTotalValue(essentials.getTotalContractsValue());
                essentials.setCityStatsId(stats.getId());
                contractingAuthorityEssentialsRepository.save(essentials);
            } else {
                countractsMissedOut += essentials.getTotalContractsCount();
                System.out.println("Could not find " + city + " from county " + county + " not found number: " + notFound++);
            }
        }

        for (CityStats stats : statsMap.values()) {
            if (stats.getPopulation().equals(0L)) {
                stats.setPopulation(1L);
            }
            stats.setContractCountPowerPerPopulation(((double) stats.getTotalNumberContracts() / stats.getPopulation()));
            stats.setContractValuePowerPerPopulation((stats.getTotalValueContracts() / stats.getPopulation()));
            cityStatsRepository.save(stats);
        }

        System.out.println("missed: " + countractsMissedOut);

    }

    private CityStats findCityByCityAndCounty(Map<Long, CityStats> statsMap, String city, String county) {
        return statsMap.values().stream().filter(
                e -> e.getCounty().toLowerCase().equals(county.toLowerCase()) && e.getName().toLowerCase().equals(city.toLowerCase())
        ).findFirst().orElse(null);
    }

    private long tryParsePopulation(CSVRecord record) {
        long population = 1;
        try {
            population = Long.parseLong(record.get(HEADERS[5]));
        } catch (Exception ignored) {

        }
        return population;
    }
}
