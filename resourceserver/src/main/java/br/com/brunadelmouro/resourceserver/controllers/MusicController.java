package br.com.brunadelmouro.resourceserver.controllers;

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

//    public ModelAndView home()
//    {
//        ModelAndView modelAndView = new ModelAndView();
//            modelAndView.setViewName("index");
//        return modelAndView;
//    }


    //OAuth2User -> used to access through the JSESSIONID cookie

    @GetMapping("/user")
    public Map<String, Object> user(@AuthenticationPrincipal OAuth2User principal) {
        System.out.println("TOKEN: " + SecurityContextHolder.getContext().getAuthentication());

        return Collections.singletonMap("name", Objects.requireNonNull(principal.getAttribute("name")));
    }

    @GetMapping("/get-musics")
    public ResponseEntity<List<String>> getMusics() {
        return new ResponseEntity<>(Arrays.asList(UUID.randomUUID().toString(), UUID.randomUUID().toString()), HttpStatus.OK);
    }
}
