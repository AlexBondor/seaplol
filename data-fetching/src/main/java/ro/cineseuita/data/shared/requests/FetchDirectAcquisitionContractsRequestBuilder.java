package ro.cineseuita.data.shared.requests;

import org.joda.time.DateTime;

public final class FetchDirectAcquisitionContractsRequestBuilder {
    private Integer pageSize;
    private Boolean showOngoingDa;
    private String cookieContext;
    private Integer pageIndex;
    private Long sysDirectAcquisitionStateId;
    private DateTime finalizationDateStart;
    private DateTime finalizationDateEnd;
    private DateTime publicationDateStart;
    private DateTime publicationDateEnd;
    private Long contractingAuthorityId;

    public FetchDirectAcquisitionContractsRequestBuilder() {
    }

    public FetchDirectAcquisitionContractsRequestBuilder withPageSize(Integer pageSize) {
        this.pageSize = pageSize;
        return this;
    }

    public FetchDirectAcquisitionContractsRequestBuilder withShowOngoingDa(Boolean showOngoingDa) {
        this.showOngoingDa = showOngoingDa;
        return this;
    }

    public FetchDirectAcquisitionContractsRequestBuilder withCookieContext(String cookieContext) {
        this.cookieContext = cookieContext;
        return this;
    }

    public FetchDirectAcquisitionContractsRequestBuilder withPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
        return this;
    }

    public FetchDirectAcquisitionContractsRequestBuilder withSysDirectAcquisitionStateId(Long sysDirectAcquisitionStateId) {
        this.sysDirectAcquisitionStateId = sysDirectAcquisitionStateId;
        return this;
    }

    public FetchDirectAcquisitionContractsRequestBuilder withFinalizationDateStart(DateTime finalizationDateStart) {
        this.finalizationDateStart = finalizationDateStart;
        return this;
    }

    public FetchDirectAcquisitionContractsRequestBuilder withFinalizationDateEnd(DateTime finalizationDateEnd) {
        this.finalizationDateEnd = finalizationDateEnd;
        return this;
    }

    public FetchDirectAcquisitionContractsRequestBuilder withPublicationDateStart(DateTime publicationDateStart) {
        this.publicationDateStart = publicationDateStart;
        return this;
    }

    public FetchDirectAcquisitionContractsRequestBuilder withPublicationDateEnd(DateTime publicationDateEnd) {
        this.publicationDateEnd = publicationDateEnd;
        return this;
    }

    public FetchDirectAcquisitionContractsRequestBuilder withContractingAuthorityId(Long contractingAuthorityId) {
        this.contractingAuthorityId = contractingAuthorityId;
        return this;
    }

    public FetchDirectAcquisitionContracts buildDefault() {
        FetchDirectAcquisitionContracts fetchDirectAcquisitionContracts = new FetchDirectAcquisitionContracts();
        fetchDirectAcquisitionContracts.setPageSize(100);
        fetchDirectAcquisitionContracts.setShowOngoingDa(false);
        fetchDirectAcquisitionContracts.setCookieContext("null");
        fetchDirectAcquisitionContracts.setPageIndex(0);
        fetchDirectAcquisitionContracts.setSysDirectAcquisitionStateId(null);
        fetchDirectAcquisitionContracts.setPublicationDateStart(null);
        fetchDirectAcquisitionContracts.setPublicationDateEnd(null);
        fetchDirectAcquisitionContracts.setContractingAuthorityId(1520L);
        return fetchDirectAcquisitionContracts;
    }

    public FetchDirectAcquisitionContracts build() {
        FetchDirectAcquisitionContracts fetchDirectAcquisitionContracts = new FetchDirectAcquisitionContracts();
        fetchDirectAcquisitionContracts.setPageSize(pageSize);
        fetchDirectAcquisitionContracts.setShowOngoingDa(showOngoingDa);
        fetchDirectAcquisitionContracts.setCookieContext(cookieContext);
        fetchDirectAcquisitionContracts.setPageIndex(pageIndex);
        fetchDirectAcquisitionContracts.setSysDirectAcquisitionStateId(sysDirectAcquisitionStateId);
        fetchDirectAcquisitionContracts.setFinalizationDateStart(finalizationDateStart);
        fetchDirectAcquisitionContracts.setFinalizationDateEnd(finalizationDateEnd);
        fetchDirectAcquisitionContracts.setPublicationDateStart(publicationDateStart);
        fetchDirectAcquisitionContracts.setPublicationDateEnd(publicationDateEnd);
        fetchDirectAcquisitionContracts.setContractingAuthorityId(contractingAuthorityId);
        return fetchDirectAcquisitionContracts;
    }
}
