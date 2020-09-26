package ro.cineseuita.data.supplier.entity.components;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "active_circulante_total",
        "active_imobilizate_total",
        "caen_descriere",
        "capitaluri_capital",
        "capitaluri_patrimoniul_regiei",
        "capitaluri_total",
        "casa_si_conturi",
        "cheltuieli_in_avans",
        "cheltuieli_totale",
        "cif",
        "cifra_de_afaceri_neta",
        "creante",
        "datorii_total",
        "numar_mediu_de_salariati",
        "pierdere_bruta",
        "pierdere_neta",
        "profit_brut",
        "profit_net",
        "provizioane",
        "stocuri",
        "venituri_in_avans",
        "venituri_totale"
})
public class OpenApiBalanceData {

    @JsonProperty("active_circulante_total")
    private Long activeCirculanteTotal;
    @JsonProperty("active_imobilizate_total")
    private Long activeImobilizateTotal;
    @JsonProperty("caen_descriere")
    private String caenDescriere;
    @JsonProperty("capitaluri_capital")
    private Long capitaluriCapital;
    @JsonProperty("capitaluri_patrimoniul_regiei")
    private Long capitaluriPatrimoniulRegiei;
    @JsonProperty("capitaluri_total")
    private Long capitaluriTotal;
    @JsonProperty("casa_si_conturi")
    private Long casaSiConturi;
    @JsonProperty("cheltuieli_in_avans")
    private Long cheltuieliInAvans;
    @JsonProperty("cheltuieli_totale")
    private Long cheltuieliTotale;
    @JsonProperty("cif")
    private Long cif;
    @JsonProperty("cifra_de_afaceri_neta")
    private Long cifraDeAfaceriNeta;
    @JsonProperty("creante")
    private Long creante;
    @JsonProperty("datorii_total")
    private Long datoriiTotal;
    @JsonProperty("numar_mediu_de_salariati")
    private Long numarMediuDeSalariati;
    @JsonProperty("pierdere_bruta")
    private Long pierdereBruta;
    @JsonProperty("pierdere_neta")
    private Long pierdereNeta;
    @JsonProperty("profit_brut")
    private Long profitBrut;
    @JsonProperty("profit_net")
    private Long profitNet;
    @JsonProperty("provizioane")
    private Long provizioane;
    @JsonProperty("stocuri")
    private Long stocuri;
    @JsonProperty("venituri_in_avans")
    private Long venituriInAvans;
    @JsonProperty("venituri_totale")
    private Long venituriTotale;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("active_circulante_total")
    public Long getActiveCirculanteTotal() {
        return activeCirculanteTotal;
    }

    @JsonProperty("active_circulante_total")
    public void setActiveCirculanteTotal(Long activeCirculanteTotal) {
        this.activeCirculanteTotal = activeCirculanteTotal;
    }

    @JsonProperty("active_imobilizate_total")
    public Long getActiveImobilizateTotal() {
        return activeImobilizateTotal;
    }

    @JsonProperty("active_imobilizate_total")
    public void setActiveImobilizateTotal(Long activeImobilizateTotal) {
        this.activeImobilizateTotal = activeImobilizateTotal;
    }

    @JsonProperty("caen_descriere")
    public String getCaenDescriere() {
        return caenDescriere;
    }

    @JsonProperty("caen_descriere")
    public void setCaenDescriere(String caenDescriere) {
        this.caenDescriere = caenDescriere;
    }

    @JsonProperty("capitaluri_capital")
    public Long getCapitaluriCapital() {
        return capitaluriCapital;
    }

    @JsonProperty("capitaluri_capital")
    public void setCapitaluriCapital(Long capitaluriCapital) {
        this.capitaluriCapital = capitaluriCapital;
    }

    @JsonProperty("capitaluri_patrimoniul_regiei")
    public Long getCapitaluriPatrimoniulRegiei() {
        return capitaluriPatrimoniulRegiei;
    }

    @JsonProperty("capitaluri_patrimoniul_regiei")
    public void setCapitaluriPatrimoniulRegiei(Long capitaluriPatrimoniulRegiei) {
        this.capitaluriPatrimoniulRegiei = capitaluriPatrimoniulRegiei;
    }

    @JsonProperty("capitaluri_total")
    public Long getCapitaluriTotal() {
        return capitaluriTotal;
    }

    @JsonProperty("capitaluri_total")
    public void setCapitaluriTotal(Long capitaluriTotal) {
        this.capitaluriTotal = capitaluriTotal;
    }

