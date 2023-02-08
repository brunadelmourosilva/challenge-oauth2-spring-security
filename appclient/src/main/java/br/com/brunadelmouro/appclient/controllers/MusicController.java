package br.com.brunadelmouro.appclient.controllers;

import br.com.brunadelmouro.appclient.consumers.MusicConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MusicController {

    @Autowired
    private MusicConsumer musicConsumer;

    /**
     * To use this endpoint:
     * - turn on the 3 microservices
     * - on browser, access: http://127.0.0.1:8080/get-musics
     * - provide the login presents in the authorization server
     * - it will be returned the value from the resource server :)
     * */
    @GetMapping("/get-musics")
    public ResponseEntity<List<String>> getMusics(@RegisteredOAuth2AuthorizedClient("users-client-oidc") OAuth2AuthorizedClient authorizedClient) {
        return new ResponseEntity<>(musicConsumer.getMusicsFromResourceServer(authorizedClient), HttpStatus.OK);
    }
}
