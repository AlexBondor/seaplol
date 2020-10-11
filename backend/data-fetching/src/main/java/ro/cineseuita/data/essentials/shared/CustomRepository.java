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

        addSearchTermFilter(filter, query);

        return query;
    }

    protected void addSearchTermFilter(final Filter filter, final Query query) {
        if (filter.getSearchTerm() != null) {
            String searchTerm = filter.getRegexReadySearchTerm();
            String[] searchTerms = searchTerm.split(" ");
            Criteria criteria =
                    new Criteria().orOperator(
                            searchTerms.length > 1 ? getMultiCriteriaForSearchTerms(searchTerms) :
                                    Criteria.where("name").regex(Pattern.compile(searchTerm, Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE)),
                            Criteria.where("legalRepresentative").regex(Pattern.compile(searchTerm, Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE))
                    );
            query.addCriteria(criteria);
        }
    }

    private Criteria getMultiCriteriaForSearchTerms(String[] searchTerms) {
        Criteria[] criterias = new Criteria[searchTerms.length];
        for (int i = 0; i < searchTerms.length; i++) {
            String searchTerm = searchTerms[i];
            criterias[i] =
                    new Criteria().orOperator(
                            Criteria.where("name").regex(Pattern.compile(searchTerm, Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE)),
                            Criteria.where("legalRepresentative").regex(Pattern.compile(searchTerm, Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE))
                    );
        }
        return new Criteria().andOperator(criterias);
    }

    protected void addConstraint(String fieldName, Object fieldValue, Query query) {
        Criteria criteria = Criteria.where(fieldName).is(fieldValue);
        query.addCriteria(criteria);
    }

}
