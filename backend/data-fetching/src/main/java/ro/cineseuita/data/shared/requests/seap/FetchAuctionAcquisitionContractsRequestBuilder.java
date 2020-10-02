package ro.cineseuita.data.shared.requests.seap;

import org.joda.time.DateTime;
import ro.cineseuita.data.contract.auction.entity.AuctionType;

import java.util.ArrayList;
import java.util.List;

public final class FetchAuctionAcquisitionContractsRequestBuilder {
    private List<Integer> sysNoticeTypeIds;
    private Long pageSize;
    private Long assignedUserId;
    private Long contractingAuthorityId;
    private DateTime startPublicationDate;
    private DateTime endPublicationDate;
    private Long pageIndex;
    private List<String> sortProperties;
    private Long sysAcquisitionContractTypeId;
    private Long sysContractAssigmentTypeId;
    private Long sysNoticeStateId;
    private Long winnerId;

    public FetchAuctionAcquisitionContractsRequestBuilder() {
    }

    public static FetchAuctionAcquisitionContractsRequestBuilder aGetAuctionAquisitionsRequest() {
        return new FetchAuctionAcquisitionContractsRequestBuilder();
    }

    public FetchAuctionAcquisitionContractsRequestBuilder withSysNoticeTypeIds(List<Integer> sysNoticeTypeIds) {
        this.sysNoticeTypeIds = sysNoticeTypeIds;
        return this;
    }

    public FetchAuctionAcquisitionContractsRequestBuilder withPageSize(Long pageSize) {
        this.pageSize = pageSize;
        return this;
    }

    public FetchAuctionAcquisitionContractsRequestBuilder withAssignedUserId(Long assignedUserId) {
        this.assignedUserId = assignedUserId;
        return this;
    }

    public FetchAuctionAcquisitionContractsRequestBuilder withContractingAuthorityId(Long contractingAuthorityId) {
        this.contractingAuthorityId = contractingAuthorityId;
        return this;
    }

    public FetchAuctionAcquisitionContractsRequestBuilder withStartPublicationDate(DateTime startPublicationDate) {
        this.startPublicationDate = startPublicationDate;
        return this;
    }

    public FetchAuctionAcquisitionContractsRequestBuilder withEndPublicationDate(DateTime endPublicationDate) {
        this.endPublicationDate = endPublicationDate;
        return this;
    }

    public FetchAuctionAcquisitionContractsRequestBuilder withPageIndex(Long pageIndex) {
        this.pageIndex = pageIndex;
        return this;
    }

    public FetchAuctionAcquisitionContractsRequestBuilder withSortProperties(List<String> sortProperties) {
        this.sortProperties = sortProperties;
        return this;
    }

    public FetchAuctionAcquisitionContractsRequestBuilder withSysAcquisitionContractTypeId(Long sysAcquisitionContractTypeId) {
        this.sysAcquisitionContractTypeId = sysAcquisitionContractTypeId;
        return this;
    }

    public FetchAuctionAcquisitionContractsRequestBuilder withSysContractAssigmentTypeId(Long sysContractAssigmentTypeId) {
        this.sysContractAssigmentTypeId = sysContractAssigmentTypeId;
        return this;
    }

    public FetchAuctionAcquisitionContractsRequestBuilder withSysNoticeStateId(Long sysNoticeStateId) {
        this.sysNoticeStateId = sysNoticeStateId;
        return this;
    }

    public FetchAuctionAcquisitionContractsRequestBuilder withWinnerId(Long winnerId) {
        this.winnerId = winnerId;
        return this;
    }

    public FetchAuctionAcquisitionContracts buildDefault() {
        FetchAuctionAcquisitionContracts fetchAuctionAcquisitionContracts = new FetchAuctionAcquisitionContracts();
        fetchAuctionAcquisitionContracts.setPageSize(100L);
        fetchAuctionAcquisitionContracts.setAssignedUserId(null);
        fetchAuctionAcquisitionContracts.setContractingAuthorityId(null);
        fetchAuctionAcquisitionContracts.setStartPublicationDate(new DateTime().minusYears(5).withDayOfYear(1));
        fetchAuctionAcquisitionContracts.setEndPublicationDate(new DateTime()); // latest, today
        fetchAuctionAcquisitionContracts.setPageIndex(0L);
        fetchAuctionAcquisitionContracts.setSysAcquisitionContractTypeId(null);
        fetchAuctionAcquisitionContracts.setSysContractAssigmentTypeId(null);
        fetchAuctionAcquisitionContracts.setSysNoticeStateId(null);
        fetchAuctionAcquisitionContracts.setWinnerId(null);

        fetchAuctionAcquisitionContracts.setSysNoticeTypeIds(AuctionType.ALL());
        fetchAuctionAcquisitionContracts.setSortProperties(new ArrayList<>());
        return fetchAuctionAcquisitionContracts;
    }

    public FetchAuctionAcquisitionContracts build() {
        FetchAuctionAcquisitionContracts fetchAuctionAcquisitionContracts = new FetchAuctionAcquisitionContracts();
        fetchAuctionAcquisitionContracts.setSysNoticeTypeIds(sysNoticeTypeIds);
        fetchAuctionAcquisitionContracts.setPageSize(pageSize);
        fetchAuctionAcquisitionContracts.setAssignedUserId(assignedUserId);
        fetchAuctionAcquisitionContracts.setContractingAuthorityId(contractingAuthorityId);
        fetchAuctionAcquisitionContracts.setStartPublicationDate(startPublicationDate);
        fetchAuctionAcquisitionContracts.setEndPublicationDate(endPublicationDate);
        fetchAuctionAcquisitionContracts.setPageIndex(pageIndex);
        fetchAuctionAcquisitionContracts.setSortProperties(sortProperties);
        fetchAuctionAcquisitionContracts.setSysAcquisitionContractTypeId(sysAcquisitionContractTypeId);
        fetchAuctionAcquisitionContracts.setSysContractAssigmentTypeId(sysContractAssigmentTypeId);
        fetchAuctionAcquisitionContracts.setSysNoticeStateId(sysNoticeStateId);
        fetchAuctionAcquisitionContracts.setWinnerId(winnerId);
        return fetchAuctionAcquisitionContracts;
    }
}
