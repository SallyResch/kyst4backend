package com.sillysally.kyst4backend.config;

import com.sillysally.kyst4backend.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    private final PasswordConfig bcrypt;
    private final UserService userService;

    public SecurityConfig(PasswordConfig bcrypt, UserService userService) {
        this.bcrypt = bcrypt;
        this.userService = userService;
    }

    @Bean
    public SecurityFilterChain securityFilterChain (HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeHttpRequests(requests -> {
                    requests
                            .requestMatchers("/", "/start").permitAll()
                            .requestMatchers("/admin").hasRole("ADMIN")
                            .requestMatchers("user").hasRole("USER")
                            .anyRequest()
                            .authenticated();
                }).formLogin();
        return http.build();
    }

    //Our implementation instead of the original
    public DaoAuthenticationProvider authenticationOverride(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userService);
        provider.setPasswordEncoder(bcrypt.bCryptEncoder());

        return provider;
    }
}
