package com.example.BrokerFree.Model;
//
//import java.util.List;
//import lombok.*;
//
//@Data
//public class PropertyRequest {
//    private PropertyBasicDetails basicDetails;
//    private PropertyLocationDetails locationDetails;
//    private PropertyProfileDetails profileDetails;
//    private PropertyPricingDetails pricingDetails;
//    private List<PropertyPhotos> photos;
//	public PropertyBasicDetails getBasicDetails() {
//		return basicDetails;
//	}
//	public void setBasicDetails(PropertyBasicDetails basicDetails) {
//		this.basicDetails = basicDetails;
//	}
//	public PropertyLocationDetails getLocationDetails() {
//		return locationDetails;
//	}
//	public void setLocationDetails(PropertyLocationDetails locationDetails) {
//		this.locationDetails = locationDetails;
//	}
//	public PropertyProfileDetails getProfileDetails() {
//		return profileDetails;
//	}
//	public void setProfileDetails(PropertyProfileDetails profileDetails) {
//		this.profileDetails = profileDetails;
//	}
//	public PropertyPricingDetails getPricingDetails() {
//		return pricingDetails;
//	}
//	public void setPricingDetails(PropertyPricingDetails pricingDetails) {
//		this.pricingDetails = pricingDetails;
//	}
//	public List<PropertyPhotos> getPhotos() {
//		return photos;
//	}
//	public void setPhotos(List<PropertyPhotos> photos) {
//		this.photos = photos;
//	}
//	@Override
//	public String toString() {
//		return "PropertyRequest [basicDetails=" + basicDetails + ", locationDetails=" + locationDetails
//				+ ", profileDetails=" + profileDetails + ", pricingDetails=" + pricingDetails + ", photos=" + photos
//				+ "]";
//	}
//	public PropertyRequest() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
//	public PropertyRequest(PropertyBasicDetails basicDetails, PropertyLocationDetails locationDetails,
//			PropertyProfileDetails profileDetails, PropertyPricingDetails pricingDetails, List<PropertyPhotos> photos) {
//		super();
//		this.basicDetails = basicDetails;
//		this.locationDetails = locationDetails;
//		this.profileDetails = profileDetails;
//		this.pricingDetails = pricingDetails;
//		this.photos = photos;
//	}
//	public Object bgetId() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//    
//    
//}

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;


@Component
public class PropertyRequest {
	private String oemail;	
	
    private Long basicDetailsId;
    private String subType;
    private String specification;
    private String type;
    
    private Long locationDetailsId;
    private String city;
    private String locality;
    private String propertyName;
    private String propertyNo;
    private String subLocality;
    
  
    private Long profileDetailsId;
    private int bedrooms;
    private int bathrooms;
    private int balconies;
    private int carpetArea;
    private String areaType;
    private String otherRooms;
    private String furnishing;
    private int totalFloors;
    private String propertyFloor;
    private String propertyAge;
    private String availabilityDate;
    private String willingType;
    private String parking;

    
    private Long pricingDetailsId;
    private double expectedRent;
    private double expecteddeposit;
    private String extraCharge;
    private String priceNegotiable;
    private String agreementDuration;
    private String noticeTime;
    private String additionalDetails;
    
    
    private Long photosid;
    private String photo1;
    private String photo2;
    
    public PropertyRequest() {}


	public PropertyRequest(String oemail, Long basicDetailsId, String subType, String specification, String type,
			Long locationDetailsId, String city, String locality, String propertyName, String propertyNo,
			String subLocality, Long profileDetailsId, int bedrooms, int bathrooms, int balconies, int carpetArea,
			String areaType, String otherRooms, String furnishing, int totalFloors, String propertyFloor,
			String propertyAge, String availabilityDate, String willingType, String parking, Long pricingDetailsId,
			double expectedRent, double expecteddeposit, String extraCharge, String priceNegotiable,
			String agreementDuration, String noticeTime, String additionalDetails,Long photosid,String photo1,String photo2 ) {
		super();
		this.oemail = oemail;
		this.basicDetailsId = basicDetailsId;
		this.subType = subType;
		this.specification = specification;
		this.type = type;
		this.locationDetailsId = locationDetailsId;
		this.city = city;
		this.locality = locality;
		this.propertyName = propertyName;
		this.propertyNo = propertyNo;
		this.subLocality = subLocality;
		this.profileDetailsId = profileDetailsId;
		this.bedrooms = bedrooms;
		this.bathrooms = bathrooms;
		this.balconies = balconies;
		this.carpetArea = carpetArea;
		this.areaType = areaType;
		this.otherRooms = otherRooms;
		this.furnishing = furnishing;
		this.totalFloors = totalFloors;
		this.propertyFloor = propertyFloor;
		this.propertyAge = propertyAge;
		this.availabilityDate = availabilityDate;
		this.willingType = willingType;
		this.parking = parking;
		this.pricingDetailsId = pricingDetailsId;
		this.expectedRent = expectedRent;
		this.expecteddeposit = expecteddeposit;
		this.extraCharge = extraCharge;
		this.priceNegotiable = priceNegotiable;
		this.agreementDuration = agreementDuration;
		this.noticeTime = noticeTime;
		this.additionalDetails = additionalDetails;
		this.photosid=photosid;
		this.photo1=photo1;
		this.photo2=photo2;
	}


