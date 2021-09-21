package ro.cineseuita.supplier.service;

import org.springframework.data.domain.Page;
import ro.cineseuita.data.essentials.supplier.repository.SupplierFilter;
import ro.cineseuita.supplier.api.dto.SupplierDetailDto;
import ro.cineseuita.supplier.api.dto.SupplierListDto;

import java.util.List;
import java.util.Map;

public interface SupplierService {
  Page<SupplierListDto> findAll(SupplierFilter filter);

  SupplierDetailDto get(Long id);

  List<Map> treeMap(Long id);
}
