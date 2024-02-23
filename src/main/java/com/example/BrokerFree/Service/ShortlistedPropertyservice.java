/*package com.example.BrokerFree.Service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.BrokerFree.Model.Owner;
import com.example.BrokerFree.Model.Property;
import com.example.BrokerFree.Model.ShortlistedProperty;
import com.example.BrokerFree.Model.Tenant;
import com.example.BrokerFree.Repository.IOwnerRepository;
import com.example.BrokerFree.Repository.IPropertyRepository;
import com.example.BrokerFree.Repository.IShortlistedPropertyRepository;
import com.example.BrokerFree.Repository.ITenantRepository;

@Service
@Transactional
public class ShortlistedPropertyservice  {
	
	
	@Autowired
	private IShortlistedPropertyRepository iRepo;
	@Autowired
	private IOwnerRepository oRepo;
	@Autowired
	private ITenantRepository tRepo;
	@Autowired
	private IPropertyRepository pRepo;
    public ShortlistedProperty addShortlistedProperty(ShortlistedProperty sp) {
		System.out.println("inserted");
		return iRepo.save(sp);
	}	

}
*/