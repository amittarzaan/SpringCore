package com.alibou.oauth2.landleasing.login.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http
        .csrf()
        .disable()
        .authorizeHttpRequests()
        .requestMatchers("/static/**").permitAll()//basically for this URL pattern authentication not required
        .requestMatchers("/dynamic/*").fullyAuthenticated() //login required with this pattern
        .anyRequest()
        .authenticated()
        .and()
        .oauth2Login()
    ;

    System.out.println("calling SecurityConfig...AMIT LAHA1");
    return http.build();
  }
}