    @JsonProperty("casa_si_conturi")
    public Long getCasaSiConturi() {
        return casaSiConturi;
    }

    @JsonProperty("casa_si_conturi")
    public void setCasaSiConturi(Long casaSiConturi) {
        this.casaSiConturi = casaSiConturi;
    }

    @JsonProperty("cheltuieli_in_avans")
    public Long getCheltuieliInAvans() {
        return cheltuieliInAvans;
    }

    @JsonProperty("cheltuieli_in_avans")
    public void setCheltuieliInAvans(Long cheltuieliInAvans) {
        this.cheltuieliInAvans = cheltuieliInAvans;
    }

    @JsonProperty("cheltuieli_totale")
    public Long getCheltuieliTotale() {
        return cheltuieliTotale;
    }

    @JsonProperty("cheltuieli_totale")
    public void setCheltuieliTotale(Long cheltuieliTotale) {
        this.cheltuieliTotale = cheltuieliTotale;
    }

    @JsonProperty("cif")
    public Long getCif() {
        return cif;
    }

    @JsonProperty("cif")
    public void setCif(Long cif) {
        this.cif = cif;
    }

    @JsonProperty("cifra_de_afaceri_neta")
    public Long getCifraDeAfaceriNeta() {
        return cifraDeAfaceriNeta;
    }

    @JsonProperty("cifra_de_afaceri_neta")
    public void setCifraDeAfaceriNeta(Long cifraDeAfaceriNeta) {
        this.cifraDeAfaceriNeta = cifraDeAfaceriNeta;
    }

    @JsonProperty("creante")
    public Long getCreante() {
        return creante;
    }

    @JsonProperty("creante")
    public void setCreante(Long creante) {
        this.creante = creante;
    }

    @JsonProperty("datorii_total")
    public Long getDatoriiTotal() {
        return datoriiTotal;
    }

    @JsonProperty("datorii_total")
    public void setDatoriiTotal(Long datoriiTotal) {
        this.datoriiTotal = datoriiTotal;
    }

    @JsonProperty("numar_mediu_de_salariati")
    public Long getNumarMediuDeSalariati() {
        return numarMediuDeSalariati;
    }

    @JsonProperty("numar_mediu_de_salariati")
    public void setNumarMediuDeSalariati(Long numarMediuDeSalariati) {
        this.numarMediuDeSalariati = numarMediuDeSalariati;
    }

    @JsonProperty("pierdere_bruta")
    public Long getPierdereBruta() {
        return pierdereBruta;
    }

    @JsonProperty("pierdere_bruta")
    public void setPierdereBruta(Long pierdereBruta) {
        this.pierdereBruta = pierdereBruta;
    }

    @JsonProperty("pierdere_neta")
    public Long getPierdereNeta() {
        return pierdereNeta;
    }

    @JsonProperty("pierdere_neta")
    public void setPierdereNeta(Long pierdereNeta) {
        this.pierdereNeta = pierdereNeta;
    }

    @JsonProperty("profit_brut")
    public Long getProfitBrut() {
        return profitBrut;
    }

    @JsonProperty("profit_brut")
    public void setProfitBrut(Long profitBrut) {
        this.profitBrut = profitBrut;
    }

    @JsonProperty("profit_net")
    public Long getProfitNet() {
        return profitNet;
    }

    @JsonProperty("profit_net")
    public void setProfitNet(Long profitNet) {
        this.profitNet = profitNet;
    }

    @JsonProperty("provizioane")
    public Long getProvizioane() {
        return provizioane;
    }

    @JsonProperty("provizioane")
    public void setProvizioane(Long provizioane) {
        this.provizioane = provizioane;
    }

    @JsonProperty("stocuri")
    public Long getStocuri() {
        return stocuri;
    }

    @JsonProperty("stocuri")
    public void setStocuri(Long stocuri) {
        this.stocuri = stocuri;
    }

    @JsonProperty("venituri_in_avans")
    public Long getVenituriInAvans() {
        return venituriInAvans;
    }

    @JsonProperty("venituri_in_avans")
    public void setVenituriInAvans(Long venituriInAvans) {
        this.venituriInAvans = venituriInAvans;
    }

    @JsonProperty("venituri_totale")
    public Long getVenituriTotale() {
        return venituriTotale;
    }

    @JsonProperty("venituri_totale")
    public void setVenituriTotale(Long venituriTotale) {
        this.venituriTotale = venituriTotale;
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