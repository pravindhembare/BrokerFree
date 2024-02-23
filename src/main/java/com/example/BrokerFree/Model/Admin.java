
package com.example.BrokerFree.Model;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "admin")
public class Admin implements UserDetails {

	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="email",unique = true,nullable = false)
	private String email;
	
	@Column(name="password",nullable = false)
    private String password;
	
	@Column(name="akey")
	private String akey;
	
	public String getAkey() {
		return akey;
	}

	public void setAkey(String key) {
		this.akey = key;
	}

	public Admin()
	{
		super();
		System.out.println("In Admin constructor.................."+getClass().getName());
	}

	public Admin(String email, String password, String akey)
	{
		super();
		this.email = email;
		this.password = password;
		this.akey = akey;
	}


	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email) 
	{
		this.email = email;
	}

	public String getPassword() 
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}
	

	@Override
	public String toString() {
		return "Admin [email=" + email + ", password=" + password + ", akey=" + akey + "]";
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.email;
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
	
	