package ro.cineseuita.data.shared.requests.seap;

import ro.cineseuita.data.shared.requests.PostRequestBase;

public abstract class FetchParticipants extends PostRequestBase {
    private static final String URL_PRE = "http://e-licitatie.ro/api-pub/Participants/GetParticipants/";
    private static final String URL_REFERER = "http://e-licitatie.ro/pub/participants";
    private static final String CONTENT_TYPE = "application/json; charset=utf-8";

    private Integer pageIndex;
    private ParticipantType participantType;
    private Integer pageSize = 2000;

    FetchParticipants(int pageIndex, ParticipantType participantType) {
        this.pageIndex = pageIndex;
        this.participantType = participantType;
        buildParams();
    }

    @Override
    protected void buildParams() {
        params.put("pageSize", getPageSize());
        params.put("pageIndex", getPageIndex());
        params.put("participantTypeItem", participantType.getMapForRequest());
        params.put("participantType", participantType.getValue());

    }

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public String getUrl() {
        return URL_PRE;
    }

    @Override
    public String getReferer() {
        return URL_REFERER;
    }


    @Override
    public String getContentType() {
        return CONTENT_TYPE;
    }

}
