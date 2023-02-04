package br.com.brunadelmouro.resourceserver.controllers;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping("/")
public class MusicController {

//    @GetMapping("/get-musics")
//    public ResponseEntity<List<String>> getMusics() {
//        return new ResponseEntity<>(Arrays.asList(UUID.randomUUID().toString(), UUID.randomUUID().toString()), HttpStatus.OK);
//    }

//    public ModelAndView home()
//    {
//        ModelAndView modelAndView = new ModelAndView();
//            modelAndView.setViewName("index");
//        return modelAndView;
//    }

    @GetMapping("/user")
    public Map<String, Object> user(@AuthenticationPrincipal OAuth2User principal) {
        return Collections.singletonMap("name", principal.getAttribute("name"));
    }
}
