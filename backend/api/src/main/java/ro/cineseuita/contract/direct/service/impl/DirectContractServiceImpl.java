package ro.cineseuita.contract.direct.service.impl;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;
import ro.cineseuita.contract.direct.api.dto.DirectContractDto;
import ro.cineseuita.contract.direct.api.dto.DirectContractExpandedItemDto;
import ro.cineseuita.contract.direct.api.dto.DirectContractListDto;
import ro.cineseuita.contract.direct.service.DirectContractMapper;
import ro.cineseuita.contract.direct.service.DirectContractService;
import ro.cineseuita.data.cpv.entity.NationalCpvData;
import ro.cineseuita.data.cpv.repository.NationalCpvDataRepository;
import ro.cineseuita.data.essentials.directcontract.entity.DirectAcquisitionContractEssentials;
import ro.cineseuita.data.essentials.directcontract.entity.components.DirectAcquisitionItemEssentials;
import ro.cineseuita.data.essentials.directcontract.repository.DirectAcquisitionContractEssentialsRepository;
import ro.cineseuita.data.essentials.directcontract.repository.DirectAcquisitionContractFilter;
import ro.cineseuita.data.shared.itemMeasurement.CostCountAverage;
import ro.cineseuita.data.shared.itemMeasurement.ItemMeasurement;
import ro.cineseuita.data.shared.itemMeasurement.ItemMeasurementClassifier;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static ro.cineseuita.data.shared.itemMeasurement.ItemMeasurementClassifier.getSubsetOfExamplesForBucket;
import static ro.cineseuita.data.shared.search.SearchHelper.buildPageRequest;

@Service
public class DirectContractServiceImpl implements DirectContractService {

    private final DirectAcquisitionContractEssentialsRepository directAcquisitionContractEssentialsRepository;
    private final NationalCpvDataRepository nationalCpvDataRepository;
    private final DirectContractMapper mapper;

    @Autowired
    public DirectContractServiceImpl(final DirectAcquisitionContractEssentialsRepository directAcquisitionContractEssentialsRepository, NationalCpvDataRepository nationalCpvDataRepository) {
        this.directAcquisitionContractEssentialsRepository = directAcquisitionContractEssentialsRepository;
        this.nationalCpvDataRepository = nationalCpvDataRepository;
        this.mapper = Mappers.getMapper(DirectContractMapper.class);
    }

    @Override
    public List<DirectContractListDto> findAll() {
        final List<DirectAcquisitionContractEssentials> contracts = directAcquisitionContractEssentialsRepository.findAll();
        return formDtoList(contracts);
    }

    @Override
    public DirectContractDto get(Long id) {
        final DirectAcquisitionContractEssentials supplier = directAcquisitionContractEssentialsRepository.findById(id).get();
        return mapper.toDetailDto(supplier);
    }

    @Override
    public Page<DirectContractListDto> getAllForSupplier(Long supplierId, final DirectAcquisitionContractFilter directAcquisitionContractFilter) {
        final long matchingContractsCount = directAcquisitionContractEssentialsRepository.countBySupplierId(supplierId, directAcquisitionContractFilter);
        final List<DirectAcquisitionContractEssentials> contracts = directAcquisitionContractEssentialsRepository.findAllBySupplierId(supplierId, directAcquisitionContractFilter);
        final List<DirectContractListDto> contractListDtos = contracts.stream()
                .map(mapper::toListDto)
                .collect(Collectors.toList());

        return new PageImpl<>(contractListDtos, buildPageRequest(directAcquisitionContractFilter), matchingContractsCount);
    }

    @Override
    public Page<DirectContractListDto> getAllForContractingAuthority(Long contractingAuthorityId, DirectAcquisitionContractFilter directAcquisitionContractFilter) {
        final long matchingContractsCount = directAcquisitionContractEssentialsRepository.countByContractingAuthorityId(contractingAuthorityId, directAcquisitionContractFilter);
        final List<DirectAcquisitionContractEssentials> contracts = directAcquisitionContractEssentialsRepository.findAllByContractingAuthorityId(contractingAuthorityId, directAcquisitionContractFilter);
        final List<DirectContractListDto> contractListDtos = contracts.stream()
                .map(mapper::toListDto)
                .collect(Collectors.toList());

        return new PageImpl<>(contractListDtos, buildPageRequest(directAcquisitionContractFilter), matchingContractsCount);
    }

    @Override
    public List<DirectContractExpandedItemDto> detailsForExpandedRow(Long contractId) {
        List<DirectContractExpandedItemDto> itemDtos = new ArrayList<>();

        DirectAcquisitionContractEssentials directAcquisitionContractEssentials = directAcquisitionContractEssentialsRepository.findById(contractId).get();

        directAcquisitionContractEssentials.getDirectAcquisitionItems().forEach(item -> {
            itemDtos.add(formDirectContractExpandedItemDto(item));
        });

        return itemDtos;
    }

    private DirectContractExpandedItemDto formDirectContractExpandedItemDto(DirectAcquisitionItemEssentials item) {
        DirectContractExpandedItemDto itemDto = new DirectContractExpandedItemDto();

        String cpvCode = item.getCpvCode().getCode();
        String measurementUnit = item.getMeasureUnit();
        ItemMeasurement measurementBucket = ItemMeasurementClassifier.getBucket(measurementUnit);
        NationalCpvData nationalCpvData = nationalCpvDataRepository.findById(cpvCode).get();
        CostCountAverage costCountAverageForBucket = nationalCpvData.getItemMeasurementStats().getByItemMeasurement(measurementBucket);
        Double itemAverageCost = item.getAverageCostPerItem();
        Double nationalAverageCost = costCountAverageForBucket.getAverage();

        itemDto.setMeasurementUnit(measurementUnit);
        itemDto.setMeasurementBucket(measurementBucket);
        itemDto.setMeasurementBucketExamples(getSubsetOfExamplesForBucket(measurementBucket));
        itemDto.setItemAverageCost(itemAverageCost);
        itemDto.setNationalAverageCost(nationalAverageCost);
        itemDto.setPriceDeviationPercentage(itemAverageCost * 100 / nationalAverageCost);

        return itemDto;
    }

    private List<DirectContractListDto> formDtoList(List<DirectAcquisitionContractEssentials> contracts) {
        return contracts.stream()
                .map(mapper::toListDto)
                .collect(Collectors.toList());
    }

}
