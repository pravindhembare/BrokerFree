package com.example.BrokerFree.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import com.example.BrokerFree.Security.JwtAuthenticationEntryPoint;
import com.example.BrokerFree.Security.JwtAuthenticationFilter;
import com.example.BrokerFree.Service.AdminService;
import com.example.BrokerFree.Service.CustomUserDetailsService;
import com.example.BrokerFree.Controller.AppConfig;

@Configuration
public class SecurityConfig {


    @Autowired
    private JwtAuthenticationEntryPoint point;
    
    @Autowired
    private JwtAuthenticationFilter filter;
     
    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.csrf(csrf -> csrf.disable())
        		.cors(cors-> cors.disable()).authorizeHttpRequests(auth ->auth.requestMatchers("/home/**").authenticated()
        				.requestMatchers("/auth/login").permitAll()
        				.requestMatchers("/auth/create-admin").permitAll()
        				.requestMatchers("/registerTenant").permitAll()
        				.requestMatchers("/loginTenant").permitAll()
        				.requestMatchers("/registerOwner").permitAll()
        				.requestMatchers("/loginOwner").permitAll()
        				.requestMatchers("/admin/listOwners").permitAll()
        				.requestMatchers("/admin/listTenants").permitAll()
        				.requestMatchers("/admin/demolist").permitAll()
        				.requestMatchers("/addProperty").permitAll()
        				.requestMatchers("/viewProperty").permitAll()
        				.requestMatchers("/PassFogTenant").permitAll()
        				.requestMatchers("/PassFogOwner").permitAll()
        				.requestMatchers("/admin/PassFogAdmin").permitAll()
        				.requestMatchers("/addProperties").permitAll()
        				.requestMatchers("/findProperties/{id}").permitAll()
        				.requestMatchers("/deleteProperties/{id}").permitAll()
        				.requestMatchers("/getAllProperties").permitAll()
        				.requestMatchers("/getOwnerByProperties/{id}").permitAll()
        				.requestMatchers("/getPropertiesByOwnerEmail/{email}").permitAll()
        				.requestMatchers("/admin/deleteOwner/{ownerId}").permitAll()
        				.anyRequest().authenticated())
                .exceptionHandling(ex->ex.authenticationEntryPoint(point))  
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
        ;
        
        http.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }
    
    @Bean
    public DaoAuthenticationProvider doDaoAuthenticationProvider() {
    	DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
    	daoAuthenticationProvider.setUserDetailsService(customUserDetailsService);
    	daoAuthenticationProvider.setPasswordEncoder(passwordEncoder);
    	return daoAuthenticationProvider;
    }


}