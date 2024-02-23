package com.example.BrokerFree.Model;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "property_profile_details")
public class PropertyProfileDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="bedrooms")
    private int bedrooms;

    @Column(name="bathrooms")
    private int bathrooms;

    @Column(name="balconies")
    private int balconies;

    @Column(name="carpetArea")
    private int carpetArea;

    @Column(name="areaType")
    private String areaType;

    @Column(name="otherRooms")
    private String otherRooms;

    @Column(name="furnishing")
    private String furnishing;

    @Column(name="totalFloors")
    private int totalFloors;

    @Column(name="propertyFloor")
    private String propertyFloor;

    @Column(name="propertyAge")
    private String propertyAge;

    @Column(name="availabilityDate")
    private String availabilityDate;

    @Column(name="willingType")
    private String willingType;

    @Column(name="parking")
    private String parking;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
	

	@Override
	public String toString() {
		return "PropertyProfileDetails [id=" + id + ", bedrooms=" + bedrooms + ", bathrooms=" + bathrooms
				+ ", balconies=" + balconies + ", carpetArea=" + carpetArea + ", areaType=" + areaType + ", otherRooms="
				+ otherRooms + ", furnishing=" + furnishing + ", totalFloors=" + totalFloors + ", propertyFloor="
				+ propertyFloor + ", propertyAge=" + propertyAge + ", availabilityDate=" + availabilityDate
				+ ", willingType=" + willingType + ", parking=" + parking  + "]";
	}

	public PropertyProfileDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PropertyProfileDetails(Long id, int bedrooms, int bathrooms, int balconies, int carpetArea, String areaType,
			String otherRooms, String furnishing, int totalFloors, String propertyFloor, String propertyAge,
			String availabilityDate, String willingType, String parking) {
		super();
		this.id = id;
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
	}
    
    
    
}
