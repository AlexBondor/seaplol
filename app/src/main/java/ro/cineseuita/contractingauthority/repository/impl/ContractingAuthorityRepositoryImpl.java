package ro.cineseuita.contractingauthority.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import ro.cineseuita.contractingauthority.entity.ContractingAuthority;
import ro.cineseuita.contractingauthority.entity.ContractingAuthorityFilter;
import ro.cineseuita.contractingauthority.repository.ContractingAuthorityCustomRepository;
import ro.cineseuita.shared.search.Filter;

import java.util.List;
import java.util.regex.Pattern;

import static ro.cineseuita.shared.search.SearchHelper.setPageFilter;
import static ro.cineseuita.shared.search.SearchHelper.setSort;

public class ContractingAuthorityRepositoryImpl implements ContractingAuthorityCustomRepository {
    private final MongoOperations operations;

    @Autowired
    public ContractingAuthorityRepositoryImpl(final MongoOperations operations) {
        this.operations = operations;
    }

    @Override
    public List<ContractingAuthority> findAll(final ContractingAuthorityFilter filter) {
        final Query query = buildFilterQuery(filter);
        return operations.find(query, ContractingAuthority.class);
    }

    @Override
    public long count(final ContractingAuthorityFilter filter) {
        final Query query = buildFilterQuery(filter);
        return operations.count(query, ContractingAuthority.class);
    }

    private Query buildFilterQuery(final ContractingAuthorityFilter filter) {
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
