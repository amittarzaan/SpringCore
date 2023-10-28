package com.alibou.oauth2.landleasing.login.security;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Base64;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.OAuth2AuthenticatedPrincipal;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

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
				String encodedString=null;
				String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
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
					encodedString = Base64.getEncoder().encodeToString(principal.
							getAttribute("email")
							.toString()
							.concat(","+timeStamp)
							.getBytes());
					System.out.println("Encoding >>>"+encodedString);
					response.sendRedirect("/dynamic/api/profile/"+encodedString);
							         					
				} catch (Exception e) {
					e.printStackTrace();
					response.sendRedirect("/dynamic/api/profile/");
				}
								
				//userService.processOAuthPostLogin(principal);
				
			    
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
