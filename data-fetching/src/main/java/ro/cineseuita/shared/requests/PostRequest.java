package ro.cineseuita.shared.requests;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.io.UnsupportedEncodingException;

public interface PostRequest extends GetRequest {

    byte[] getContentData() throws UnsupportedEncodingException, JsonProcessingException;

    String getContentType();
}
