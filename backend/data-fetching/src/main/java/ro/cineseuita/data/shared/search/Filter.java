package ro.cineseuita.data.shared.search;

import java.util.ArrayList;
import java.util.List;

public class Filter {

    private static final String DEFAULT_SORT_BY = "name";

    private List<Long> entityIds = new ArrayList<>();
    private String searchTerm;
    private Integer page = 0;
    private Integer itemsPerPage = 10;
    private Boolean sortDesc = false;
    private String sortBy = DEFAULT_SORT_BY;

    public String getSearchTerm() {
        return searchTerm;
    }

    public void setSearchTerm(final String searchTerm) {
        this.searchTerm = searchTerm;
    }

    public Integer getPage() {
        return page - 1; // because vuetify starts from 1 and mongo starts from 0 ... //TODO: find proper solution maybe?
    }

    public void setPage(final Integer page) {
        this.page = page;
    }

    public Integer getItemsPerPage() {
        return itemsPerPage;
    }

    public void setItemsPerPage(final Integer itemsPerPage) {
        this.itemsPerPage = itemsPerPage;
    }

    public Boolean isSortDesc() {
        return sortDesc;
    }

    public void setSortDesc(final Boolean sortDesc) {
        this.sortDesc = sortDesc;
    }

    public String getSortBy() {
        return (sortBy != null && !sortBy.equals("")) ? sortBy : DEFAULT_SORT_BY;
    }

    public void setSortBy(final String sortBy) {
        this.sortBy = sortBy;
    }

    public List<Long> getEntityIds() {
        return entityIds;
    }

    public void setEntityIds(List<Long> entityIds) {
        this.entityIds = entityIds;
    }

    public Boolean getSortDesc() {
        return sortDesc;
    }

    public String getRegexReadySearchTerm() {
        return searchTerm = ".*" + searchTerm + ".*";

    }
}
