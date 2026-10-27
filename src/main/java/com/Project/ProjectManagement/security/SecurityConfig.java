package com.Project.ProjectManagement.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                .csrf(AbstractHttpConfigurer::disable)
                .securityContext(context -> context.requireExplicitSave(false))
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/users/signup").permitAll()
                        .requestMatchers("/auth/login").permitAll()
                        .requestMatchers(HttpMethod.POST, "/performances").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/performances/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/performances/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.POST, "/performances/*/schedules").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/performances/**").permitAll()
                        .requestMatchers(HttpMethod.GET, "/halls/**").permitAll()
                        .requestMatchers("/halls/**").hasRole("ADMIN")
                        .requestMatchers("/venues/**").permitAll()
                        .requestMatchers(HttpMethod.GET, "/seats/**").permitAll()
                        .requestMatchers(HttpMethod.POST, "/seats/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/seats/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/seats/**").hasRole("ADMIN")
                        .anyRequest().authenticated()
                );

        return http.build();
    }
    @Bean
    public AuthenticationManager authenticationManager(//입력한 로그인 정보가 맞는지 확인
            AuthenticationConfiguration configuration
    ) throws Exception {
        return configuration.getAuthenticationManager();
    }
}
