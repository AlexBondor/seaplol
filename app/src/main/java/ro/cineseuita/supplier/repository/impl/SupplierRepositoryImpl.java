package ro.cineseuita.supplier.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import ro.cineseuita.shared.search.Filter;
import ro.cineseuita.supplier.entity.Supplier;
import ro.cineseuita.supplier.entity.SupplierFilter;
import ro.cineseuita.supplier.repository.SupplierCustomRepository;

import java.util.List;
import java.util.regex.Pattern;

import static ro.cineseuita.shared.search.SearchHelper.setPageFilter;
import static ro.cineseuita.shared.search.SearchHelper.setSort;

public class SupplierRepositoryImpl implements SupplierCustomRepository {
    private final MongoOperations operations;

    @Autowired
    public SupplierRepositoryImpl(final MongoOperations operations) {
        this.operations = operations;
    }

    @Override
    public List<Supplier> findAll(final SupplierFilter filter) {
        final Query query = buildFilterQuery(filter);
        return operations.find(query, Supplier.class);
    }

    @Override
    public long count(final SupplierFilter filter) {
        final Query query = buildFilterQuery(filter);
        return operations.count(query, Supplier.class);
    }

    private Query buildFilterQuery(final SupplierFilter filter) {
        final Query query = new Query();

        setPageFilter(filter, query);
        setSort(filter, query);

        final Criteria criteria = new Criteria();
        addSearchTermFilter(filter, criteria);

        query.addCriteria(criteria);
        return query;
    }

    private void addSearchTermFilter(final Filter filter, final Criteria criteria) {
        if (filter.getSearchTerm() != null) {
            final String searchTerm = filter.getSearchTerm();
            criteria.and("name").regex(Pattern.compile(searchTerm, Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE));
        }
    }
}
