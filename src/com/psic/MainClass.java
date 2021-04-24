package com.psic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import com.psic.junit.TestClass;
import com.psic.manager.AppointmentManager;
import com.psic.pojo.Appointment;
import com.psic.utils.Utils;

public class MainClass {
	
	public static void main(String[] args) throws  IOException {
		Utils.br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			try {

				System.out.println("1. Book appointment as a patient.");
				System.out.println("2. Book appointment as a visitor.");
				System.out.println("3. Register as a new patient.");
				System.out.println("4. Cancel an appointment.");
				System.out.println("5. Attend an appointment");
				System.out.println("6. Generate report of all appointments.");
				System.out.println("7. Generate report of appointments each patient has booked, attended, cancelled, and missed.");
				System.out.println("8. Exit");
				System.out.print("Please select one of the above options: ");
				
				int input = Utils.readInteger();
				if(input==8) {
					Utils.br.close();
					System.exit(0);
				}
				else if(input == 3) {
					registerNewPatient();
				}
				else if(input==1) {
					bookPatientAppointment();
				}
				else if(input==4) {
					cancelAppointment();
				}
				else if(input==2) {
					bookVisitorAppointment();
				}
				else if(input ==5) {
					markAppointment();
				}
				else if(input==6) {
					AppointmentManager.getInstance().generateReport();
				}
				else if(input== 7) {
					AppointmentManager.getInstance().generatePatientsReport();
				}
				else {
					System.out.println("Incorrect input. Please enter inputs from 1-8");
					Thread.sleep(2000);
				}
			
			}catch(Exception e) {
				System.out.println("Unknown excepton "+e.getMessage()+" occured during processing. Please try again.");
			}
			
		}
	}
	
	public static void bookPatientAppointment() {
		System.out.print("Please enter patient ID: ");
		int id = Utils.readInteger();
		if(!AppointmentManager.getInstance().verifyPatient(id)) {
			System.out.println("No patients found with id "+id);
		}
		else {
			AppointmentManager.getInstance().bookAppointment(id);
		}
				
	}
	
	public static void bookVisitorAppointment() {
		System.out.print("Please enter visitor name: ");
		
		String name = Utils.readString();
		System.out.print("Please enter date on which you want to book appointment: ");
		String date = Utils.readString();
		AppointmentManager.getInstance().bookVisitorAppointment(name, date);
		
	}
	
	public static void registerNewPatient() {
		System.out.print("Please enter id: ");
		int id = Utils.readInteger();
		System.out.print("Please enter full name: ");
		//Utils.scanner.nextLine();
		String name = Utils.readString();
		System.out.print("Please enter address: ");
		String address = Utils.readString();
		System.out.print("Please enter number: ");
		String number = Utils.readString();
		if(AppointmentManager.getInstance().registerNewPatient(id, name, address, number)) {
			System.out.println("Patient registered successfully");
		}else {
			System.out.println("Patient with id "+id+" already exists. Please enter different id");
			
		}
		
	}
	
	public static void cancelAppointment() {
		System.out.print("Please enter your Patient ID: ");
		int id = Utils.readInteger();
		System.out.print("Please enter Appointment ID you want to cancel: ");
		int appID = Utils.readInteger();
		AppointmentManager.getInstance().cancelAppointment(id, appID);
	}
	
	public static void markAppointment() {
		System.out.print("Please enter Patient ID: ");
		int id = Utils.readInteger();
		System.out.print("Please enter Appointment ID");
		int appointmentID = Utils.readInteger();
		AppointmentManager.getInstance().markAppointment(id, appointmentID);
	}	

}
