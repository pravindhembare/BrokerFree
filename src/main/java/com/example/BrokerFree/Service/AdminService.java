package com.example.BrokerFree.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.BrokerFree.Model.Admin;
import com.example.BrokerFree.Model.Tenant;
import com.example.BrokerFree.Repository.IAdminRepository;

@Service
public class AdminService {
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private IAdminRepository repo;	
		
	
	
	public Admin fetchAdminByEmailAndPassword(String email,String password)
	{
		
		return repo.findByEmailAndPassword(email,password);
	}
	
	
	
	public Admin fetchByEmail(String email) {
		return repo.findByEmail(email);
	}


	
	public Admin createAdmin(Admin admin) {
		admin.setPassword(passwordEncoder.encode(admin.getPassword()));
		return repo.save(admin);
	}
	
	
	 public ResponseEntity<?> forgotPassword(String email, String akey, String newPassword) {
	        Admin admin = repo.findByEmail(email);
	        System.out.println(newPassword);
	        if (admin == null || !admin.getAkey().equals(akey)) {            
	            return new ResponseEntity<>("Invalid credentials", HttpStatus.CONFLICT);
	        }
	        admin.setPassword(passwordEncoder.encode(newPassword));
	        repo.save(admin);
	        return new ResponseEntity<>(admin, HttpStatus.OK);
	    }
}
