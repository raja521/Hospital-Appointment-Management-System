package com.psic.pojo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Physician {
	
	private int id;
	private String fullName;
	private String Address;
	private String number;
	private List<String> expertisedOn;
	private List<String> treatmentsOffered;
	private Map<String, List<String>> expToTreatments;
	private Map<Integer, List<String>> timings;
	private Map<Integer, List<String>> consultationHours;
	
	public Physician() {
		
	}
	
	
	
	public Physician(int id, String fullName, String address, String number) {
		this.id = id;
		this.fullName = fullName;
		Address = address;
		this.number = number;
		expertisedOn = new ArrayList<>();
		treatmentsOffered = new ArrayList<>();
	}

	
	public Map<String, List<String>> getExpToTreatments() {
		return expToTreatments;
	}

	public void setExpToTreatments(Map<String, List<String>> expToTreatments) {
		this.expToTreatments = expToTreatments;
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
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public List<String> getExpertisedOn() {
		return expertisedOn;
	}
	public void setExpertisedOn(List<String> expertisedOn) {
		this.expertisedOn = expertisedOn;
	}
	public List<String> getTreatmentsOffered() {
		return treatmentsOffered;
	}
	public void setTreatmentsOffered(List<String> treatmentsOffered) {
		this.treatmentsOffered = treatmentsOffered;
	}
	public Map<Integer, List<String>> getTimings() {
		return timings;
	}
	public void setTimings(Map<Integer, List<String>> timings) {
		this.timings = timings;
	}
	public Map<Integer, List<String>> getConsultationHours() {
		return consultationHours;
	}
	public void setConsultationHours(Map<Integer, List<String>> consultationHours) {
		this.consultationHours = consultationHours;
	}
	
	public void addExpertise(String exper) {
		this.expertisedOn.add(exper);
	}
	
	public void addTreatment(String treatment) {
		this.treatmentsOffered.add(treatment);
	}
	

}
