/*package com.example.BrokerFree.Model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table
public class ShortlistedProperty 
{
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY) 
    private Integer spid;
	
	
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name="property_id")
	private Property property;
	
	
	
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name="tenant_id")
	private Tenant tenant;
	
	//@JsonIgnoreProperties("owner")
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="ownerid")
	private Owner owner;

	public Integer getSpid() {
		return spid;
	}

	public void setSpid(Integer spid) {
		this.spid = spid;
	}

	public Property getProperty() {
		return property;
	}

	public void setProperty(Property property) {
		this.property = property;
	}

	public Tenant getTenant() {
		return tenant;
	}

	public void setTenant(Tenant tenant) {
		this.tenant = tenant;
	}

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}
   
	
	
	
	public ShortlistedProperty() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ShortlistedProperty(Integer spid, Property property, Tenant tenant, Owner owner) {
		super();
		this.spid = spid;
		this.property = property;
		this.tenant = tenant;
		this.owner = owner;
	}

	@Override
	public String toString() {
		return "ShortlistedProperty [spid=" + spid + ", property=" + property + ", tenant=" + tenant + ", owner="
				+ owner + "]";
	}
	
	
	
}
*/