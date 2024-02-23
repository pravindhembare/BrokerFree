package com.example.BrokerFree.Model;

import lombok.*;
import jakarta.persistence.*;

@Data
@Entity
@Table(name = "property_basic_details")
public class PropertyBasicDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="type")
    private String type;

    @Column(name="subType")
    private String subType;

	@Column(name="specification")
    private String specification;
    
    @ManyToOne
	@JoinColumn(name = "oid")
	private Owner owner;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "property_location_id", nullable = false)
    private PropertyLocationDetails locationDetails;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "property_profile_id", nullable = false)
    private PropertyProfileDetails profileDetails;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "property_pricing_id", nullable = false)
    private PropertyPricingDetails pricingDetails;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "property_photos_id", nullable = false)
    private PropertyPhotos photos;

    public PropertyBasicDetails(Long id, String type, String subType, String specification, Owner owner, 
			PropertyLocationDetails locationDetails, PropertyProfileDetails profileDetails,
			PropertyPricingDetails pricingDetails, PropertyPhotos photos) {
		super();
		this.id = id;
		this.type = type;
		this.subType = subType;
		this.specification = specification;
		this.owner=owner;
//		this.locationDetails = locationDetails;
//		this.profileDetails = profileDetails;
//		this.pricingDetails = pricingDetails;
//		this.photos = photos;
	}

	public PropertyBasicDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "PropertyBasicDetails [id=" + id + ", type=" + type + ", subType=" + subType + ", specification="
				+ specification + ", owner="+ owner ;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}
	
	  public PropertyLocationDetails getLocationDetails() {
		  return locationDetails;
	}

		public void setLocationDetails(PropertyLocationDetails locationDetails) {
		this.locationDetails = locationDetails;
	}
	

	public PropertyProfileDetails getProfileDetails() {
		return profileDetails;
	}

	public void setProfileDetails(PropertyProfileDetails profileDetails) {
		this.profileDetails = profileDetails;
	}

	public PropertyPricingDetails getPricingDetails() {
		return pricingDetails;
	}

	public void setPricingDetails(PropertyPricingDetails pricingDetails) {
		this.pricingDetails = pricingDetails;
	}

	public PropertyPhotos getPhotos() {
		return photos;
	}

	public void setPhotos(PropertyPhotos photos) {
		this.photos = photos;
	}
	
    
}
