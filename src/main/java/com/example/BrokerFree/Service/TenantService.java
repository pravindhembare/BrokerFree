package com.example.BrokerFree.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.BrokerFree.Model.Admin;
import com.example.BrokerFree.Model.Owner;
import com.example.BrokerFree.Model.Tenant;
import com.example.BrokerFree.Repository.IAdminRepository;
import com.example.BrokerFree.Repository.IOwnerRepository;
import com.example.BrokerFree.Repository.ITenantRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TenantService  {

    @Autowired
    private ITenantRepository repo;
    
    @Autowired
	private IOwnerRepository repo2;
	
	@Autowired
	private IAdminRepository repo1;
    
    @Autowired
	private PasswordEncoder passwordEncoder;

    public ResponseEntity<?> registerTenant(Tenant tenant) {
        // Check if the email already exists in the database
        Tenant existingTenant = repo.findByTemail(tenant.getTemail());
        if (existingTenant != null) {
            return new ResponseEntity<>("Email is already taken", HttpStatus.CONFLICT);
        }
        Owner existingOwner = repo2.findByOemail(tenant.getTemail());
		if (existingOwner != null) {
			return new ResponseEntity<>("Email is already taken", HttpStatus.CONFLICT);
		}
		Admin existingAdmin = repo1.findByEmail(tenant.getTemail());
		if (existingAdmin != null) {
			return new ResponseEntity<>("Email is already taken", HttpStatus.CONFLICT);
		}
		
        // If email is not taken, proceed with saving the record
        tenant.setTpassword(passwordEncoder.encode(tenant.getPassword()));
        repo.save(tenant);
        return new ResponseEntity<>(tenant, HttpStatus.OK);
    }

    
    
    
    public ResponseEntity<?> forgotPassword(String email, String recoveryQuestion, String recoveryAnswer, String newPassword) {
        Tenant tenant = repo.findByTemail(email);
        
        if (tenant == null || !tenant.getTpassreq().equals(recoveryQuestion) || !tenant.getTpassans().equals(recoveryAnswer)) {            
            return new ResponseEntity<>("Invalid credentials", HttpStatus.CONFLICT);
        }
        tenant.setTpassword(passwordEncoder.encode(newPassword));
        repo.save(tenant);
        return new ResponseEntity<>(tenant, HttpStatus.OK);
    }
    
    
    
    
    
    public Tenant fetchTenantByEmailAndPassword(String tempEmail, String tempPassword) {
        // TODO Auto-generated method stub
        return repo.findByTemailAndTpassword(tempEmail, tempPassword);
    }

    public List<Tenant> getAllTenants() {
        System.out.println(" Tenant service impl class..." + repo.getClass().getName());
        return repo.findAll();
    }
    
    public Tenant fetchByEmail(String temail) {
    	return repo.findByTemail(temail);
    }

}
