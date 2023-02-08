package br.com.brunadelmouro.resourceserver.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

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
                .oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt)
                .logout()
                .logoutSuccessUrl("/login")
                .invalidateHttpSession(true)
                .clearAuthentication(true)
                .deleteCookies("JSESSIONID");
                //.and().csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());;


        return security.build();
    }
}
