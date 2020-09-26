package ro.cineseuita.data.shared.requests;

import javax.ws.rs.core.MediaType;

public interface OpenApiGet {
    String KEY = "";

    String getUrl();

    MediaType getMediaType();

    String getApiKey();

}
