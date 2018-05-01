package com.ram.microservice.security.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author asus
 * 
 */
@Entity
@Table(name="ucf_user")
public class UCFUser {

	@Id
	@Column(name="user_id")
	private String userId;

	@Size(min=8,message="Username should be minimum 8 characters")
	@NotNull
	@Column(name="user_name")
	private String userName;
	
	@NotNull
	@Column(name="first_name")
	private String firstName;

	@Column(name="last_name")
	private String lastName;

	@Column(name="is_admin")
	private boolean isAdmin;

	@Column(name="is_locked")
	private Boolean isLocked;
	
	@JsonIgnore
	@Column(name="password")
	private String password;
	
	@NotNull
	@Email
	@Column(name="email_id")
	private String emailId;

	@NotNull
	@Column(name="role")
	private Integer role;

	public UCFUser(String userName, String firstName, String lastName,
			String password, boolean isAdmin, Integer role) {
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.isAdmin = isAdmin;
		this.password = password;
		this.role = role;
	}

	public UCFUser() {

	}

	public String getUsername() {
		return userName;
	}

	public void setUsername(String username) {
		this.userName = username;
	}

	public String getFirstname() {
		return firstName;
	}

	public void setFirstname(String firstname) {
		this.firstName = firstname;
	}

	public String getLastname() {
		return lastName;
	}

	public void setLastname(String lastname) {
		this.lastName = lastname;
	}

	public boolean isIsadmin() {
		return isAdmin;
	}

	public void setIsadmin(boolean isadmin) {
		this.isAdmin = isadmin;
	}

	public Boolean getIsLocked() {
		return isLocked;
	}

	public void setIsLocked(Boolean isLocked) {
		this.isLocked = isLocked;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmailid() {
		return emailId;
	}

	public void setEmailid(String emailid) {
		this.emailId = emailid;
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
