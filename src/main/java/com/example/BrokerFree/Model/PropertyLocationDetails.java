package com.example.BrokerFree.Model;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "property_location_details")
public class PropertyLocationDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="city")
    private String city;

    @Column(name="locality")
    private String locality;

    @Column(name="subLocality")
    private String subLocality;

    @Column(name="propertyName")
    private String propertyName;

    @Column(name="propertyNo")
    private String propertyNo;    


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getSubLocality() {
		return subLocality;
	}

	public void setSubLocality(String subLocality) {
		this.subLocality = subLocality;
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

//	public PropertyBasicDetails getPropertyBasicDetails() {
//		return propertyBasicDetails;
//	}
//
//	public void setPropertyBasicDetails(PropertyBasicDetails propertyBasicDetails) {
//		this.propertyBasicDetails = propertyBasicDetails;
//	}

	@Override
	public String toString() {
		return "PropertyLocationDetails [id=" + id + ", city=" + city + ", locality=" + locality + ", subLocality="
				+ subLocality + ", propertyName=" + propertyName + ", propertyNo=" + propertyNo +"]";
	}

	public PropertyLocationDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PropertyLocationDetails(Long id, String city, String locality, String subLocality, String propertyName,
			String propertyNo, PropertyBasicDetails propertyBasicDetails) {
		super();
		this.id = id;
		this.city = city;
		this.locality = locality;
		this.subLocality = subLocality;
		this.propertyName = propertyName;
		this.propertyNo = propertyNo;
		//this.propertyBasicDetails = propertyBasicDetails;
	}
    
    
   
}
