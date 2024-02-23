package com.example.BrokerFree.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.BrokerFree.Model.Owner;
import com.example.BrokerFree.Model.PropertyBasicDetails;
import com.example.BrokerFree.Model.PropertyLocationDetails;
import com.example.BrokerFree.Model.PropertyPhotos;
import com.example.BrokerFree.Model.PropertyPricingDetails;
import com.example.BrokerFree.Model.PropertyProfileDetails;
import com.example.BrokerFree.Model.PropertyRequest;
import com.example.BrokerFree.Repository.IOwnerRepository;
import com.example.BrokerFree.Repository.PropertyBasicDetailsRepository;
import com.example.BrokerFree.Repository.PropertyLocationDetailsRepository;
import com.example.BrokerFree.Repository.PropertyPhotosRepository;
import com.example.BrokerFree.Repository.PropertyPricingDetailsRepository;
import com.example.BrokerFree.Repository.PropertyProfileDetailsRepository;

@Service
public class PropertyService1 {
	
	@Autowired
	private IOwnerRepository ownerRepository;

	@Autowired
	private PropertyBasicDetailsRepository basicDetailsRepository;

	@Autowired
	private PropertyLocationDetailsRepository locationDetailsRepository;
	
	@Autowired
	private PropertyProfileDetailsRepository profileDetailsRepository;
	
	@Autowired
	private PropertyPricingDetailsRepository pricingDetailsRepository;
	
	@Autowired
	private PropertyPhotosRepository photosRepository;
	@Autowired
	private PropertyRequest request;

	public ResponseEntity<?> addProperty(PropertyRequest propertyRequest) {
		PropertyBasicDetails basicDetails = new PropertyBasicDetails();		
		basicDetails.setSubType(propertyRequest.getSubType());
		basicDetails.setSpecification(propertyRequest.getSpecification());
		basicDetails.setType(propertyRequest.getType());
		Owner existingOwner = ownerRepository.findByOemail(propertyRequest.getOemail());
		if (existingOwner != null) {
			basicDetails.setOwner(existingOwner);
		}

		PropertyLocationDetails locationDetails = new PropertyLocationDetails();
		locationDetails.setCity(propertyRequest.getCity());
		locationDetails.setLocality(propertyRequest.getLocality());
		locationDetails.setPropertyName(propertyRequest.getPropertyName());
		locationDetails.setPropertyNo(propertyRequest.getPropertyNo());
		locationDetails.setSubLocality(propertyRequest.getSubLocality());		
		locationDetailsRepository.save(locationDetails);
				
	    
		PropertyProfileDetails profileDetails = new PropertyProfileDetails();		
		profileDetails.setBedrooms(propertyRequest.getBedrooms());
		profileDetails.setBathrooms(propertyRequest.getBathrooms());
		profileDetails.setBalconies(propertyRequest.getBalconies());
		profileDetails.setCarpetArea(propertyRequest.getCarpetArea());
		profileDetails.setAreaType(propertyRequest.getAreaType());
		profileDetails.setOtherRooms(propertyRequest.getOtherRooms());
		profileDetails.setFurnishing(propertyRequest.getFurnishing());
		profileDetails.setTotalFloors(propertyRequest.getTotalFloors());
		profileDetails.setPropertyFloor(propertyRequest.getPropertyFloor());
		profileDetails.setPropertyAge(propertyRequest.getPropertyAge());
		profileDetails.setAvailabilityDate(propertyRequest.getAvailabilityDate());
		profileDetails.setWillingType(propertyRequest.getWillingType());
		profileDetails.setParking(propertyRequest.getParking());
		profileDetailsRepository.save(profileDetails);
    
		PropertyPricingDetails pricingDetails = new PropertyPricingDetails();		
		pricingDetails.setExpectedRent(propertyRequest.getExpectedRent());
		pricingDetails.setExpecteddeposit(propertyRequest.getExpecteddeposit());
		pricingDetails.setExtraCharge(propertyRequest.getExtraCharge());
		pricingDetails.setPriceNegotiable(propertyRequest.getPriceNegotiable());
		pricingDetails.setAgreementDuration(propertyRequest.getAgreementDuration());
		pricingDetails.setNoticeTime(propertyRequest.getNoticeTime());
		pricingDetails.setAdditionalDetails(propertyRequest.getAdditionalDetails());
		pricingDetailsRepository.save(pricingDetails);
		
		PropertyPhotos propertyPhotos = new PropertyPhotos();
		propertyPhotos.setId(propertyRequest.getPhotosid());
		propertyPhotos.setPhoto1(propertyRequest.getPhoto1());
		propertyPhotos.setPhoto2(propertyRequest.getPhoto2());
		photosRepository.save(propertyPhotos);
		
		basicDetails.setLocationDetails(locationDetails);
		basicDetails.setProfileDetails(profileDetails);
		basicDetails.setPricingDetails(pricingDetails);
		basicDetails.setPhotos(propertyPhotos);
		basicDetailsRepository.save(basicDetails);
		
		return new ResponseEntity<>(basicDetails, HttpStatus.OK);

	}

