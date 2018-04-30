package com.ram.microservice.security.entities;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author asus
 * 
 */
@Document(collection="user")
public class UCFUser {

	@Id
	private String userId;

	@Size(min=8,message="Username should be minimum 8 characters")
	@NotNull
	private String username;
	@NotNull
	private String firstname;

	private String lastname;

	private boolean isadmin;

	private Boolean islocked;
	
	@JsonIgnore
	private String password;
	
	@NotNull
	@Email
	private String emailid;

	private Integer role;

	public UCFUser(String userName, String firstName, String lastName,
			String password, boolean isAdmin, Integer role) {
		this.username = userName;
		this.firstname = firstName;
		this.lastname = lastName;
		this.isadmin = isAdmin;
		this.password = password;
		this.role = role;
	}

	public UCFUser() {

	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public boolean isIsadmin() {
		return isadmin;
	}

	public void setIsadmin(boolean isadmin) {
		this.isadmin = isadmin;
	}

	public Boolean getIsLocked() {
		return islocked;
	}

	public void setIsLocked(Boolean isLocked) {
		this.islocked = isLocked;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	public Integer getRole() {
		return role;
	}

	public void setRole(Integer role) {
		this.role = role;
	}

	public String getUserId() {
		return userId;
	}

//	 
}
