package ro.cineseuita.data.shared.search;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Query;

public class SearchHelper {
    private SearchHelper() {

    }

    public static void setPageFilter(final Filter filter, final Query query) {
        query.limit(filter.getItemsPerPage());
        query.skip((long) filter.getPage() * filter.getItemsPerPage());
    }

    public static void setSort(final Filter filter, final Query query) {
        final PageRequest pageRequest = buildPageRequest(filter);
        query.with(pageRequest.getSort());
    }

    public static PageRequest buildPageRequest(final Filter filter) {
        return PageRequest.of(filter.getPage(), filter.getItemsPerPage(),
                getSortDirection(filter.isSortDesc()), filter.getSortBy());
    }

    private static Sort.Direction getSortDirection(final Boolean sortDesc) {
        return sortDesc == null ? Sort.Direction.ASC : sortDesc ? Sort.Direction.DESC : Sort.Direction.ASC;
    }
}
