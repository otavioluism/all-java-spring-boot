package br.com.otavioluism.gestao_vagas.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> {
                    auth.requestMatchers("/candidate/").permitAll() // esta rota permitimos nao ter autenticacao (publica)
                            .requestMatchers("/company/").permitAll(); // esta rota permitimos nao ter autenticacao (publica)
                    auth.anyRequest().authenticated(); // qualquer outra rota deve ter autenticacao
                });
        return http.build();
    }

}
