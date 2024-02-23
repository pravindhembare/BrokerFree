package com.example.BrokerFree.Model;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="tenant")
public class Tenant implements UserDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
     private Integer tid;

	@Column
     private String tname;
	
	@Column
     private String temail;
	
	@Column
     private String tcontact;
	
	@Column
    private String taddress;
		
	@Column
     private String tpassword;
	
	@Column
    private String tpassreq;
		
	@Column
     private String tpassans;

	//@OneToMany(mappedBy = "tenant")
	//Set<ShortlistedProperty> sp;


	
	public Tenant() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getTid() {
		return tid;
	}
	public void setTid(Integer tid) {
		this.tid = tid;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public String getTemail() {
		return temail;
	}
	public void setTemail(String temail) {
		this.temail = temail;
	}
	public String getTcontact() {
		return tcontact;
	}
	public void setTcontact(String tcontact) {
		this.tcontact = tcontact;
	}
	public String getTpassword() {
		return tpassword;
	}
	public void setTpassword(String tpassword) {
		this.tpassword = tpassword;
	}
	public Tenant(Integer tid, String tname, String temail, String tcontact, String taddress, String tpassword,
			String tpassreq, String tpassans) {
		super();
		this.tid = tid;
		this.tname = tname;
		this.temail = temail;
		this.tcontact = tcontact;
		this.taddress = taddress;
		this.tpassword = tpassword;
		this.tpassreq = tpassreq;
		this.tpassans = tpassans;
	}
	public String getTaddress() {
		return taddress;
	}
	public void setTaddress(String taddress) {
		this.taddress = taddress;
	}
	public String getTpassreq() {
		return tpassreq;
	}
	public void setTpassreq(String tpassreq) {
		this.tpassreq = tpassreq;
	}
	public String getTpassans() {
		return tpassans;
	}
	public void setTpassans(String tpassans) {
		this.tpassans = tpassans;
	}


    @Override
    public String toString() {
        return "Tenant [tid=" + tid + ", tname=" + tname + ", temail=" + temail + ", tcontact=" + tcontact
                + ", taddress=" + taddress + ", tpassword=" + tpassword + ", tpassreq=" + tpassreq + ", tpassans="
                + tpassans + "]";
    }

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.temail;
	}
	
	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.tpassword;
	}
	
	

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	
	
}
