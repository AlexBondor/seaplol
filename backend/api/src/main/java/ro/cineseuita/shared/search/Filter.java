package ro.cineseuita.shared.search;

public class Filter {

    private static final String DEFAULT_SORT_BY = "name";

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
        return page;
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
}
