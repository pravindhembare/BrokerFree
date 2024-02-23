package com.example.BrokerFree.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.BrokerFree.Model.Admin;
import com.example.BrokerFree.Model.Tenant;
import com.example.BrokerFree.Model.Owner;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private AdminService adminService;

    @Autowired
    private TenantService tenantService;
    
    @Autowired
    private OwnerService ownerService;
    
    private String userType;
 

	@Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Check if the username belongs to an admin or a tenant
        UserDetails userDetails = null;
        System.out.println("inside custome user details");
        // Check if it's an admin
        Admin admin = adminService.fetchByEmail(username);
        System.out.println(admin);
        if (admin != null) {
            userDetails = admin;
            userType ="admin";
        } else {
            // Check if it's a tenant
            Tenant tenant = tenantService.fetchByEmail(username);
            if (tenant != null) {
                userDetails = tenant;
                userType = "tenant";
            }else {
            	Owner owner = ownerService.fetchByEmail(username);
            	if(owner !=null) {
            		userDetails = owner;
            		userType = "owner";
            	}
            }
        }

        if (userDetails == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }

        return userDetails;
    }
	
	 public String getUserType() {
			return userType;
		}
}
