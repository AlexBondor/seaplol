package ro.cineseuita.shared.entityComponents;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "name",
        "city",
        "county",
        "cui",
        "participantType",
        "participantTypeId",
        "participantStatus",
        "participantStatusStr"
})
public class Participant {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("city")
    private String city;
    @JsonProperty("county")
    private String county;
    @JsonProperty("cui")
    private String cui;
    @JsonProperty("participantType")
    private String participantType;
    @JsonProperty("participantTypeId")
    private Integer participantTypeId;
    @JsonProperty("participantStatus")
    private GenericSeapData participantStatus;
    @JsonProperty("participantStatusStr")
    private String participantStatusStr;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("id")
    public Long getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Long id) {
        this.id = id;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("city")
    public String getCity() {
        return city;
    }

    @JsonProperty("city")
    public void setCity(String city) {
        this.city = city;
    }

    @JsonProperty("county")
    public String getCounty() {
        return county;
    }

    @JsonProperty("county")
    public void setCounty(String county) {
        this.county = county;
    }

    @JsonProperty("cui")
    public String getCui() {
        return cui;
    }

    @JsonProperty("cui")
    public void setCui(String cui) {
        this.cui = cui;
    }

    @JsonProperty("participantType")
    public String getParticipantType() {
        return participantType;
    }

    @JsonProperty("participantType")
    public void setParticipantType(String participantType) {
        this.participantType = participantType;
    }

    @JsonProperty("participantTypeId")
    public Integer getParticipantTypeId() {
        return participantTypeId;
    }

    @JsonProperty("participantTypeId")
    public void setParticipantTypeId(Integer participantTypeId) {
        this.participantTypeId = participantTypeId;
    }

    @JsonProperty("participantStatus")
    public GenericSeapData getParticipantStatus() {
        return participantStatus;
    }

    @JsonProperty("participantStatus")
    public void setParticipantStatus(GenericSeapData participantStatus) {
        this.participantStatus = participantStatus;
    }

    @JsonProperty("participantStatusStr")
    public String getParticipantStatusStr() {
        return participantStatusStr;
    }

    @JsonProperty("participantStatusStr")
    public void setParticipantStatusStr(String participantStatusStr) {
        this.participantStatusStr = participantStatusStr;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }
}
