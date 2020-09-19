package ro.cineseuita.data.shared;

import org.springframework.stereotype.Service;
import ro.cineseuita.data.shared.requests.GetRequest;
import ro.cineseuita.data.shared.requests.PostRequest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Service
public class HttpService {

    public String doRequest(PostRequest postRequest) throws IOException {
        URL url = new URL(postRequest.getUrl());
        byte[] contentData = postRequest.getContentData();

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("REFERER", postRequest.getReferer());
        connection.setRequestProperty("Content-Type", postRequest.getContentType());
        connection.setDoOutput(true);
        connection.getOutputStream().write(contentData);

        return getConnectionInputStreamData(connection);
    }

    public String doRequest(GetRequest getRequest) throws IOException {
        URL url = new URL(getRequest.getUrl());
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("REFERER", getRequest.getReferer());

        return getConnectionInputStreamData(connection);
    }

    private String getConnectionInputStreamData(HttpURLConnection connection) throws IOException {
        BufferedReader in = new BufferedReader(
                new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuffer content = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine).append("\n");
        }

        in.close();
        return content.toString();
    }

}
