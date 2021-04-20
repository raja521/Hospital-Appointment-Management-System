package com.psic.pojo;

public class Patient {
	
	private int id;
	private String fullName;
	private String address;
	private String number;
	
	
	
	public Patient(int id, String fullName, String address, String number) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.address = address;
		this.number = number;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	
	

}
