package ro.cineseuita.data.essentials.supplier.repository;

import ro.cineseuita.data.essentials.supplier.entity.SupplierEssentials;

import java.util.List;

public interface SupplierCustomRepository {
    List<SupplierEssentials> findAll(SupplierFilter filter);

    long count(SupplierFilter filter);
}
