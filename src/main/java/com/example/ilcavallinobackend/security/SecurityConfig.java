package com.example.ilcavallinobackend.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final UtenteDetailsService utenteDetailsService;

    public SecurityConfig(UtenteDetailsService utenteDetailsService){
        this.utenteDetailsService=utenteDetailsService;
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http
                //GLI ENDPOINT DI LOGIN E REGISTRAZIONE DIVENTANO ACCESSIBILI SENZA AUTENTICAZIONE
                .csrf(crsf -> crsf.disable())
                .authorizeHttpRequests(autenticazione -> autenticazione
                        .requestMatchers("/api/autenticazione/**").permitAll()
                        .anyRequest().authenticated())
                .sessionManagement(sm-> sm
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(AuthenticationProvider())
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }
}