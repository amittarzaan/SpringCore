package com.alibou.oauth2.landleasing.login.security;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.OAuth2AuthenticatedPrincipal;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.alibou.oauth2.landleasing.dbtest.Student;

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
	    .successHandler(new AuthenticationSuccessHandler()
	    		{
			
			public void onAuthenticationSuccess(jakarta.servlet.http.HttpServletRequest request,
					jakarta.servlet.http.HttpServletResponse response, Authentication authentication)
					throws IOException, jakarta.servlet.ServletException {
				System.out.println("AuthenticationSuccessHandler invoked");
				System.out.println("Authentication name: " + authentication.getName());
				//Principal p=(Principal) authentication.getPrincipal();
				 OAuth2AuthenticatedPrincipal principal=(OAuth2AuthenticatedPrincipal) authentication.getPrincipal();
				try {
					//CustomOAuth2User oauthUser = (CustomOAuth2User) authentication.getPrincipal();
					System.out.println("principal>>>"+principal.getAttribute("name"));
					System.out.println("principal>>>"+principal.getAttribute("family_name"));
					System.out.println("principal>>>"+principal.getAttribute("email"));
					System.out.println("principal>>>"+principal.getAttribute("picture"));
					System.out.println("principal>>>"+principal.getAttribute("email_verified"));
							         					
				} catch (Exception e) {
					e.printStackTrace();
				}
								
				//userService.processOAuthPostLogin(principal);
			    response.sendRedirect("/dynamic/api/profile");
			}
	    	
	    		})
	    .and()
		.logout().logoutSuccessUrl("/").permitAll()
		.and()
		.exceptionHandling().accessDeniedPage("/403")
		;
        
    

    System.out.println("calling SecurityConfig...AMIT LAHA1");
    return http.build();
    }
}
