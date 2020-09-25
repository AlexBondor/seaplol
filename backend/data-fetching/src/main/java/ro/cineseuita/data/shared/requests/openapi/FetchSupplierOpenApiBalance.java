package ro.cineseuita.data.shared.requests.openapi;

import ro.cineseuita.data.shared.requests.OpenApiGet;

import javax.ws.rs.core.MediaType;

public class FetchSupplierOpenApiBalance implements OpenApiGet {

    private static final String URL = "https://api.openapi.ro/api/companies/";
    private static final String KEY = "";

    private final String cui;
    private final Integer year;

    public FetchSupplierOpenApiBalance(String cui, Integer year) {
        this.cui = cui;
        this.year = year;
    }

    @Override
    public String getUrl() {
        return URL + cui + "/balances/" + year;
    }

    @Override
    public MediaType getMediaType() {
        return MediaType.APPLICATION_JSON_TYPE;
    }

    @Override
    public String getApiKey() {
        return KEY;
    }

}