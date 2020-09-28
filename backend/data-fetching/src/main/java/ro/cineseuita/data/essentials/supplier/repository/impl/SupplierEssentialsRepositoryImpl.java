package ro.cineseuita.data.essentials.supplier.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import ro.cineseuita.data.essentials.supplier.entity.SupplierEssentials;
import ro.cineseuita.data.essentials.supplier.repository.SupplierCustomRepository;
import ro.cineseuita.data.essentials.supplier.repository.SupplierFilter;
import ro.cineseuita.data.shared.search.Filter;

import java.util.List;
import java.util.regex.Pattern;

import static ro.cineseuita.data.shared.search.SearchHelper.setPageFilter;
import static ro.cineseuita.data.shared.search.SearchHelper.setSort;

public class SupplierEssentialsRepositoryImpl implements SupplierCustomRepository {
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
