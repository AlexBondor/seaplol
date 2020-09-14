package ro.cineseuita.shared.requests;

import java.util.HashMap;
import java.util.Map;

public enum ParticipantType {
    AUTORITATE_CONTRACTANTA(2, "Autoritate Contractanta"),
    OFERTANT(3, "Ofertant");


    private final Integer value;
    private final String text;

    ParticipantType(final Integer value, final String text) {
        this.value = value;
        this.text = text;
    }

    public Integer getValue() {

        return value;
    }

    public String getText() {
        return text;
    }

    Map<String, Object> getMapForRequest() {
        HashMap<String, Object> mapForRequest = new HashMap<>();
        mapForRequest.put("id", this.value);
        mapForRequest.put("text", this.text);
        return mapForRequest;
    }
}
