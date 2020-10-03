package ro.cineseuita.contract.direct.service.impl;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;
import ro.cineseuita.contract.direct.api.dto.DirectContractDto;
import ro.cineseuita.contract.direct.api.dto.DirectContractListDto;
import ro.cineseuita.contract.direct.service.DirectContractMapper;
import ro.cineseuita.contract.direct.service.DirectContractService;
import ro.cineseuita.data.essentials.directcontract.entity.DirectAcquisitionContractEssentials;
import ro.cineseuita.data.essentials.directcontract.repository.DirectAcquisitionContractFilter;
import ro.cineseuita.data.essentials.directcontract.repository.DirectContractEssentialsRepository;

import java.util.List;
import java.util.stream.Collectors;

import static ro.cineseuita.data.shared.search.SearchHelper.buildPageRequest;

@Service
public class DirectContractServiceImpl implements DirectContractService {

    private final DirectContractEssentialsRepository directContractEssentialsRepository;
    private final DirectContractMapper mapper;

    @Autowired
    public DirectContractServiceImpl(final DirectContractEssentialsRepository directContractEssentialsRepository) {
        this.directContractEssentialsRepository = directContractEssentialsRepository;
        this.mapper = Mappers.getMapper(DirectContractMapper.class);
    }

    @Override
    public List<DirectContractListDto> findAll() {
        final List<DirectAcquisitionContractEssentials> contracts = directContractEssentialsRepository.findAll();
        return formDtoList(contracts);
    }

    @Override
    public DirectContractDto get(Long id) {
        final DirectAcquisitionContractEssentials supplier = directContractEssentialsRepository.findById(id).get();
        return mapper.toDetailDto(supplier);
    }

    @Override
    public Page<DirectContractListDto> getAllForSupplier(Long supplierId, final DirectAcquisitionContractFilter directAcquisitionContractFilter) {
        final long matchingContractsCount = directContractEssentialsRepository.countBySupplierId(supplierId, directAcquisitionContractFilter);
        final List<DirectAcquisitionContractEssentials> contracts = directContractEssentialsRepository.findAllBySupplierId(supplierId, directAcquisitionContractFilter);
        final List<DirectContractListDto> contractListDtos = contracts.stream()
                .map(mapper::toListDto)
                .collect(Collectors.toList());

        return new PageImpl<>(contractListDtos, buildPageRequest(directAcquisitionContractFilter), matchingContractsCount);
    }

    private List<DirectContractListDto> formDtoList(List<DirectAcquisitionContractEssentials> contracts) {
        return contracts.stream()
                .map(mapper::toListDto)
                .collect(Collectors.toList());
    }

}
