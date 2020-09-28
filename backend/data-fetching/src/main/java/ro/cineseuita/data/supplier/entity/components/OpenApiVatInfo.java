package ro.cineseuita.data.supplier.entity.components;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "tip",
        "tip_descriere",
        "de_la",
        "pana_la",
        "publicare",
        "actualizare"
})
public class OpenApiVatInfo {

    @JsonProperty("tip")
    private String tip;
    @JsonProperty("tip_descriere")
    private String tipDescriere;
    @JsonProperty("de_la")
    private String deLa;
    @JsonProperty("pana_la")
    private String panaLa;
    @JsonProperty("publicare")
    private String publicare;
    @JsonProperty("actualizare")
    private String actualizare;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("tip")
    public String getTip() {
        return tip;
    }

    @JsonProperty("tip")
    public void setTip(String tip) {
        this.tip = tip;
    }

    @JsonProperty("tip_descriere")
    public String getTipDescriere() {
        return tipDescriere;
    }

    @JsonProperty("tip_descriere")
    public void setTipDescriere(String tipDescriere) {
        this.tipDescriere = tipDescriere;
    }

    @JsonProperty("de_la")
    public String getDeLa() {
        return deLa;
    }

    @JsonProperty("de_la")
    public void setDeLa(String deLa) {
        this.deLa = deLa;
    }

    @JsonProperty("pana_la")
    public String getPanaLa() {
        return panaLa;
    }

    @JsonProperty("pana_la")
    public void setPanaLa(String panaLa) {
        this.panaLa = panaLa;
    }

    @JsonProperty("publicare")
    public String getPublicare() {
        return publicare;
    }

    @JsonProperty("publicare")
    public void setPublicare(String publicare) {
        this.publicare = publicare;
    }

    @JsonProperty("actualizare")
    public String getActualizare() {
        return actualizare;
    }

    @JsonProperty("actualizare")
    public void setActualizare(String actualizare) {
        this.actualizare = actualizare;
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
