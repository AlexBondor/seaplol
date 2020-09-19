package ro.cineseuita.contract.direct.service.impl;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.cineseuita.contract.direct.api.dto.DirectContractDto;
import ro.cineseuita.contract.direct.api.dto.DirectContractListDto;
import ro.cineseuita.contract.direct.entity.DirectContract;
import ro.cineseuita.contract.direct.repository.DirectContractRepository;
import ro.cineseuita.contract.direct.service.DirectContractMapper;
import ro.cineseuita.contract.direct.service.DirectContractService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DirectContractServiceImpl implements DirectContractService {

    private final DirectContractRepository directContractRepository;
    private final DirectContractMapper mapper;

    @Autowired
    public DirectContractServiceImpl(final DirectContractRepository directContractRepository) {
        this.directContractRepository = directContractRepository;
        this.mapper = Mappers.getMapper(DirectContractMapper.class);
    }

    @Override
    public List<DirectContractListDto> findAll() {
        final List<DirectContract> contracts = directContractRepository.findAll();
        return formDtoList(contracts);
    }

    @Override
    public DirectContractDto get(Long id) {
        final DirectContract supplier = directContractRepository.findById(id).get();
        return mapper.toDetailDto(supplier);
    }

    @Override
    public List<DirectContractListDto> findAllForSupplier(Long supplierId) {
        List<DirectContract> contracts = directContractRepository.findAllBySupplier__id(supplierId);
        return formDtoList(contracts);
    }

    @Override
    public List<DirectContractListDto> findAllForContractingAuthority(Long caId) {
        List<DirectContract> contracts = directContractRepository.findAllByContractingAuthority__id(caId);
        return formDtoList(contracts);
    }

    private List<DirectContractListDto> formDtoList(List<DirectContract> contracts) {
        return contracts.stream()
                .map(mapper::toListDto)
                .collect(Collectors.toList());
    }

}
