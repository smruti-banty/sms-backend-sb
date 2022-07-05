package com.smruti.demo1.model;

/**
 * @author srnay
 *
 */
public class Student {
	private int roll;
	private String firstname;
	private String lastname;
	private String email;
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public int getRoll() {
		return roll;
	}
	public void setRoll(int roll) {
		this.roll = roll;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Student [roll=" + roll + ", firstname=" + firstname + ", lastname=" + lastname + ", email=" + email
				+ "]";
	}
	
}
