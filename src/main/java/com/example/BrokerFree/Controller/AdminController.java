package com.example.BrokerFree.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.example.BrokerFree.Model.Admin;
import com.example.BrokerFree.Model.Owner;
import com.example.BrokerFree.Model.Tenant;
import com.example.BrokerFree.Model.Property;
import com.example.BrokerFree.Service.AdminService;
import com.example.BrokerFree.Service.OwnerService;
import com.example.BrokerFree.Service.PropertyService;
import com.example.BrokerFree.Service.TenantService;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/admin", produces = "application/json")
public class AdminController {

	// dependency : service layer i/f
	@Autowired
	private OwnerService ownerService;

	@Autowired
	private TenantService tenantService;

	@Autowired
	private PropertyService propertyService;

	@Autowired
	private AdminService adminService;
	
	
	
	@PostMapping("/fetchadmin")
	public Admin getAdmin(@RequestBody Admin a) throws Exception {
		String tempEmail = a.getEmail();
		String tempPassword = a.getPassword();

		Admin admin = null;
		if (tempEmail != null && tempPassword != null) {
			admin = adminService.fetchAdminByEmailAndPassword(tempEmail, tempPassword);
		}
		if (admin == null) {
			throw new Exception("Wrong credentials");
		}
		return admin;
	}

	 @CrossOrigin(origins = "http://localhost:4200")
	    @PostMapping("/PassFogAdmin")
	    public ResponseEntity<?> forgotPassword(@RequestBody Admin request) {
	        String email = request.getEmail();
	        String key = request.getAkey();	        
	        String password = request.getPassword();

	        return adminService.forgotPassword(email,key, password);
	    }	

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/listOwners", method = RequestMethod.GET)
	public ResponseEntity<?> listAllOwners() {
		System.out.println("in list all owners");
		List<Owner> owners = ownerService.getAllOwners();
		// check if list is empty
		if (owners.isEmpty())
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		// for non empty list
		return new ResponseEntity<>(owners, HttpStatus.OK);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/listTenants", method = RequestMethod.GET)
	public ResponseEntity<?> listAllTenants() {
		System.out.println("in list all tenants");
		List<Tenant> tenants = tenantService.getAllTenants();
		// check if list is empty
		if (tenants.isEmpty())
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		// for non empty list
		return new ResponseEntity<>(tenants, HttpStatus.OK);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/listProperties", method = RequestMethod.GET)
	public ResponseEntity<?> listAllProperties() {
		System.out.println("in list all properties");
		List<Property> properties = propertyService.getAllProperty();
		if (properties.isEmpty())
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);

		return new ResponseEntity<>(properties, HttpStatus.OK);
	}

	@GetMapping("/demolist")
	public ResponseEntity<?> demolist() {
		System.out.println("In list all owners");
		List<Owner> owners = ownerService.getAllOwners();

		return ResponseEntity.ok(owners);

	}


	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(method = RequestMethod.DELETE, value = "/deleteOwner/{ownerId}")
	public ResponseEntity<?> deleteOwnerDetails (@PathVariable int ownerId) {		
		try {
			ownerService.deleteOwnerDetails(ownerId);
			return new ResponseEntity<>("Owner Delete Successfully ",HttpStatus.OK);
		}

		catch (RuntimeException e) {
			System.out.println("error in controller " + e);
			return new ResponseEntity<>("Owner Not Deleted",HttpStatus.NO_CONTENT);
		}		
	}

}