	public String getOemail() {
		return oemail;
	}

	public void setOemail(String oemail) {
		this.oemail = oemail;
	}
	
	public Long getBasicDetailsId() {
        return basicDetailsId;
    }

    public void setBasicDetailsId(Long basicDetailsId) {
        this.basicDetailsId = basicDetailsId;
    }

    public String getSubType() {
        return subType;
    }

    public void setSubType(String subType) {
        this.subType = subType;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getLocationDetailsId() {
        return locationDetailsId;
    }

    public void setLocationDetailsId(Long locationDetailsId) {
        this.locationDetailsId = locationDetailsId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public String getPropertyNo() {
        return propertyNo;
    }

    public void setPropertyNo(String propertyNo) {
        this.propertyNo = propertyNo;
    }

    public String getSubLocality() {
        return subLocality;
    }

    public void setSubLocality(String subLocality) {
        this.subLocality = subLocality;
    }


	public Long getProfileDetailsId() {
		return profileDetailsId;
	}


	public void setProfileDetailsId(Long profileDetailsId) {
		this.profileDetailsId = profileDetailsId;
	}


	public int getBedrooms() {
		return bedrooms;
	}


	public void setBedrooms(int bedrooms) {
		this.bedrooms = bedrooms;
	}


	public int getBathrooms() {
		return bathrooms;
	}


	public void setBathrooms(int bathrooms) {
		this.bathrooms = bathrooms;
	}


	public int getBalconies() {
		return balconies;
	}


	public void setBalconies(int balconies) {
		this.balconies = balconies;
	}


	public int getCarpetArea() {
		return carpetArea;
	}


	public void setCarpetArea(int carpetArea) {
		this.carpetArea = carpetArea;
	}


	public String getAreaType() {
		return areaType;
	}


	public void setAreaType(String areaType) {
		this.areaType = areaType;
	}


	public String getOtherRooms() {
		return otherRooms;
	}


	public void setOtherRooms(String otherRooms) {
		this.otherRooms = otherRooms;
	}


	public String getFurnishing() {
		return furnishing;
	}


	public void setFurnishing(String furnishing) {
		this.furnishing = furnishing;
	}


	public int getTotalFloors() {
		return totalFloors;
	}


	public void setTotalFloors(int totalFloors) {
		this.totalFloors = totalFloors;
	}


	public String getPropertyFloor() {
		return propertyFloor;
	}


	public void setPropertyFloor(String propertyFloor) {
		this.propertyFloor = propertyFloor;
	}


	public String getPropertyAge() {
		return propertyAge;
	}


	public void setPropertyAge(String propertyAge) {
		this.propertyAge = propertyAge;
	}


	public String getAvailabilityDate() {
		return availabilityDate;
	}


	public void setAvailabilityDate(String availabilityDate) {
		this.availabilityDate = availabilityDate;
	}


	public String getWillingType() {
		return willingType;
	}


	public void setWillingType(String willingType) {
		this.willingType = willingType;
	}


	public String getParking() {
		return parking;
	}


	public void setParking(String parking) {
		this.parking = parking;
	}


	public Long getPricingDetailsId() {
		return pricingDetailsId;
	}


	public void setPricingDetailsId(Long pricingDetailsId) {
		this.pricingDetailsId = pricingDetailsId;
	}


	public double getExpectedRent() {
		return expectedRent;
	}


	public void setExpectedRent(double expectedRent) {
		this.expectedRent = expectedRent;
	}


	public double getExpecteddeposit() {
		return expecteddeposit;
	}


	public void setExpecteddeposit(double expecteddeposit) {
		this.expecteddeposit = expecteddeposit;
	}


	public String getExtraCharge() {
		return extraCharge;
	}


	public void setExtraCharge(String extraCharge) {
		this.extraCharge = extraCharge;
	}


	public String getPriceNegotiable() {
		return priceNegotiable;
	}


	public void setPriceNegotiable(String priceNegotiable) {
		this.priceNegotiable = priceNegotiable;
	}


	public String getAgreementDuration() {
		return agreementDuration;
	}


	public void setAgreementDuration(String agreementDuration) {
		this.agreementDuration = agreementDuration;
	}


	public String getNoticeTime() {
		return noticeTime;
	}


	public void setNoticeTime(String noticeTime) {
		this.noticeTime = noticeTime;
	}


	public String getAdditionalDetails() {
		return additionalDetails;
	}


	public void setAdditionalDetails(String additionalDetails) {
		this.additionalDetails = additionalDetails;
	}


	public Long getPhotosid() {
		return photosid;
	}


	public void setPhotosid(Long photosid) {
		this.photosid = photosid;
	}


	public String getPhoto1() {
		return photo1;
	}


	public void setPhoto1(String photo1) {
		this.photo1 = photo1;
	}


	public String getPhoto2() {
		return photo2;
	}


	public void setPhoto2(String photo2) {
		this.photo2 = photo2;
	}
    
    

}

