package ro.cineseuita.data.essentials.supplier.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;
import ro.cineseuita.data.essentials.shared.CustomRepository;
import ro.cineseuita.data.essentials.supplier.entity.SupplierEssentials;
import ro.cineseuita.data.essentials.supplier.repository.SupplierCustomRepository;
import ro.cineseuita.data.essentials.supplier.repository.SupplierFilter;

import java.util.List;

public class SupplierEssentialsRepositoryImpl extends CustomRepository implements SupplierCustomRepository {
    private final MongoOperations operations;

    @Autowired
    public SupplierEssentialsRepositoryImpl(final MongoOperations operations) {
        this.operations = operations;
    }

    @Override
    public List<SupplierEssentials> findAll(final SupplierFilter filter) {
        final Query query = buildFilterQuery(filter);
        return operations.find(query, SupplierEssentials.class);
    }

    @Override
    public long count(final SupplierFilter filter) {
        final Query query = buildFilterQuery(filter);
        return operations.count(query, SupplierEssentials.class);
    }
}
