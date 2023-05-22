package com.iemr.admin.data.createOrder;

import java.sql.Date;

public class CreateOrderData {
	private String firstName;
	private String middleName;
	private String LastName;
	private String gender;
	private String dob;
	private String patientID;
	private String acc;
	
	
	public CreateOrderData() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	public String getPatientID() {
		return patientID;
	}




	public void setPatientID(String patientID) {
		this.patientID = patientID;
	}




	public String getAcc() {
		return acc;
	}




	public void setAcc(String acc) {
		this.acc = acc;
	}




	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}




	public String getDob() {
		return dob;
	}




	public void setDob(String dob) {
		this.dob = dob;
	}
	
	
	
	

}
