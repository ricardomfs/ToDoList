package com.MyApplication.ToDoList.domain;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.LogoutDsl;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class SecurityConfigurations {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http
            .authorizeHttpRequests((requests) -> requests
                    .requestMatchers("/").permitAll()
                    .anyRequest().authenticated()
            )
            .formLogin((form)-> form
                    .loginPage("/login")
                    .permitAll()
            )
            .logout((logout)-> logout.permitAll());
        return http.build();
    }
}
