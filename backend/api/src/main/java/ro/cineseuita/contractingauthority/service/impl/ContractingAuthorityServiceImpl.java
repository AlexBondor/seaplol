package ro.cineseuita.contractingauthority.service.impl;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;
import ro.cineseuita.contractingauthority.api.dto.ContractingAuthorityDetailDto;
import ro.cineseuita.contractingauthority.api.dto.ContractingAuthorityListDto;
import ro.cineseuita.contractingauthority.service.ContractingAuthorityMapper;
import ro.cineseuita.contractingauthority.service.ContractingAuthorityService;
import ro.cineseuita.data.essentials.contractingauthority.entity.ContractingAuthorityEssentials;
import ro.cineseuita.data.essentials.contractingauthority.repository.ContractingAuthorityEssentialsRepository;
import ro.cineseuita.data.essentials.contractingauthority.repository.ContractingAuthorityFilter;
import ro.cineseuita.shared.TreeMap;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static ro.cineseuita.data.shared.search.SearchHelper.buildPageRequest;

@Service
public class ContractingAuthorityServiceImpl implements ContractingAuthorityService {
    private final ContractingAuthorityEssentialsRepository contractingAuthorityRepository;
    private final ContractingAuthorityMapper mapper;

    @Autowired
    public ContractingAuthorityServiceImpl(final ContractingAuthorityEssentialsRepository contractingAuthorityRepository) {
        this.contractingAuthorityRepository = contractingAuthorityRepository;
        this.mapper = Mappers.getMapper(ContractingAuthorityMapper.class);
    }

    @Override
    public Page<ContractingAuthorityListDto> findAll(final ContractingAuthorityFilter filter) {
        final long matchingContractingAuthoritiesCount = contractingAuthorityRepository.count(filter);
        final List<ContractingAuthorityEssentials> contractingAuthorities = contractingAuthorityRepository.findAll(filter);
        final List<ContractingAuthorityListDto> contractingAuthoritiesDtos = contractingAuthorities.stream()
                .map(mapper::toListDto)
                .collect(Collectors.toList());

        return new PageImpl<>(contractingAuthoritiesDtos, buildPageRequest(filter), matchingContractingAuthoritiesCount);
    }

    @Override
    public ContractingAuthorityDetailDto get(final Long id) {
        final ContractingAuthorityEssentials contractingAuthority = contractingAuthorityRepository.findById(id).get();
        return mapper.toDetailDto(contractingAuthority);
    }

    @Override
    public List<Map> treeMap(Long id) {
        // TODO: fill out properly
        return TreeMap.generateMockTreeMap().stream().map(TreeMap::toMap).collect(Collectors.toList());
    }
}
