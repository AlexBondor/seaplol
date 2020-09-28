package ro.cineseuita.data.essentials.contractingauthority.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import ro.cineseuita.data.essentials.contractingauthority.entity.ContractingAuthorityEssentials;
import ro.cineseuita.data.essentials.contractingauthority.repository.ContractingAuthorityCustomRepository;
import ro.cineseuita.data.essentials.contractingauthority.repository.ContractingAuthorityFilter;
import ro.cineseuita.data.shared.search.Filter;
import ro.cineseuita.data.shared.search.SearchHelper;

import java.util.List;
import java.util.regex.Pattern;

import static ro.cineseuita.data.shared.search.SearchHelper.setSort;

public class ContractingAuthorityEssentialsRepositoryImpl implements ContractingAuthorityCustomRepository {
    private final MongoOperations operations;

    @Autowired
    public ContractingAuthorityEssentialsRepositoryImpl(final MongoOperations operations) {
        this.operations = operations;
    }

    @Override
    public List<ContractingAuthorityEssentials> findAll(final ContractingAuthorityFilter filter) {
        final Query query = buildFilterQuery(filter);
        return operations.find(query, ContractingAuthorityEssentials.class);
    }

    @Override
    public long count(final ContractingAuthorityFilter filter) {
        final Query query = buildFilterQuery(filter);
        return operations.count(query, ContractingAuthorityEssentials.class);
    }

    private Query buildFilterQuery(final ContractingAuthorityFilter filter) {
        final Query query = new Query();

        SearchHelper.setPageFilter(filter, query);
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
