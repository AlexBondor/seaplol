package ro.cineseuita.supplier.service.impl;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;
import ro.cineseuita.contract.direct.entity.DirectContract;
import ro.cineseuita.contract.direct.repository.DirectContractRepository;
import ro.cineseuita.contractingauthority.api.dto.ContractingAuthorityMinimalDto;
import ro.cineseuita.contractingauthority.service.ContractingAuthorityMapper;
import ro.cineseuita.contractingauthority.statistics.DirectContractBasicStatisticsCollector;
import ro.cineseuita.shared.BasicStatistics;
import ro.cineseuita.shared.BasicStatisticsCollector;
import ro.cineseuita.shared.treemaps.TreeMap;
import ro.cineseuita.supplier.api.dto.SupplierContractorsBasicStatsDto;
import ro.cineseuita.supplier.api.dto.SupplierDetailDto;
import ro.cineseuita.supplier.api.dto.SupplierListDto;
import ro.cineseuita.supplier.entity.Supplier;
import ro.cineseuita.supplier.entity.SupplierFilter;
import ro.cineseuita.supplier.repository.SupplierRepository;
import ro.cineseuita.supplier.service.SupplierMapper;
import ro.cineseuita.supplier.service.SupplierService;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static ro.cineseuita.shared.search.SearchHelper.buildPageRequest;
import static ro.cineseuita.supplier.api.dto.SupplierContractorsBasicStatsDto.NR_CAS_PER_SUPPLIER_FOR_STATS;

@Service
public class SupplierServiceImpl implements SupplierService {
    private final SupplierRepository supplierRepository;
    private final DirectContractRepository directContractRepository;
    private final SupplierMapper mapper;
    private final ContractingAuthorityMapper contractingAuthorityMapper;

    @Autowired
    public SupplierServiceImpl(final SupplierRepository supplierRepository, DirectContractRepository directContractRepository) {
        this.supplierRepository = supplierRepository;
        this.directContractRepository = directContractRepository;
        this.mapper = Mappers.getMapper(SupplierMapper.class);
        this.contractingAuthorityMapper = Mappers.getMapper(ContractingAuthorityMapper.class);
    }

    @Override
    public Page<SupplierListDto> findAll(SupplierFilter filter) {
        final long matchingSuppliersCount = supplierRepository.count(filter);
        final List<Supplier> suppliers = supplierRepository.findAll(filter);
        final List<SupplierListDto> suppliersDtos = suppliers.stream()
                .map(mapper::toListDto)
                .collect(Collectors.toList());

        return new PageImpl<>(suppliersDtos, buildPageRequest(filter), matchingSuppliersCount);
    }

    @Override
    public SupplierDetailDto get(final Long id) {
        final Supplier supplier = supplierRepository.findById(id).get();
        return mapper.toDetailDto(supplier);
    }

    @Override
    public SupplierContractorsBasicStatsDto getMostContractedFromStats(Long id) {
        SupplierContractorsBasicStatsDto supplierContractorsBasicStatsDto = new SupplierContractorsBasicStatsDto();

        List<DirectContract> contracts = directContractRepository.findAllBySupplier__id(id);

        Map<ContractingAuthorityMinimalDto, BasicStatistics> groupedContracts = contracts.stream().collect(
                Collectors.groupingBy(this::mapContractToCAMinimalDto, new DirectContractBasicStatisticsCollector())
        );

        Map<ContractingAuthorityMinimalDto, BasicStatistics> stats = BasicStatisticsCollector.collect(groupedContracts, NR_CAS_PER_SUPPLIER_FOR_STATS);

        supplierContractorsBasicStatsDto.setStats(stats);

        return supplierContractorsBasicStatsDto;
    }

    @Override
    public List<Map> treeMap(Long id) {
        // TODO: fill out properly
        return TreeMap.generateMockTreeMap().stream().map(TreeMap::toMap).collect(Collectors.toList());
    }

    private ContractingAuthorityMinimalDto mapContractToCAMinimalDto(DirectContract contract) {
        return contractingAuthorityMapper.toMinimalDto(contract.getContractingAuthority());
    }
}
