package ro.cineseuita.data.shared.requests;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.LinkedHashMap;
import java.util.Map;

public abstract class PostRequestBase implements PostRequest {

    private static final String UTF_8 = StandardCharsets.UTF_8.toString();
    protected final Map<String, Object> params;

    public PostRequestBase() {
        params = new LinkedHashMap<>();
    }

    protected byte[] buildContentData(Map<String, Object> params) throws UnsupportedEncodingException {
        StringBuilder postData = new StringBuilder();
        for (Map.Entry<String, Object> param : params.entrySet()) {
            if (postData.length() != 0) {
                postData.append('&');
            }
            postData.append(URLEncoder.encode(param.getKey(), UTF_8));
            postData.append('=');
            postData.append(URLEncoder.encode(String.valueOf(param.getValue()), UTF_8));
        }
        return postData.toString().getBytes(UTF_8);
    }

    @Override
    public byte[] getContentData() throws UnsupportedEncodingException, JsonProcessingException {
        buildParams();
        return new ObjectMapper().writeValueAsString(params).getBytes(StandardCharsets.UTF_8.toString());
    }

    protected abstract void buildParams();


}
