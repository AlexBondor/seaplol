package ro.cineseuita.supplier.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.cineseuita.data.essentials.supplier.repository.SupplierFilter;
import ro.cineseuita.supplier.api.dto.SupplierDetailDto;
import ro.cineseuita.supplier.api.dto.SupplierListDto;
import ro.cineseuita.supplier.service.SupplierService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/suppliers")
public class SupplierController {
  private final SupplierService supplierService;

  @Autowired
  public SupplierController(final SupplierService supplierService) {
    this.supplierService = supplierService;
  }

  @GetMapping()
  public Page<SupplierListDto> findAll(SupplierFilter filter) {
    return supplierService.findAll(filter);
  }

  @GetMapping("/{id}")
  public SupplierDetailDto get(@PathVariable Long id) {
    return supplierService.get(id);
  }

  @GetMapping("/treeMap/{id}")
  public List<Map> treeMap(@PathVariable Long id) {
    return supplierService.treeMap(id);
  }
}
