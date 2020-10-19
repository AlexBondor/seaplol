package ro.cineseuita.data.shared.entityComponents;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "name",
        "cui",
        "participantType",
        "participantTypeId",
        "participantStatus",
        "participantEntityState",
        "retrievedTimestamp",
        "registration",
        "address",
        "notices",
        "supplierProceduresInfo",
        "catalog",
        "caProceduresOngoing",
        "caProceduresAwarded",
        "caProceduresCancelled"
})
public class ParticipantDetails<T extends Enum<T>> extends ProblematicEntity<T> {

    @JsonProperty("id")
    private Long id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("cui")
    private String cui;
    @JsonProperty("participantType")
    private String participantType;
    @JsonProperty("participantTypeId")
    private Integer participantTypeId;
    @JsonProperty("participantStatus")
    private Integer participantStatus;
    @JsonProperty("participantEntityState")
    private GenericSeapData participantEntityState;
    @JsonProperty("retrievedTimestamp")
    private String retrievedTimestamp;
    @JsonProperty("registration")
    private Registration registration;
    @JsonProperty("address")
    private Address address;
    @JsonProperty("notices")
    private Object notices;
    @JsonProperty("supplierProceduresInfo")
    private List<SupplierProceduresInfo> supplierProceduresInfo = null;
    @JsonProperty("catalog")
    private Catalog catalog;
    @JsonProperty("caProceduresOngoing")
    private Object caProceduresOngoing;
    @JsonProperty("caProceduresAwarded")
    private Object caProceduresAwarded;
    @JsonProperty("caProceduresCancelled")
    private Object caProceduresCancelled;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<>();

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
    public Integer getParticipantStatus() {
        return participantStatus;
    }

    @JsonProperty("participantStatus")
    public void setParticipantStatus(Integer participantStatus) {
        this.participantStatus = participantStatus;
    }

    @JsonProperty("participantEntityState")
    public GenericSeapData getParticipantEntityState() {
        return participantEntityState;
    }

    @JsonProperty("participantEntityState")
    public void setParticipantEntityState(GenericSeapData participantEntityState) {
        this.participantEntityState = participantEntityState;
    }

    @JsonProperty("retrievedTimestamp")
    public String getRetrievedTimestamp() {
        return retrievedTimestamp;
    }

    @JsonProperty("retrievedTimestamp")
    public void setRetrievedTimestamp(String retrievedTimestamp) {
        this.retrievedTimestamp = retrievedTimestamp;
    }

    @JsonProperty("registration")
    public Registration getRegistration() {
        return registration;
    }

    @JsonProperty("registration")
    public void setRegistration(Registration registration) {
        this.registration = registration;
    }

    @JsonProperty("address")
    public Address getAddress() {
        return address;
    }

    @JsonProperty("address")
    public void setAddress(Address address) {
        this.address = address;
    }

    @JsonProperty("notices")
    public Object getNotices() {
        return notices;
    }

    @JsonProperty("notices")
    public void setNotices(Object notices) {
        this.notices = notices;
    }

    @JsonProperty("supplierProceduresInfo")
    public List<SupplierProceduresInfo> getSupplierProceduresInfo() {
        return supplierProceduresInfo;
    }

    @JsonProperty("supplierProceduresInfo")
    public void setSupplierProceduresInfo(List<SupplierProceduresInfo> supplierProceduresInfo) {
        this.supplierProceduresInfo = supplierProceduresInfo;
    }

    @JsonProperty("catalog")
    public Catalog getCatalog() {
        return catalog;
    }

    @JsonProperty("catalog")
    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }

    @JsonProperty("caProceduresOngoing")
    public Object getCaProceduresOngoing() {
        return caProceduresOngoing;
    }

    @JsonProperty("caProceduresOngoing")
    public void setCaProceduresOngoing(Object caProceduresOngoing) {
        this.caProceduresOngoing = caProceduresOngoing;
    }

    @JsonProperty("caProceduresAwarded")
    public Object getCaProceduresAwarded() {
        return caProceduresAwarded;
    }

    @JsonProperty("caProceduresAwarded")
    public void setCaProceduresAwarded(Object caProceduresAwarded) {
        this.caProceduresAwarded = caProceduresAwarded;
    }

    @JsonProperty("caProceduresCancelled")
    public Object getCaProceduresCancelled() {
        return caProceduresCancelled;
    }

    @JsonProperty("caProceduresCancelled")
    public void setCaProceduresCancelled(Object caProceduresCancelled) {
        this.caProceduresCancelled = caProceduresCancelled;
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
