package com.example.BrokerFree.Controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


import com.example.BrokerFree.Model.Property;
import com.example.BrokerFree.Repository.IPropertyRepository;
import com.example.BrokerFree.Service.PropertyService;


@RestController
public class PropertyController {
	
	private byte[] bytes;

	@Autowired
	private PropertyService pService;
	private IPropertyRepository iRepo;
	
	@PostMapping("/uploadImages")
	public void uploadImage(@RequestParam("imageFile") MultipartFile file) throws IOException {
		this.bytes = file.getBytes();
	}
	
	@CrossOrigin(origins="http://localhost:4200")
	@PostMapping("/addProperty")
	public ResponseEntity<?> m2(@RequestBody Property p) {
		System.out.println("inside add property");
		pService.addProperty(p);
		//p.setPicByte1(this.bytes);
		return new ResponseEntity<Property>(p, HttpStatus.OK);
	}
	
	
	  @CrossOrigin(origins="http://localhost:4200")
		@GetMapping("/viewProperty")
		public ResponseEntity<?> viewProperties()
		{
			System.out.println("in list all properties");
		     List<Property> properties=pService.getAllProperty();
		     if(properties.isEmpty())
		    	 return new ResponseEntity<> (HttpStatus.NO_CONTENT);
		
		    return new ResponseEntity<>(properties,HttpStatus.OK);
		}
	  
	  
	    @CrossOrigin(origins="http://localhost:4200")
		@DeleteMapping("/deleteProperty/{pid}")
	   
	    public void deletePropertyById(@PathVariable Integer pid)
	    {
	    	pService.deleteProperty(pid);
	    	
	    }
		@CrossOrigin(origins="http://localhost:4200")
		 @PutMapping("/updateProperty/{pid}")
		  public ResponseEntity<Property> updatePropertyDetails(@PathVariable Integer pid, @RequestBody Property p) {
			  Optional<Property> propertyData = iRepo.findById(pid);

			    if (propertyData.isPresent()) {
			    	
					/*
					 * Property p1 = propertyData.get(); p1.setArea(p.getArea());
					 * p1.setBuildname(p.getBuildname()); p1.setDeposit(p.getDeposit());
					 * p1.setPdparking(p.getPdparking()); p1.setPdtype(p.getPdtype());
					 * p1.setPrent(p.getPrent());
					 */
			    return new ResponseEntity<>(iRepo.save(p), HttpStatus.OK);
			    
			    } else {
			      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			    }
			     
			      
			  }

		
				
}

		  
		
		
