package ro.cineseuita.data.shared;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.ClientProperties;
import org.springframework.stereotype.Service;
import ro.cineseuita.data.shared.requests.GetRequest;
import ro.cineseuita.data.shared.requests.OpenApiGet;
import ro.cineseuita.data.shared.requests.PostRequest;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Service
public class HttpService {

    private final Client client;

    public HttpService() {
        ClientConfig configuration = new ClientConfig();
        configuration = configuration.property(ClientProperties.CONNECT_TIMEOUT, 42000);
        configuration = configuration.property(ClientProperties.READ_TIMEOUT, 42000);
        client = ClientBuilder.newClient(configuration);
    }

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

    // TODO: maybe refactor above request to all use javax.ws ...
    public String doRequest(OpenApiGet openApiGet) {
        Response response = client.target(openApiGet.getUrl())
                .request(openApiGet.getMediaType())
                .header("x-api-key", openApiGet.getApiKey())
                .get();

        return response.readEntity(String.class);
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
