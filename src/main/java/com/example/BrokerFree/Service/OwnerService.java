package com.example.BrokerFree.Service;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.BrokerFree.Model.Owner;
import com.example.BrokerFree.Model.Tenant;
import com.example.BrokerFree.Model.Admin;
import com.example.BrokerFree.Repository.IAdminRepository;
import com.example.BrokerFree.Repository.IOwnerRepository;
import com.example.BrokerFree.Repository.ITenantRepository;

@Service
@Transactional

public class OwnerService {
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private IOwnerRepository repo;
	
	@Autowired
	private IAdminRepository repo1;
	
	@Autowired
	private ITenantRepository repo2;
	

	public ResponseEntity<?> registerOwner(Owner owner) {
		// Check if the email already exists in the database
		Owner existingOwner = repo.findByOemail(owner.getOemail());
		if (existingOwner != null) {
			return new ResponseEntity<>("Email is already taken", HttpStatus.CONFLICT);
		}
		 Tenant existingTenant = repo2.findByTemail(owner.getOemail());
	        if (existingTenant != null) {
	            return new ResponseEntity<>("Email is already taken", HttpStatus.CONFLICT);
	        }
		Admin existingAdmin = repo1.findByEmail(owner.getOemail());
		if (existingAdmin != null) {
			return new ResponseEntity<>("Email is already taken", HttpStatus.CONFLICT);
		}
		
		
		// If email is not taken, proceed with saving the record
		owner.setOpassword(passwordEncoder.encode(owner.getPassword()));
		Owner savedOwner = repo.save(owner);
		return new ResponseEntity<>(savedOwner, HttpStatus.OK);
	}
	
	
	 public ResponseEntity<?> forgotPassword(String email, String recoveryQuestion, String recoveryAnswer, String newPassword) {
	        Owner owner = repo.findByOemail(email);
	        
	        if (owner == null || !owner.getOpassreq().equals(recoveryQuestion) || !owner.getOpassans().equals(recoveryAnswer)) {            
	            return new ResponseEntity<>("Invalid credentials", HttpStatus.CONFLICT);
	        }
	        owner.setOpassword(passwordEncoder.encode(newPassword));
	        repo.save(owner);
	        return new ResponseEntity<>(owner, HttpStatus.OK);
	    }

	public Owner fetchByEmail(String email) {
		return repo.findByOemail(email);
	}

	public Owner fetchOwnerByEmailAndPassword(String oemail, String opassword) {
		return repo.findByOemailAndOpassword(oemail, opassword);
	}

	public List<Owner> getAllOwners() {
		System.out.println(" Owner service impl class..." + repo.getClass().getName());
		return repo.findAll();
	}

	public ResponseEntity<?> deleteOwnerDetails(int ownerId) {		
		Optional<Owner> optional = repo.findById(ownerId);
		if (optional.isPresent())
			 repo.deleteById(ownerId); 
			return new ResponseEntity<>( HttpStatus.OK);
	}
}
