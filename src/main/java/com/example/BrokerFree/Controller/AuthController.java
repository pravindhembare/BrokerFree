package com.example.BrokerFree.Controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.BrokerFree.Model.Admin;
import com.example.BrokerFree.Model.JwtRequest;
import com.example.BrokerFree.Model.JwtResponse;
import com.example.BrokerFree.Model.Owner;
import com.example.BrokerFree.Model.PropertyRequest;
import com.example.BrokerFree.Security.JwtHelper;
import com.example.BrokerFree.Service.AdminService;
import com.example.BrokerFree.Service.CustomUserDetailsService;
import com.example.BrokerFree.Service.OwnerService;
import com.example.BrokerFree.Service.PropertyService1;
import com.example.BrokerFree.Service.TenantService;

import org.springframework.security.core.AuthenticationException;

@RestController
@RequestMapping("/auth")
public class AuthController {
	
	@Autowired
	private OwnerService oService;

    @Autowired
    private UserDetailsService userDetailsService;
    
    @Autowired
    private AdminService adminService;
    
    @Autowired
    private TenantService tenantService;  
    
    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Autowired
    private AuthenticationManager manager;


    @Autowired
    private JwtHelper helper;
        

    private Logger logger = LoggerFactory.getLogger(AuthController.class);


    @CrossOrigin(origins="http://localhost:4200")
    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(@RequestBody JwtRequest request) {
        try {
            doAuthenticate(request.getEmail(), request.getPassword());
            UserDetails userDetails = customUserDetailsService.loadUserByUsername(request.getEmail());
            String token = this.helper.generateToken(userDetails);        
            JwtResponse response = JwtResponse.builder()
                    .jwtToken(token)
                    .username(userDetails.getUsername())
                    .usertype(customUserDetailsService.getUserType()).build();            
            return new ResponseEntity<>(response,HttpStatus.OK);
        } catch (AuthenticationException e) {
            // Handle authentication failure
        	throw new BadCredentialsException(" Invalid Username or Password  !!");

        }
    }
    

    private void doAuthenticate(String email, String password) {
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(email, password);
        System.out.println(authentication);
        try {
            manager.authenticate(authentication);
        } catch (AuthenticationException e) {
            logger.error("Authentication failed for user {}", email, e);
            // Log the authentication failure
            throw e; // Rethrow the exception to propagate it to the caller if necessary
        }
    }

    
    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<?> exceptionHandler() {
    	return new ResponseEntity<>("Credentials Invalid !!", HttpStatus.CONFLICT);
    }
    
    
    @PostMapping("/create-admin")
    public Admin createAdmin(@RequestBody Admin admin) {
    	return adminService.createAdmin(admin); 
    }
        
    
}


