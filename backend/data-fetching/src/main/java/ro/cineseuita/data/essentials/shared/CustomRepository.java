package ro.cineseuita.data.essentials.shared;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import ro.cineseuita.data.shared.search.Filter;
import ro.cineseuita.data.shared.search.SearchHelper;

import java.util.regex.Pattern;

import static ro.cineseuita.data.shared.search.SearchHelper.setSort;

public abstract class CustomRepository {


    protected Query buildFilterQuery(final Filter filter) {
        final Query query = new Query();

        SearchHelper.setPageFilter(filter, query);
        setSort(filter, query);

        final Criteria criteria = new Criteria();
        addSearchTermFilter(filter, criteria);

        query.addCriteria(criteria);
        return query;
    }

    protected void addSearchTermFilter(final Filter filter, final Criteria criteria) {
        if (filter.getSearchTerm() != null) {
            final String searchTerm = filter.getSearchTerm();
            // todo: maybe extract field name as parameter...
            criteria.and("name").regex(Pattern.compile(searchTerm, Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE));
        }
    }

    protected void addConstraint(String fieldName, Object fieldValue, Query query) {
        Criteria criteria = Criteria.where(fieldName).is(fieldValue);
        query.addCriteria(criteria);
    }

}
