package ro.cineseuita.supplier.repository;

import ro.cineseuita.supplier.entity.Supplier;
import ro.cineseuita.supplier.entity.SupplierFilter;

import java.util.List;

public interface SupplierCustomRepository {
    List<Supplier> findAll(SupplierFilter filter);

    long count(SupplierFilter filter);
}
