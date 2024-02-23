package com.example.BrokerFree.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table
public class Property {
	 @Id
	  @GeneratedValue(strategy=GenerationType.IDENTITY) 
	  @Column(name="pid")
	  int pid;
	 @Column(name="prent")
	  int prent;
	 @Column(name="deposit")
	  int deposit;
	  @Column(name="area")
	  String area;
	 @Column(name="buildname")
	  String buildname;
	 @Column(name="pdtype")
	  String pdtype;
	 @Column(name="pdparking")
	  String pdparking;

	
	
	@ManyToOne
	@JoinColumn(name = "oid")
	private Owner owner;



	public int getPid() {
		return pid;
	}



	public void setPid(int pid) {
		this.pid = pid;
	}



	public int getPrent() {
		return prent;
	}



	public void setPrent(int prent) {
		this.prent = prent;
	}



	public int getDeposit() {
		return deposit;
	}



	public void setDeposit(int deposit) {
		this.deposit = deposit;
	}



	public String getArea() {
		return area;
	}



	public void setArea(String area) {
		this.area = area;
	}



	public String getBuildname() {
		return buildname;
	}



	public void setBuildname(String buildname) {
		this.buildname = buildname;
	}



	public String getPdtype() {
		return pdtype;
	}



	public void setPdtype(String pdtype) {
		this.pdtype = pdtype;
	}



	public String getPdparking() {
		return pdparking;
	}



	public void setPdparking(String pdparking) {
		this.pdparking = pdparking;
	}



	public Owner getOwner() {
		return owner;
	}



	public void setOwner(Owner owner) {
		this.owner = owner;
	}



	public Property(int pid, int prent, int deposit, String area, String buildname, String pdtype, String pdparking,
			Owner owner) {
		super();
		this.pid = pid;
		this.prent = prent;
		this.deposit = deposit;
		this.area = area;
		this.buildname = buildname;
		this.pdtype = pdtype;
		this.pdparking = pdparking;
		this.owner = owner;
	}



	@Override
	public String toString() {
		return "Property [pid=" + pid + ", prent=" + prent + ", deposit=" + deposit + ", area=" + area + ", buildname="
				+ buildname + ", pdtype=" + pdtype + ", pdparking=" + pdparking + ", owner=" + owner + "]";
	}



	public Property() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Integer findById() {
		// TODO Auto-generated method stub
		return null;
	}



	


	  
		
		
}
