package com.example.BrokerFree.Model;

import java.util.Collection;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="owner")
public class Owner implements UserDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="oid")
	private Integer oid;
	
	//@NotNull
	@Column(name="oname")
	private String oname;
	
//	@NotNull
	@Column(name="oemail")
	private String oemail;
	
	//@NotNull
	@Column(name="ocontact")
	private String ocontact;
	
	//@NotNull
		@Column(name="oaddress")
		private String oaddress;
	
	//@NotNull
	@Column(name="opassword")
	private String opassword;
	
	//@NotNull
		@Column(name="opassreq")
		private String opassreq;
		
	//@NotNull
		@Column(name="opassans")
		private String opassans;
	
	 //@JsonManagedReference
	  @JsonIgnoreProperties("owner")
	  @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
	  private Set<PropertyBasicDetails> properties;
	
    public Owner()
    {
    	System.out.println("In Owners Constructor:"+getClass().getName());
    }

	public Integer getOid() {
		return oid;
	}

	public void setOid(Integer oid) {
		this.oid = oid;
	}

	public String getOname() {
		return oname;
	}

	public void setOname(String oname) {
		this.oname = oname;
	}

	public String getOemail() {
		return oemail;
	}

	public void setOemail(String oemail) {
		this.oemail = oemail;
	}

	public String getOcontact() {
		return ocontact;
	}

	public void setOcontact(String ocontact) {
		this.ocontact = ocontact;
	}

	public String getOpassword() {
		return opassword;
	}

	public void setOpassword(String opassword) {
		this.opassword = opassword;
	}
	
	public String getOaddress() {
		return oaddress;
	}

	public void setOaddress(String oaddress) {
		this.oaddress = oaddress;
	}

	public String getOpassreq() {
		return opassreq;
	}

	public void setOpassreq(String opassreq) {
		this.opassreq = opassreq;
	}

	public String getOpassans() {
		return opassans;
	}

	public void setOpassans(String opassans) {
		this.opassans = opassans;
	}

	public Owner(Integer oid, String oname, String oemail, String ocontact, String oaddress, String opassword,
			String opassreq, String opassans, Set<PropertyBasicDetails> properties) {
		super();
		this.oid = oid;
		this.oname = oname;
		this.oemail = oemail;
		this.ocontact = ocontact;
		this.oaddress = oaddress;
		this.opassword = opassword;
		this.opassreq = opassreq;
		this.opassans = opassans;
		this.properties = properties;
	}

	public Set<PropertyBasicDetails> getProperties() {
		return properties;
	}

	public void setProperties(Set<PropertyBasicDetails> properties) {
		this.properties = properties;
	}

	@Override
	public String toString() {
		return "Owner [oid=" + oid + ", oname=" + oname + ", oemail=" + oemail + ", ocontact=" + ocontact
				+ ", oaddress=" + oaddress + ", opassword=" + opassword + ", opassreq=" + opassreq + ", opassans="
				+ opassans + ", properties=" + properties + "]";
	}
	
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.oemail;
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
	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.opassword;
	}		
	
}
