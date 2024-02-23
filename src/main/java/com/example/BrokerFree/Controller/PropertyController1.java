package com.example.BrokerFree.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.BrokerFree.Model.PropertyBasicDetails;
import com.example.BrokerFree.Model.PropertyLocationDetails;
import com.example.BrokerFree.Model.PropertyRequest;
import com.example.BrokerFree.Service.PropertyService1;

@RestController
public class PropertyController1 {

	@Autowired
	private PropertyService1 propertyService;
	
	@Autowired
	private PropertyRequest request;

    @PostMapping("/addProperties")
    public ResponseEntity<?> properties (@RequestBody PropertyRequest propertyRequest) {
    	return propertyService.addProperty(propertyRequest);    	
    }
    
    @DeleteMapping("/deleteProperties/{id}")
    public ResponseEntity<?> deletePropertyById(@PathVariable Long id) {
       return propertyService.deletePropertyById(id);       
    }
    
    @GetMapping("/getAllProperties")
    public ResponseEntity<?> getAllProperties() {
        return propertyService.getAllProperties();
    }
    
    @GetMapping("/getPropertiesByOwnerEmail/{email}")
    public ResponseEntity<?> getPropertiesByOwner(@PathVariable String email) {
        return propertyService.getPropertiesByOwnerEmail(email);
    }
    
    @GetMapping("/getOwnerByProperties/{id}")
    public ResponseEntity<?> getOwnerByProperties(@PathVariable Long id) {
        return propertyService.getOwnerByPropertiesId(id);
    }
    
    @GetMapping("/findProperties/{id}")
    public ResponseEntity<?> getProperty(@PathVariable Long id) {
        ResponseEntity<PropertyBasicDetails> basicDetailsResponse = propertyService.getBasicDetailsById(id);        

        if (basicDetailsResponse.getStatusCode().is2xxSuccessful()) {        	
        	return ResponseEntity.ok().body(request);
        } else {           
            return ResponseEntity.status(500).body("Error retrieving property details");
        }
    }
}
