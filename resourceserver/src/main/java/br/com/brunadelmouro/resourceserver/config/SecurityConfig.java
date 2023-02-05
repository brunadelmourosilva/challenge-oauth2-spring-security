package br.com.brunadelmouro.resourceserver.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    ClientRegistrationRepository clientRegistrationRepository;

    /**
     * This repo use the strategy to verify users authenticated using COOKIES(social login).
     * There is another way to verify users authenticated through the JWT. For this, it's necessary
     * transform this repo in a resource server authorization.
     * */

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity security) throws Exception {

        security.authorizeHttpRequests(
                authorizationConfig ->
                    authorizationConfig
                    .requestMatchers("/login", "/error", "/webjars/**").permitAll()
                    .anyRequest().authenticated()
                )
                .oauth2Login()
                .and()
                .logout()
                .logoutSuccessUrl("/login")
                //.logoutSuccessHandler(oidcLogoutSuccessHandler())
                .invalidateHttpSession(true)
                .clearAuthentication(true)
                .deleteCookies("JSESSIONID");
                //.and().csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());;


        return security.build();
    }

//    private OidcClientInitiatedLogoutSuccessHandler oidcLogoutSuccessHandler() {
//        OidcClientInitiatedLogoutSuccessHandler successHandler =
//                new OidcClientInitiatedLogoutSuccessHandler(clientRegistrationRepository);
//        successHandler.setPostLogoutRedirectUri("http://localhost:8080/login");
//        return successHandler;
//    }

}
