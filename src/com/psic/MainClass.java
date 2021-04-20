package com.psic;

import java.awt.print.Book;
import java.util.List;
import java.util.Scanner;

import com.psic.manager.AppointmentManager;
import com.psic.pojo.Appointment;

public class MainClass {
	static Scanner sc;
	
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		while(true) {
			System.out.println("1. Book appointment as a patient.");
			System.out.println("2. Book appointment as a visitor.");
			System.out.println("3. Register as a new patient.");
			System.out.println("4. Cancel an appointment.");
			System.out.println("5. Generate report of all appointments.");
			System.out.println("6. Generate report of appointments each patient has booked, attended, cancelled, and missed.");
			System.out.println("7. Exit");
			System.out.print("Please select one of the above options: ");
			
			int input = sc.nextInt();
			if(input==7) {
				System.exit(0);
			}
			if(input == 3) {
				registerNewPatient();
			}
			if(input==1) {
				bookPatientAppointment();
			}
			if(input==4) {
				cancelAppointment();
			}
		}
	}
	
	public static void bookPatientAppointment() {
		System.out.print("Please enter patient ID: ");
		int id = sc.nextInt();
		if(!AppointmentManager.getInstance().verifyPatient(id)) {
			System.out.println("No patients found with id "+id);
		}
		else {
			AppointmentManager.getInstance().bookAppointment(id);
		}
		
		
	}
	
	public void bookVisitorAppointment() {
		
	}
	
	public static void registerNewPatient() {
		System.out.print("Please enter id: ");
		int id = sc.nextInt();
		System.out.print("Please enter full name: ");
		sc.nextLine();
		String name = sc.nextLine();
		System.out.print("Please enter address: ");
		String address = sc.nextLine();
		System.out.print("Please enter number: ");
		String number = sc.nextLine();
		if(AppointmentManager.getInstance().registerNewPatient(id, name, address, number)) {
			System.out.println("Patient registered successfully");
		}else {
			System.out.println("Patient with id "+id+" already exists. Please enter different id");
			
		}
		
	}
	
	public static void cancelAppointment() {
		System.out.print("Please enter your Patient ID: ");
		int id = sc.nextInt();
		List<Appointment> appointments = AppointmentManager.getInstance().getAppointmentsByPatientID(id);
		if(appointments==null) {
			System.out.println("No Active appointments are there for this Patient.");
			return;
		}
		System.out.print("Please enter Appointment ID you want to cancel: ");
		int appID = sc.nextInt();
		for(Appointment app: appointments) {
			if(app.getAppointmentID() == appID) {
				AppointmentManager.getInstance().cancelAppointment(app);
				System.out.println("Your Appointment has been cancelled successfully.");
			}
		}
	}
	
	public void generateReport() {
		
	}
	
	public void generatePatientReport() {
		
	}
	
	

}
