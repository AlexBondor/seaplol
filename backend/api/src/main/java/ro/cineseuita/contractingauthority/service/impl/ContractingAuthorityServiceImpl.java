package ro.cineseuita.contractingauthority.service.impl;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;
import ro.cineseuita.contract.direct.entity.DirectContract;
import ro.cineseuita.contract.direct.repository.DirectContractRepository;
import ro.cineseuita.contractingauthority.api.dto.ContractingAuthorityCpvBasicStatsDto;
import ro.cineseuita.contractingauthority.api.dto.ContractingAuthorityDetailDto;
import ro.cineseuita.contractingauthority.api.dto.ContractingAuthorityListDto;
import ro.cineseuita.contractingauthority.entity.ContractingAuthority;
import ro.cineseuita.contractingauthority.entity.ContractingAuthorityFilter;
import ro.cineseuita.contractingauthority.repository.ContractingAuthorityRepository;
import ro.cineseuita.contractingauthority.service.ContractingAuthorityMapper;
import ro.cineseuita.contractingauthority.service.ContractingAuthorityService;
import ro.cineseuita.contractingauthority.statistics.DirectContractBasicStatisticsCollector;
import ro.cineseuita.shared.BasicStatistics;
import ro.cineseuita.shared.BasicStatisticsCollector;
import ro.cineseuita.shared.CpvCode;
import ro.cineseuita.shared.treemaps.TreeMap;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static ro.cineseuita.contractingauthority.api.dto.ContractingAuthorityCpvBasicStatsDto.NR_CPV_PER_CA_FOR_STATS;
import static ro.cineseuita.shared.search.SearchHelper.buildPageRequest;

@Service
public class ContractingAuthorityServiceImpl implements ContractingAuthorityService {
    private final ContractingAuthorityRepository contractingAuthorityRepository;
    private final DirectContractRepository directContractRepository;
    private final ContractingAuthorityMapper mapper;

    @Autowired
    public ContractingAuthorityServiceImpl(final ContractingAuthorityRepository contractingAuthorityRepository,
                                           final DirectContractRepository directContractRepository) {
        this.contractingAuthorityRepository = contractingAuthorityRepository;
        this.directContractRepository = directContractRepository;
        this.mapper = Mappers.getMapper(ContractingAuthorityMapper.class);
    }

    @Override
    public Page<ContractingAuthorityListDto> findAll(final ContractingAuthorityFilter filter) {
        final long matchingContractingAuthoritiesCount = contractingAuthorityRepository.count(filter);
        final List<ContractingAuthority> contractingAuthorities = contractingAuthorityRepository.findAll(filter);
        final List<ContractingAuthorityListDto> contractingAuthoritiesDtos = contractingAuthorities.stream()
                .map(mapper::toListDto)
                .collect(Collectors.toList());

        return new PageImpl<>(contractingAuthoritiesDtos, buildPageRequest(filter), matchingContractingAuthoritiesCount);
    }

    @Override
    public ContractingAuthorityDetailDto get(final Long id) {
        final ContractingAuthority contractingAuthority = contractingAuthorityRepository.findById(id).get();
        return mapper.toDetailDto(contractingAuthority);
    }

    @Override
    public ContractingAuthorityCpvBasicStatsDto getCpvBasicStatsForContractingAuthority(Long id) {
        ContractingAuthorityCpvBasicStatsDto cpvBasicStatsDto = new ContractingAuthorityCpvBasicStatsDto();

        List<DirectContract> contracts = directContractRepository.findAllByContractingAuthority__id(id);

        Map<CpvCode, BasicStatistics> groupedContracts = contracts.stream().collect(
                Collectors.groupingBy(DirectContract::getCpvCode, new DirectContractBasicStatisticsCollector())
        );

        Map<CpvCode, BasicStatistics> stats = BasicStatisticsCollector.collect(groupedContracts, NR_CPV_PER_CA_FOR_STATS);
        cpvBasicStatsDto.setStats(stats);

        return cpvBasicStatsDto;
    }

    @Override
    public List<Map> treeMap(Long id) {
        // TODO: fill out properly
        return TreeMap.generateMockTreeMap().stream().map(TreeMap::toMap).collect(Collectors.toList());
    }
}
