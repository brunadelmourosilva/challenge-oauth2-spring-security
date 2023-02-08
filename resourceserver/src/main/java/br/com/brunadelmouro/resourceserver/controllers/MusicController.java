package br.com.brunadelmouro.resourceserver.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/")
public class MusicController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MusicController.class);

    //OAuth2User -> used to access through the JSESSIONID cookie
    //JWT -> used to access through the jwt token using the headers


    /**
     * To use this endpoint:
     * - turn on the 2 microservices
     * - on browser, access: http://localhost:8081/login
     * - provide the login choosing a social login option :)
     * */
    @GetMapping("/user")
    public Map<String, Object> user(@AuthenticationPrincipal OAuth2User principal) {
        System.out.println("TOKEN: " + SecurityContextHolder.getContext().getAuthentication());

        return Collections.singletonMap("name", Objects.requireNonNull(principal.getAttribute("name")));
    }

    @GetMapping("/get-musics-cookie")
    public ResponseEntity<List<String>> getMusics(@AuthenticationPrincipal OAuth2User principal) {
        LOGGER.info("Info by OAuth2User: {}", SecurityContextHolder.getContext().getAuthentication());

        return new ResponseEntity<>(Arrays.asList("Get musics authorized by a social authorization server", UUID.randomUUID().toString(), UUID.randomUUID().toString()), HttpStatus.OK);
    }

    // it will be used in the app client microservice
    @GetMapping("/get-musics-jwt")
    public ResponseEntity<List<String>> getMusics(@AuthenticationPrincipal Jwt jwt) {
        LOGGER.info("Info by Jwt: {}", jwt.getTokenValue());

        return new ResponseEntity<>(Arrays.asList("Get musics authorized by my own authorization server", UUID.randomUUID().toString(), UUID.randomUUID().toString()), HttpStatus.OK);
    }
}
