package com.example.studentmanagementsystem.infra.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfigurations {

    @Autowired
    SecurityFilter filter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity){
        try {
            return httpSecurity
                    .csrf(AbstractHttpConfigurer::disable)
                    .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                    .authorizeHttpRequests(authorize -> authorize
                            .antMatchers(HttpMethod.POST, "/auth/login").permitAll()
                            .antMatchers(HttpMethod.POST, "/auth/register").permitAll()
                            .antMatchers("/api/professor").hasRole("ADMIN")
                            .antMatchers("/api/administrators").hasRole("ADMIN")
                            .antMatchers("/api/activities").hasRole("PROFESSOR")
                            .antMatchers("/api/classes").hasRole("ADMIN")
                            .antMatchers(HttpMethod.GET, "/api/classes").hasRole("STUDENT")
                            .anyRequest()
                            .authenticated()
                    )
                    .addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class)
                    .build();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        throw new RuntimeException("Error in filter");
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception{
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
