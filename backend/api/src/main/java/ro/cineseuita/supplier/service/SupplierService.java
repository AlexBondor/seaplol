package ro.cineseuita.supplier.service;

import ro.cineseuita.supplier.api.dto.SupplierContractorsBasicStatsDto;
import org.springframework.data.domain.Page;
import ro.cineseuita.supplier.api.dto.SupplierDetailDto;
import ro.cineseuita.supplier.api.dto.SupplierListDto;
import ro.cineseuita.supplier.entity.SupplierFilter;

import java.util.List;
import java.util.Map;

public interface SupplierService {
    Page<SupplierListDto> findAll(SupplierFilter filter);

    SupplierDetailDto get(Long id);

    SupplierContractorsBasicStatsDto getMostContractedFromStats(Long id);

    List<Map> treeMap(Long id);
}
