package com.example.BrokerFree.Model;
import lombok.*;

@Data 
public class JwtRequest {
	
	private String email;
	private String password;
	public JwtRequest(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
	public JwtRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "JwtRequest [email=" + email + ", password=" + password + "]";
	}
	public String getEmail() {
		System.out.println(email);
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		System.out.println(password);
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
