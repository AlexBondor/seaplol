package ro.cineseuita.shared.requests;

public abstract class FetchParticipant implements GetRequest {

    private static final String URL_PRE = "http://e-licitatie.ro/api-pub/Participants/GetParticipantDetail/";
    private static final String URL_REFERER = "http://e-licitatie.ro/pub/participants/view/ac/";
    private Long id;
    private ParticipantType participantType;


    public FetchParticipant(Long id, ParticipantType participantType) {
        this.id = id;
        this.participantType = participantType;
    }

    @Override
    public String getUrl() {
        return URL_PRE + participantType.getValue() + "/" + id;
    }

    @Override
    public String getReferer() {
        return URL_REFERER + id;
    }

}
