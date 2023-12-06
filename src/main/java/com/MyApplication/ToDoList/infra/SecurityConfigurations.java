package com.MyApplication.ToDoList.infra;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfigurations {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .anyRequest().permitAll();
//                .authenticated()
//                .and()
//                .httpBasic();

        http.csrf().disable();
        /** ESSA OPÇÃO PERMITE QUE O H2 CONSOLE FUNCIONE COM S SS ATIVADO **/
        /*
        *  POR PADRÃO, O SPRING SECURITY DESATIVA A RENDERIZAÇÃO DENTRO DE UM IFRAME
        *  PORQUE PERMITIR QUE UMA PÁGINA DA WEB SEJA ADICIONADA A UM FRAME PODE SER UM PROBLEMA DE SEGURANÇA, POR EXEMPLO,
        *  CLICKJACKING. COMO O CONSOLE H2 É EXECUTADO DENTRO DE UM QUADRO, ENQUANTO O SPRING SECURITY ESTÁ HABILITADO,
        *  AS OPÇÕES DE QUADRO DEVEM SER DESATIVADAS EXPLICITAMENTE PARA QUE O CONSOLE H2 FUNCIONE.
        */
        http.headers().frameOptions().disable();
        return http.build();
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }
}