	public ResponseEntity<PropertyBasicDetails> getBasicDetailsById(Long id) {
		PropertyBasicDetails basicDetails = basicDetailsRepository.findById(id).orElse(null);
		if (basicDetails != null) {			
			request.setOemail(basicDetails.getOwner().getOemail());
			request.setBasicDetailsId(basicDetails.getId());
			request.setSubType(basicDetails.getSubType());
			request.setSpecification(basicDetails.getSpecification());
			request.setType(basicDetails.getType());
			
			request.setLocationDetailsId(basicDetails.getLocationDetails().getId());
			request.setCity(basicDetails.getLocationDetails().getCity());
			request.setLocality(basicDetails.getLocationDetails().getLocality());
			request.setPropertyName(basicDetails.getLocationDetails().getPropertyName());
			request.setPropertyNo(basicDetails.getLocationDetails().getPropertyNo());
			request.setSubLocality(basicDetails.getLocationDetails().getSubLocality());
			
			request.setProfileDetailsId(basicDetails.getProfileDetails().getId());
			request.setBedrooms(basicDetails.getProfileDetails().getBedrooms());
			request.setBathrooms(basicDetails.getProfileDetails().getBathrooms());			
			request.setBalconies(basicDetails.getProfileDetails().getBalconies());			
			request.setCarpetArea(basicDetails.getProfileDetails().getCarpetArea());
			request.setAreaType(basicDetails.getProfileDetails().getAreaType());
			request.setOtherRooms(basicDetails.getProfileDetails().getOtherRooms());
			request.setFurnishing(basicDetails.getProfileDetails().getFurnishing());
			request.setTotalFloors(basicDetails.getProfileDetails().getTotalFloors());
			request.setPropertyFloor(basicDetails.getProfileDetails().getPropertyFloor());
			request.setPropertyAge(basicDetails.getProfileDetails().getPropertyAge());
			request.setAvailabilityDate(basicDetails.getProfileDetails().getAvailabilityDate());
			request.setWillingType(basicDetails.getProfileDetails().getWillingType());
			request.setParking(basicDetails.getProfileDetails().getParking());
			
			request.setPricingDetailsId(basicDetails.getPricingDetails().getId());
			request.setExpectedRent(basicDetails.getPricingDetails().getExpectedRent());
			request.setExpecteddeposit(basicDetails.getPricingDetails().getExpecteddeposit());
			request.setExtraCharge(basicDetails.getPricingDetails().getExtraCharge());
			request.setPriceNegotiable(basicDetails.getPricingDetails().getPriceNegotiable());
			request.setAgreementDuration(basicDetails.getPricingDetails().getAgreementDuration());
			request.setNoticeTime(basicDetails.getPricingDetails().getNoticeTime());
			request.setAdditionalDetails(basicDetails.getPricingDetails().getAdditionalDetails());
			
			request.setPhotosid(basicDetails.getPhotos().getId());
			request.setPhoto1(basicDetails.getPhotos().getPhoto1());
			request.setPhoto2(basicDetails.getPhotos().getPhoto2());
								
			return ResponseEntity.ok(basicDetails);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	
	public ResponseEntity<List<PropertyRequest>> getAllProperties() {
	    List<PropertyBasicDetails> basicDetailsList = basicDetailsRepository.findAll();
	    
	    List<PropertyRequest> requestList = new ArrayList<>();

	    for (PropertyBasicDetails basicDetails : basicDetailsList) {
	        PropertyRequest request = new PropertyRequest();
	        request.setOemail(basicDetails.getOwner().getOemail());
			request.setBasicDetailsId(basicDetails.getId());
			request.setSubType(basicDetails.getSubType());
			request.setSpecification(basicDetails.getSpecification());
			request.setType(basicDetails.getType());
			
			request.setLocationDetailsId(basicDetails.getLocationDetails().getId());
			request.setCity(basicDetails.getLocationDetails().getCity());
			request.setLocality(basicDetails.getLocationDetails().getLocality());
			request.setPropertyName(basicDetails.getLocationDetails().getPropertyName());
			request.setPropertyNo(basicDetails.getLocationDetails().getPropertyNo());
			request.setSubLocality(basicDetails.getLocationDetails().getSubLocality());
			
			request.setProfileDetailsId(basicDetails.getProfileDetails().getId());
			request.setBedrooms(basicDetails.getProfileDetails().getBedrooms());
			request.setBathrooms(basicDetails.getProfileDetails().getBathrooms());			
			request.setBalconies(basicDetails.getProfileDetails().getBalconies());			
			request.setCarpetArea(basicDetails.getProfileDetails().getCarpetArea());
			request.setAreaType(basicDetails.getProfileDetails().getAreaType());
			request.setOtherRooms(basicDetails.getProfileDetails().getOtherRooms());
			request.setFurnishing(basicDetails.getProfileDetails().getFurnishing());
			request.setTotalFloors(basicDetails.getProfileDetails().getTotalFloors());
			request.setPropertyFloor(basicDetails.getProfileDetails().getPropertyFloor());
			request.setPropertyAge(basicDetails.getProfileDetails().getPropertyAge());
			request.setAvailabilityDate(basicDetails.getProfileDetails().getAvailabilityDate());
			request.setWillingType(basicDetails.getProfileDetails().getWillingType());
			request.setParking(basicDetails.getProfileDetails().getParking());
			
			request.setPricingDetailsId(basicDetails.getPricingDetails().getId());
			request.setExpectedRent(basicDetails.getPricingDetails().getExpectedRent());
			request.setExpecteddeposit(basicDetails.getPricingDetails().getExpecteddeposit());
			request.setExtraCharge(basicDetails.getPricingDetails().getExtraCharge());
			request.setPriceNegotiable(basicDetails.getPricingDetails().getPriceNegotiable());
			request.setAgreementDuration(basicDetails.getPricingDetails().getAgreementDuration());
			request.setNoticeTime(basicDetails.getPricingDetails().getNoticeTime());
			request.setAdditionalDetails(basicDetails.getPricingDetails().getAdditionalDetails());
			
			request.setPhotosid(basicDetails.getPhotos().getId());
			request.setPhoto1(basicDetails.getPhotos().getPhoto1());
			request.setPhoto2(basicDetails.getPhotos().getPhoto2());

	        requestList.add(request);
	    }

	    return ResponseEntity.ok(requestList);
	}
	
	public ResponseEntity<List<PropertyRequest>> getPropertiesByOwnerEmail(String email) {
		Owner existingOwner = ownerRepository.findByOemail(email);
		if (existingOwner != null) {
			List<PropertyBasicDetails> basicDetailsList = basicDetailsRepository.findByOwner(existingOwner);
			List<PropertyRequest> requestList = new ArrayList<>();

		    for (PropertyBasicDetails basicDetails : basicDetailsList) {
		        PropertyRequest request = new PropertyRequest();
		        request.setOemail(basicDetails.getOwner().getOemail());
				request.setBasicDetailsId(basicDetails.getId());
				request.setSubType(basicDetails.getSubType());
				request.setSpecification(basicDetails.getSpecification());
				request.setType(basicDetails.getType());
				
				request.setLocationDetailsId(basicDetails.getLocationDetails().getId());
				request.setCity(basicDetails.getLocationDetails().getCity());
				request.setLocality(basicDetails.getLocationDetails().getLocality());
				request.setPropertyName(basicDetails.getLocationDetails().getPropertyName());
				request.setPropertyNo(basicDetails.getLocationDetails().getPropertyNo());
				request.setSubLocality(basicDetails.getLocationDetails().getSubLocality());
		        
				request.setProfileDetailsId(basicDetails.getProfileDetails().getId());
				request.setBedrooms(basicDetails.getProfileDetails().getBedrooms());
				request.setBathrooms(basicDetails.getProfileDetails().getBathrooms());			
				request.setBalconies(basicDetails.getProfileDetails().getBalconies());			
				request.setCarpetArea(basicDetails.getProfileDetails().getCarpetArea());
				request.setAreaType(basicDetails.getProfileDetails().getAreaType());
				request.setOtherRooms(basicDetails.getProfileDetails().getOtherRooms());
				request.setFurnishing(basicDetails.getProfileDetails().getFurnishing());
				request.setTotalFloors(basicDetails.getProfileDetails().getTotalFloors());
				request.setPropertyFloor(basicDetails.getProfileDetails().getPropertyFloor());
				request.setPropertyAge(basicDetails.getProfileDetails().getPropertyAge());
				request.setAvailabilityDate(basicDetails.getProfileDetails().getAvailabilityDate());
				request.setWillingType(basicDetails.getProfileDetails().getWillingType());
				request.setParking(basicDetails.getProfileDetails().getParking());
				
				request.setPricingDetailsId(basicDetails.getPricingDetails().getId());
				request.setExpectedRent(basicDetails.getPricingDetails().getExpectedRent());
				request.setExpecteddeposit(basicDetails.getPricingDetails().getExpecteddeposit());
				request.setExtraCharge(basicDetails.getPricingDetails().getExtraCharge());
				request.setPriceNegotiable(basicDetails.getPricingDetails().getPriceNegotiable());
				request.setAgreementDuration(basicDetails.getPricingDetails().getAgreementDuration());
				request.setNoticeTime(basicDetails.getPricingDetails().getNoticeTime());
				request.setAdditionalDetails(basicDetails.getPricingDetails().getAdditionalDetails());
				
				request.setPhotosid(basicDetails.getPhotos().getId());
				request.setPhoto1(basicDetails.getPhotos().getPhoto1());
				request.setPhoto2(basicDetails.getPhotos().getPhoto2());

		        requestList.add(request);
		    }
		    return ResponseEntity.ok(requestList);
		}	
		return null;
	}

	
	public ResponseEntity<?>  deletePropertyById(Long id) {
		
		basicDetailsRepository.deleteById(id);
		return new ResponseEntity<>("Owner Delete Successfully ",HttpStatus.OK);
    }

	public ResponseEntity<?> getOwnerByPropertiesId(Long id) {
	    PropertyBasicDetails basicDetails = basicDetailsRepository.findById(id).orElse(null);
	    if (basicDetails == null) {
	        return ResponseEntity.notFound().build();
	    }
	    Owner owner = basicDetails.getOwner();
	    Owner newOwner = new Owner();
	    newOwner.setOid(owner.getOid());
	    newOwner.setOname(owner.getOname());
	    newOwner.setOemail(owner.getOemail());
	    newOwner.setOcontact(owner.getOcontact());
	    newOwner.setOaddress(owner.getOaddress());
	    return ResponseEntity.ok(newOwner);
	}
}
