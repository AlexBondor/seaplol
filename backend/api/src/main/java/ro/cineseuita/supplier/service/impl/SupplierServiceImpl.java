package ro.cineseuita.supplier.service.impl;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;
import ro.cineseuita.data.essentials.supplier.entity.SupplierEssentials;
import ro.cineseuita.data.essentials.supplier.repository.SupplierEssentialsRepository;
import ro.cineseuita.data.essentials.supplier.repository.SupplierFilter;
import ro.cineseuita.shared.treemaps.TreeMap;
import ro.cineseuita.supplier.api.dto.SupplierDetailDto;
import ro.cineseuita.supplier.api.dto.SupplierListDto;
import ro.cineseuita.supplier.service.SupplierMapper;
import ro.cineseuita.supplier.service.SupplierService;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static ro.cineseuita.data.shared.search.SearchHelper.buildPageRequest;

@Service
public class SupplierServiceImpl implements SupplierService {
    private final SupplierEssentialsRepository supplierEssentialsRepository;
    private final SupplierMapper mapper;

    @Autowired
    public SupplierServiceImpl(final SupplierEssentialsRepository supplierEssentialsRepository) {
        this.supplierEssentialsRepository = supplierEssentialsRepository;
        this.mapper = Mappers.getMapper(SupplierMapper.class);
    }

    @Override
    public Page<SupplierListDto> findAll(SupplierFilter filter) {
        final long matchingSuppliersCount = supplierEssentialsRepository.count(filter);
        final List<SupplierEssentials> suppliers = supplierEssentialsRepository.findAll(filter);
        final List<SupplierListDto> suppliersDtos = suppliers.stream()
                .map(mapper::toListDto)
                .collect(Collectors.toList());

        return new PageImpl<>(suppliersDtos, buildPageRequest(filter), matchingSuppliersCount);
    }

    @Override
    public SupplierDetailDto get(final Long id) {
        final SupplierEssentials supplier = supplierEssentialsRepository.findById(id).get();
        return mapper.toDetailDto(supplier);
    }

    @Override
    public List<Map> treeMap(Long id) {
        // TODO: fill out properly
        return TreeMap.generateMockTreeMap().stream().map(TreeMap::toMap).collect(Collectors.toList());
    }
}
