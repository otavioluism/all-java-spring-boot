package br.com.otavioluism.gestao_vagas.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> {
                    auth.requestMatchers("/candidate/").permitAll() // esta rota permitimos nao ter autenticacao (rota publica)
                            .requestMatchers("/company/").permitAll() // esta rota permitimos nao ter autenticacao (rota publica)
                            .requestMatchers("/auth/company").permitAll(); // esta rota permitimos nao ter autenticacao (rota publica)
                    auth.anyRequest().authenticated(); // qualquer outra rota deve ter autenticacao
                });
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
