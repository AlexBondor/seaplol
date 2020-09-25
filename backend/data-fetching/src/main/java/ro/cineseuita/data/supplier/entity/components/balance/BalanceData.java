package ro.cineseuita.data.supplier.entity.components.balance;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

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
public class BalanceData {

    @JsonProperty("active_circulante_total")
    private Integer activeCirculanteTotal;
    @JsonProperty("active_imobilizate_total")
    private Integer activeImobilizateTotal;
    @JsonProperty("caen_descriere")
    private String caenDescriere;
    @JsonProperty("capitaluri_capital")
    private Integer capitaluriCapital;
    @JsonProperty("capitaluri_patrimoniul_regiei")
    private CapitaluriPatrimoniulRegiei capitaluriPatrimoniulRegiei;
    @JsonProperty("capitaluri_total")
    private Integer capitaluriTotal;
    @JsonProperty("casa_si_conturi")
    private Integer casaSiConturi;
    @JsonProperty("cheltuieli_in_avans")
    private Integer cheltuieliInAvans;
    @JsonProperty("cheltuieli_totale")
    private Integer cheltuieliTotale;
    @JsonProperty("cif")
    private Integer cif;
    @JsonProperty("cifra_de_afaceri_neta")
    private Integer cifraDeAfaceriNeta;
    @JsonProperty("creante")
    private Integer creante;
    @JsonProperty("datorii_total")
    private Integer datoriiTotal;
    @JsonProperty("numar_mediu_de_salariati")
    private Integer numarMediuDeSalariati;
    @JsonProperty("pierdere_bruta")
    private Integer pierdereBruta;
    @JsonProperty("pierdere_neta")
    private Integer pierdereNeta;
    @JsonProperty("profit_brut")
    private Integer profitBrut;
    @JsonProperty("profit_net")
    private Integer profitNet;
    @JsonProperty("provizioane")
    private Integer provizioane;
    @JsonProperty("stocuri")
    private Stocuri stocuri;
    @JsonProperty("venituri_in_avans")
    private VenituriInAvans venituriInAvans;
    @JsonProperty("venituri_totale")
    private Integer venituriTotale;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("active_circulante_total")
    public Integer getActiveCirculanteTotal() {
        return activeCirculanteTotal;
    }

    @JsonProperty("active_circulante_total")
    public void setActiveCirculanteTotal(Integer activeCirculanteTotal) {
        this.activeCirculanteTotal = activeCirculanteTotal;
    }

    @JsonProperty("active_imobilizate_total")
    public Integer getActiveImobilizateTotal() {
        return activeImobilizateTotal;
    }

