package com.example.durgesh.entities;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class LoginData {
	
	@NotBlank(message="User Name can not be emplty")
	@Size(min=3,max=12,message="User name must be 3-12  characters !!")
	private String name;
	
	@Pattern(regexp="^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$" , message="Invalid Email!")
	private String email;
	
	@AssertTrue(message="Must agree temrs and conditions")
	private boolean agreed;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public boolean getAgreed() {
		return agreed;
	}
	public void setAgreed(boolean agreed) {
		this.agreed = agreed;
	}
	@Override
	public String toString() {
		return "LoginData [name=" + name + ", email=" + email + "]";
	}
	

}
