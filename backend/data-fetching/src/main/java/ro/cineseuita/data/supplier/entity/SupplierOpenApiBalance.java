package ro.cineseuita.data.supplier.entity;

import com.fasterxml.jackson.annotation.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import ro.cineseuita.data.supplier.entity.components.OpenApiBalanceData;
import ro.cineseuita.data.supplier.entity.components.OpenApiMeta;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "balance_type",
        "caen_code",
        "cif",
        "data",
        "meta",
        "year"
})
@Document(collection = "supplierOpenApiBalance")
public class SupplierOpenApiBalance {

    @Id
    private String id;

    @JsonProperty("balance_type")
    private String balanceType;
    @JsonProperty("caen_code")
    private String caenCode;
    @JsonProperty("cif")
    @Indexed
    private String cif;
    @JsonProperty("data")
    private OpenApiBalanceData data;
    @JsonProperty("meta")
    private OpenApiMeta meta;
    @JsonProperty("year")
    @Indexed
    private Integer year;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("balance_type")
    public String getBalanceType() {
        return balanceType;
    }

    @JsonProperty("balance_type")
    public void setBalanceType(String balanceType) {
        this.balanceType = balanceType;
    }

    @JsonProperty("caen_code")
    public String getCaenCode() {
        return caenCode;
    }

    @JsonProperty("caen_code")
    public void setCaenCode(String caenCode) {
        this.caenCode = caenCode;
    }

    @JsonProperty("cif")
    public String getCif() {
        return cif;
    }

    @JsonProperty("cif")
    public void setCif(String cif) {
        this.cif = cif;
    }

    @JsonProperty("data")
    public OpenApiBalanceData getData() {
        return data;
    }

    @JsonProperty("data")
    public void setData(OpenApiBalanceData data) {
        this.data = data;
    }

    @JsonProperty("meta")
    public OpenApiMeta getMeta() {
        return meta;
    }

    @JsonProperty("meta")
    public void setMeta(OpenApiMeta meta) {
        this.meta = meta;
    }

    @JsonProperty("year")
    public Integer getYear() {
        return year;
    }

    @JsonProperty("year")
    public void setYear(Integer year) {
        this.year = year;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperties(Map<String, Object> additionalProperties) {
        this.additionalProperties = additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