    @JsonProperty("active_imobilizate_total")
    public void setActiveImobilizateTotal(Integer activeImobilizateTotal) {
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
    public Integer getCapitaluriCapital() {
        return capitaluriCapital;
    }

    @JsonProperty("capitaluri_capital")
    public void setCapitaluriCapital(Integer capitaluriCapital) {
        this.capitaluriCapital = capitaluriCapital;
    }

    @JsonProperty("capitaluri_patrimoniul_regiei")
    public CapitaluriPatrimoniulRegiei getCapitaluriPatrimoniulRegiei() {
        return capitaluriPatrimoniulRegiei;
    }

    @JsonProperty("capitaluri_patrimoniul_regiei")
    public void setCapitaluriPatrimoniulRegiei(CapitaluriPatrimoniulRegiei capitaluriPatrimoniulRegiei) {
        this.capitaluriPatrimoniulRegiei = capitaluriPatrimoniulRegiei;
    }

    @JsonProperty("capitaluri_total")
    public Integer getCapitaluriTotal() {
        return capitaluriTotal;
    }

    @JsonProperty("capitaluri_total")
    public void setCapitaluriTotal(Integer capitaluriTotal) {
        this.capitaluriTotal = capitaluriTotal;
    }

    @JsonProperty("casa_si_conturi")
    public Integer getCasaSiConturi() {
        return casaSiConturi;
    }

    @JsonProperty("casa_si_conturi")
    public void setCasaSiConturi(Integer casaSiConturi) {
        this.casaSiConturi = casaSiConturi;
    }

    @JsonProperty("cheltuieli_in_avans")
    public Integer getCheltuieliInAvans() {
        return cheltuieliInAvans;
    }

    @JsonProperty("cheltuieli_in_avans")
    public void setCheltuieliInAvans(Integer cheltuieliInAvans) {
        this.cheltuieliInAvans = cheltuieliInAvans;
    }

    @JsonProperty("cheltuieli_totale")
    public Integer getCheltuieliTotale() {
        return cheltuieliTotale;
    }

    @JsonProperty("cheltuieli_totale")
    public void setCheltuieliTotale(Integer cheltuieliTotale) {
        this.cheltuieliTotale = cheltuieliTotale;
    }

    @JsonProperty("cif")
    public Integer getCif() {
        return cif;
    }

    @JsonProperty("cif")
    public void setCif(Integer cif) {
        this.cif = cif;
    }

    @JsonProperty("cifra_de_afaceri_neta")
    public Integer getCifraDeAfaceriNeta() {
        return cifraDeAfaceriNeta;
    }

    @JsonProperty("cifra_de_afaceri_neta")
    public void setCifraDeAfaceriNeta(Integer cifraDeAfaceriNeta) {
        this.cifraDeAfaceriNeta = cifraDeAfaceriNeta;
    }

    @JsonProperty("creante")
    public Integer getCreante() {
        return creante;
    }

    @JsonProperty("creante")
    public void setCreante(Integer creante) {
        this.creante = creante;
    }

    @JsonProperty("datorii_total")
    public Integer getDatoriiTotal() {
        return datoriiTotal;
    }

    @JsonProperty("datorii_total")
    public void setDatoriiTotal(Integer datoriiTotal) {
        this.datoriiTotal = datoriiTotal;
    }

    @JsonProperty("numar_mediu_de_salariati")
    public Integer getNumarMediuDeSalariati() {
        return numarMediuDeSalariati;
    }

    @JsonProperty("numar_mediu_de_salariati")
    public void setNumarMediuDeSalariati(Integer numarMediuDeSalariati) {
        this.numarMediuDeSalariati = numarMediuDeSalariati;
    }

    @JsonProperty("pierdere_bruta")
    public Integer getPierdereBruta() {
        return pierdereBruta;
    }

    @JsonProperty("pierdere_bruta")
    public void setPierdereBruta(Integer pierdereBruta) {
        this.pierdereBruta = pierdereBruta;
    }

    @JsonProperty("pierdere_neta")
    public Integer getPierdereNeta() {
        return pierdereNeta;
    }

    @JsonProperty("pierdere_neta")
    public void setPierdereNeta(Integer pierdereNeta) {
        this.pierdereNeta = pierdereNeta;
    }

    @JsonProperty("profit_brut")
    public Integer getProfitBrut() {
        return profitBrut;
    }

    @JsonProperty("profit_brut")
    public void setProfitBrut(Integer profitBrut) {
        this.profitBrut = profitBrut;
    }

    @JsonProperty("profit_net")
    public Integer getProfitNet() {
        return profitNet;
    }

    @JsonProperty("profit_net")
    public void setProfitNet(Integer profitNet) {
        this.profitNet = profitNet;
    }

    @JsonProperty("provizioane")
    public Integer getProvizioane() {
        return provizioane;
    }

    @JsonProperty("provizioane")
    public void setProvizioane(Integer provizioane) {
        this.provizioane = provizioane;
    }

    @JsonProperty("stocuri")
    public Stocuri getStocuri() {
        return stocuri;
    }

    @JsonProperty("stocuri")
    public void setStocuri(Stocuri stocuri) {
        this.stocuri = stocuri;
    }

    @JsonProperty("venituri_in_avans")
    public VenituriInAvans getVenituriInAvans() {
        return venituriInAvans;
    }

    @JsonProperty("venituri_in_avans")
    public void setVenituriInAvans(VenituriInAvans venituriInAvans) {
        this.venituriInAvans = venituriInAvans;
    }

    @JsonProperty("venituri_totale")
    public Integer getVenituriTotale() {
        return venituriTotale;
    }

    @JsonProperty("venituri_totale")
    public void setVenituriTotale(Integer venituriTotale) {
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