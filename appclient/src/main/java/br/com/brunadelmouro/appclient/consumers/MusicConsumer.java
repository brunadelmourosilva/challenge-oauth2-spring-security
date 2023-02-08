package br.com.brunadelmouro.appclient.consumers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class MusicConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(MusicConsumer.class);

    private static final String URL = "http://127.0.0.1:8081/get-musics-jwt";

    @Autowired
    private RestTemplate restTemplate;

    public List<String> getMusicsFromResourceServer(OAuth2AuthorizedClient authorizedClient) {
        var jwtAccessToken = authorizedClient.getAccessToken().getTokenValue();
        LOGGER.info("jwtAccessToken:  {}", jwtAccessToken);

        var headers = new HttpHeaders();
        headers.add("Authorization", "Bearer " + jwtAccessToken);

        var entity = new HttpEntity<>(headers);

        var response =
                restTemplate.exchange(URL, HttpMethod.GET, entity, new ParameterizedTypeReference<List<String>>() {});

        return response.getBody();

    }
}
