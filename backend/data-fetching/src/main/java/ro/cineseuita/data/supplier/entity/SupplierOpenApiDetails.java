package ro.cineseuita.data.supplier.entity;

import com.fasterxml.jackson.annotation.*;
import ro.cineseuita.data.supplier.entity.components.OpenApiMeta;
import ro.cineseuita.data.supplier.entity.components.OpenApiVatInfo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "cif",
        "numar_reg_com",
        "radiata",
        "denumire",
        "adresa",
        "stare",
        "cod_postal",
        "judet",
        "telefon",
        "fax",
        "tva",
        "impozit_micro",
        "impozit_profit",
        "accize",
        "act_autorizare",
        "ultima_prelucrare",
        "ultima_declaratie",
        "tva_la_incasare",
        "meta"
})
public class SupplierOpenApiDetails {

    @JsonProperty("cif")
    private String cif;
    @JsonProperty("numar_reg_com")
    private String numarRegCom;
    @JsonProperty("radiata")
    private Boolean radiata;
    @JsonProperty("denumire")
    private String denumire;
    @JsonProperty("adresa")
    private String adresa;
    @JsonProperty("stare")
    private String stare;
    @JsonProperty("cod_postal")
    private String codPostal;
    @JsonProperty("judet")
    private String judet;
    @JsonProperty("telefon")
    private String telefon;
    @JsonProperty("fax")
    private String fax;
    @JsonProperty("tva")
    private String tva;
    @JsonProperty("impozit_micro")
    private String impozitMicro;
    @JsonProperty("impozit_profit")
    private String impozitProfit;
    @JsonProperty("accize")
    private String accize;
    @JsonProperty("act_autorizare")
    private String actAutorizare;
    @JsonProperty("ultima_prelucrare")
    private String ultimaPrelucrare;
    @JsonProperty("ultima_declaratie")
    private String ultimaDeclaratie;
    @JsonProperty("tva_la_incasare")
    private List<OpenApiVatInfo> openApiVatInfo = null;
    @JsonProperty("meta")
    private OpenApiMeta openApiMeta;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("cif")
    public String getCif() {
        return cif;
    }

    @JsonProperty("cif")
    public void setCif(String cif) {
        this.cif = cif;
    }

    @JsonProperty("numar_reg_com")
    public String getNumarRegCom() {
        return numarRegCom;
    }

    @JsonProperty("numar_reg_com")
    public void setNumarRegCom(String numarRegCom) {
        this.numarRegCom = numarRegCom;
    }

    @JsonProperty("radiata")
    public Boolean getRadiata() {
        return radiata;
    }

    @JsonProperty("radiata")
    public void setRadiata(Boolean radiata) {
        this.radiata = radiata;
    }

    @JsonProperty("denumire")
    public String getDenumire() {
        return denumire;
    }

    @JsonProperty("denumire")
    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    @JsonProperty("adresa")
    public String getAdresa() {
        return adresa;
    }

    @JsonProperty("adresa")
    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    @JsonProperty("stare")
    public String getStare() {
        return stare;
    }

    @JsonProperty("stare")
    public void setStare(String stare) {
        this.stare = stare;
    }

    @JsonProperty("cod_postal")
    public String getCodPostal() {
        return codPostal;
    }

    @JsonProperty("cod_postal")
    public void setCodPostal(String codPostal) {
        this.codPostal = codPostal;
    }

    @JsonProperty("judet")
    public String getJudet() {
        return judet;
    }

    @JsonProperty("judet")
    public void setJudet(String judet) {
        this.judet = judet;
    }

    @JsonProperty("telefon")
    public String getTelefon() {
        return telefon;
    }

    @JsonProperty("telefon")
    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    @JsonProperty("fax")
    public String getFax() {
        return fax;
    }

    @JsonProperty("fax")
    public void setFax(String fax) {
        this.fax = fax;
    }

    @JsonProperty("tva")
    public String getTva() {
        return tva;
    }

    @JsonProperty("tva")
    public void setTva(String tva) {
        this.tva = tva;
    }

    @JsonProperty("impozit_micro")
    public String getImpozitMicro() {
        return impozitMicro;
    }

    @JsonProperty("impozit_micro")
    public void setImpozitMicro(String impozitMicro) {
        this.impozitMicro = impozitMicro;
    }

    @JsonProperty("impozit_profit")
    public String getImpozitProfit() {
        return impozitProfit;
    }

    @JsonProperty("impozit_profit")
    public void setImpozitProfit(String impozitProfit) {
        this.impozitProfit = impozitProfit;
    }

    @JsonProperty("accize")
    public String getAccize() {
        return accize;
    }

    @JsonProperty("accize")
    public void setAccize(String accize) {
        this.accize = accize;
    }

    @JsonProperty("act_autorizare")
    public String getActAutorizare() {
        return actAutorizare;
    }

    @JsonProperty("act_autorizare")
    public void setActAutorizare(String actAutorizare) {
        this.actAutorizare = actAutorizare;
    }

    @JsonProperty("ultima_prelucrare")
    public String getUltimaPrelucrare() {
        return ultimaPrelucrare;
    }

    @JsonProperty("ultima_prelucrare")
    public void setUltimaPrelucrare(String ultimaPrelucrare) {
        this.ultimaPrelucrare = ultimaPrelucrare;
    }

    @JsonProperty("ultima_declaratie")
    public String getUltimaDeclaratie() {
        return ultimaDeclaratie;
    }

    @JsonProperty("ultima_declaratie")
    public void setUltimaDeclaratie(String ultimaDeclaratie) {
        this.ultimaDeclaratie = ultimaDeclaratie;
    }

    @JsonProperty("tva_la_incasare")
    public List<OpenApiVatInfo> getTvaLaIncasare() {
        return openApiVatInfo;
    }

    @JsonProperty("tva_la_incasare")
    public void setTvaLaIncasare(List<OpenApiVatInfo> openApiVatInfo) {
        this.openApiVatInfo = openApiVatInfo;
    }

    @JsonProperty("meta")
    public OpenApiMeta getMeta() {
        return openApiMeta;
    }

    @JsonProperty("meta")
    public void setMeta(OpenApiMeta openApiMeta) {
        this.openApiMeta = openApiMeta;
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
