package com.sillysally.kyst4backend.config;

import com.sillysally.kyst4backend.service.UserModelService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    private final PasswordConfig bcrypt;
    private final UserModelService userModelService;

    public SecurityConfig(PasswordConfig bcrypt, UserModelService userModelService) {
        this.bcrypt = bcrypt;
        this.userModelService = userModelService;
    }

    @Bean
    public SecurityFilterChain securityFilterChain (HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeHttpRequests(requests -> {
                    requests
                            .requestMatchers("/", "/signUpPage").permitAll()
                            .anyRequest()
                            .authenticated();
                }).formLogin();
        return http.build();
    }

    //Our implementation instead of the original
    public DaoAuthenticationProvider authenticationOverride(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService((UserDetailsService) userModelService);
        provider.setPasswordEncoder(bcrypt.bCryptEncoder());
        return provider;
    }
}
