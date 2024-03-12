package dev.nj.webquiz.config;

import dev.nj.webquiz.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
@Configuration
public class WebSecurityConfig {

    private final UserService service;

    public WebSecurityConfig(UserService service) {
        this.service = service;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(AntPathRequestMatcher.antMatcher("/h2/**")).permitAll()
                        .requestMatchers(AntPathRequestMatcher.antMatcher("/actuator/shutdown/**")).permitAll()
                        .requestMatchers(new AntPathRequestMatcher("/api/register", "POST")).permitAll()
                        .requestMatchers(AntPathRequestMatcher.antMatcher("/api/quizzes")).authenticated()
//                        .requestMatchers(AntPathRequestMatcher.antMatcher("/api/quizzes/**")).authenticated()
                )
                .userDetailsService(service)
                .csrf(AbstractHttpConfigurer::disable)
                .headers(headers -> headers.frameOptions(HeadersConfigurer.FrameOptionsConfig::disable))
                .httpBasic(Customizer.withDefaults());
        return http.build();
    }


}
