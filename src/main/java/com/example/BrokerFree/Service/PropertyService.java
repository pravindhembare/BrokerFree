package com.example.BrokerFree.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.example.BrokerFree.Model.Property;
import com.example.BrokerFree.Repository.IPropertyRepository;


@Service
@Transactional
public class PropertyService {

	@Autowired
	private IPropertyRepository pRepo;
	public Property addProperty(Property p) {
		
		return pRepo.save(p);
	}
	public List<Property> getAllProperty() {
		// TODO Auto-generated method stub
		return pRepo.findAll();
	}
	
	 public void deleteProperty(Integer pid)
	    {
			pRepo.deleteById(pid);
	    }
	 
	
		public Property updatePropertyDetails(Property p) {
			// check if Owner exists
						Optional<Property> optional =  pRepo.findById(p.findById());
						if (optional.isPresent())
							return pRepo.save(p); // update
						return p;
						
			
		}
	
	
	 
}
