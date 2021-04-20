package com.psic.manager;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.psic.pojo.Appointment;
import com.psic.pojo.Patient;
import com.psic.pojo.Physician;
import com.psic.utils.Constants;
import com.psic.utils.Utils;

public class AppointmentManager {
	
	static AppointmentManager manager;
	
	private Map<Integer,Physician> physicians;
	private Map<Integer,Patient> patients;
	private Map<String,List<Physician>> physiciansByExpertise;
	private Map<String,List<String>> treatmentToRooms;
	List<String> expertises;
	List<String> treatments;
	Map<String,Map<Integer,List<Appointment>>> appointments;
	Map<Integer,List<Appointment>> appointmentsByPatient;
	
	public static AppointmentManager getInstance() {
		if(manager==null) {
			manager = new AppointmentManager();
		}
		
		return manager;
	}
	
	private AppointmentManager() {
		generateDefaultData();
	}
	
	private void generateDefaultData() {
		physicians = new HashMap<>();
		patients = new HashMap<>();
		
		addAllExpertises();
		physiciansByExpertise = new HashMap<>();
		for(String exp: expertises) {
			physiciansByExpertise.put(exp, new ArrayList<>());
		}
		
		generatePhysiciansData();
		
		
		
		patients.put(123, new Patient(123,"Jason Roy","London","6738912442"));
		patients.put(456, new Patient(456,"Robert" ,"Bristol","6764329855"));
		patients.put(189, new Patient(189,"Jonny","Bristol","6473824599"));
		patients.put(176, new Patient(176,"John","London","6473524599"));
		patients.put(165, new Patient(165,"Alex","Liverpool","6483524599"));
		patients.put(198, new Patient(198,"Peter","Glasgow","6983524599"));
		patients.put(254, new Patient(254,"Rocky","London","6083524599"));
		patients.put(250, new Patient(250,"Madison","Glasgow","6243529599"));
		patients.put(249, new Patient(249,"James","Liverpool","6083529599"));
		patients.put(124, new Patient(124,"Lily","Sheffeld","6015529599"));
		patients.put(125, new Patient(125,"Rose","Newcastle","6083469599"));
		patients.put(126, new Patient(126,"Lucy","London","6124529599"));
		patients.put(177, new Patient(177,"Christian","Bristol","6903529599"));
		patients.put(102, new Patient(102,"Bryson","Newcastle","6083524299"));
		patients.put(188, new Patient(188,"Kinsley","London","6064829599"));
		
		
		
		List<String> rooms = new ArrayList<>();
		rooms.add("A");
		rooms.add("B");
		rooms.add("C");
		treatmentToRooms = new HashMap<>();
		treatmentToRooms.put(Constants.neuralMobil, rooms);
		treatmentToRooms.put(Constants.spineMobilisation, rooms);
		treatmentToRooms.put(Constants.acupuncture, rooms);
		treatmentToRooms.put(Constants.massage, rooms);
		
		List<String> rehabRooms = new ArrayList<>();
		rehabRooms.add("Pool");
		treatmentToRooms.put(Constants.poolRehab, rehabRooms);
		
		appointments = new HashMap<>();
		appointmentsByPatient = new HashMap<>();
		
	}
	
	public void generatePhysiciansData() {
		Physician pys1 = new Physician(1001, "Sethu Babu", "XYZ", "1321434322");
		pys1.addExpertise(Constants.physioTherapy);
		pys1.addExpertise(Constants.osteopathy);
		
		pys1.addTreatment(Constants.acupuncture);
		pys1.addTreatment(Constants.neuralMobil);
		pys1.addTreatment(Constants.massage);
		
		Map<String,List<String>> expToTreat1 = new HashMap<>();
		expToTreat1.put(Constants.physioTherapy, new ArrayList<>());
		expToTreat1.put(Constants.osteopathy, new ArrayList<>());
		
		expToTreat1.get(Constants.osteopathy).add(Constants.acupuncture);
		expToTreat1.get(Constants.physioTherapy).add(Constants.massage);
		expToTreat1.get(Constants.osteopathy).add(Constants.neuralMobil);
		pys1.setExpToTreatments(expToTreat1);
		
		
		
		Map<Integer,List<String>> timings = new HashMap<>();
		
		timings.put(2, new ArrayList<String>(){{
            add("10-12");
            add("14-16");
            add("17-19");
            }} );
		timings.put(3, new ArrayList<String>(){{
            add("9-11");
            add("15-17");
            }} );
		timings.put(5, new ArrayList<String>(){{
            add("10-12");
            add("16-18");
            }} );
		timings.put(6, new ArrayList<String>(){{
            add("9-11");
            add("13-15");
            add("16-18");
            }} );
		
		pys1.setTimings(timings);
		physicians.put(pys1.getId(), pys1);
		
		physiciansByExpertise.get(Constants.physioTherapy).add(pys1);
		physiciansByExpertise.get(Constants.osteopathy).add(pys1);
		
		Physician pys2 = new Physician(1002, "James Joseph", "ABC", "1321434982");
		pys2.addExpertise(Constants.physioTherapy);
		pys2.addExpertise(Constants.rehabilation);
		
		pys2.addTreatment(Constants.poolRehab);
		pys2.addTreatment(Constants.massage);
		
		Map<String,List<String>> expToTreat2 = new HashMap<>();
		expToTreat2.put(Constants.physioTherapy, new ArrayList<>());
		expToTreat2.put(Constants.rehabilation, new ArrayList<>());
		
		expToTreat2.get(Constants.physioTherapy).add(Constants.massage);
		expToTreat2.get(Constants.rehabilation).add(Constants.poolRehab);
		pys2.setExpToTreatments(expToTreat2);
		
		Map<Integer,List<String>> timings2 = new HashMap<>();
		
		timings2.put(2, new ArrayList<String>(){{
            add("9-11");
            add("13-15");
            add("16-18");
            }} );
		timings2.put(4, new ArrayList<String>(){{
            add("10-12");
            add("15-17");
            }} );
		timings2.put(5, new ArrayList<String>(){{
            add("10-12");
            add("16-18");
            }} );
		timings2.put(6, new ArrayList<String>(){{
            add("7-9");
            add("11-13");
            add("14-16");
            }} );
		
		pys2.setTimings(timings2);
		physicians.put(pys2.getId(), pys2);
		physiciansByExpertise.get(Constants.rehabilation).add(pys2);
		physiciansByExpertise.get(Constants.physioTherapy).add(pys2);
		
		Physician pys3 = new Physician(1003, "Jason Ali", "London", "6824592913");
		pys3.addExpertise(Constants.osteopathy);
		
		pys3.addTreatment(Constants.acupuncture);
		pys3.addTreatment(Constants.neuralMobil);
		
		Map<String,List<String>> expToTreat3 = new HashMap<>();
		expToTreat3.put(Constants.osteopathy, new ArrayList<>());
		
		expToTreat3.get(Constants.osteopathy).add(Constants.acupuncture);
		expToTreat3.get(Constants.osteopathy).add(Constants.neuralMobil);
		pys3.setExpToTreatments(expToTreat3);
		
		Map<Integer,List<String>> timings3 = new HashMap<>();
		
		timings3.put(3, new ArrayList<String>(){{
            add("9-11");
            add("13-15");
            add("16-18");
            }} );
		timings3.put(4, new ArrayList<String>(){{
            add("10-12");
            add("15-17");
            }} );
		timings3.put(5, new ArrayList<String>(){{
            add("10-12");
            add("16-18");
            }} );
		timings3.put(7, new ArrayList<String>(){{
            add("7-9");
            add("11-13");
            add("14-16");
            }} );
		
		pys3.setTimings(timings3);
		physicians.put(pys3.getId(), pys3);
		physiciansByExpertise.get(Constants.osteopathy).add(pys3);
		
		Physician pys4 = new Physician(1003, "John Abraham", "London", "6961592913");
		pys4.addExpertise(Constants.physioTherapy);
		
		pys4.addTreatment(Constants.massage);
		pys4.addTreatment(Constants.spineMobilisation);
		
		Map<String,List<String>> expToTreat4 = new HashMap<>();
		expToTreat4.put(Constants.physioTherapy, new ArrayList<>());
		
		expToTreat4.get(Constants.physioTherapy).add(Constants.massage);
		expToTreat4.get(Constants.physioTherapy).add(Constants.spineMobilisation);
		pys4.setExpToTreatments(expToTreat4);
		
		Map<Integer,List<String>> timings4 = new HashMap<>();
		
		timings4.put(3, new ArrayList<String>(){{
            add("9-11");
            add("13-15");
            add("16-18");
            }} );
		timings4.put(4, new ArrayList<String>(){{
            add("10-12");
            add("15-17");
            }} );
		timings4.put(5, new ArrayList<String>(){{
            add("10-12");
            add("16-18");
            }} );
		timings4.put(7, new ArrayList<String>(){{
            add("7-9");
            add("11-13");
            add("14-16");
            }} );
		
		pys4.setTimings(timings4);
		physicians.put(pys4.getId(), pys4);
		physiciansByExpertise.get(Constants.physioTherapy).add(pys4);
		
		Physician pys5 = new Physician(1005, "Rhea", "London", "6981292914");
		pys5.addExpertise(Constants.rehabilation);
		pys5.addExpertise(Constants.osteopathy);
		
		pys5.addTreatment(Constants.poolRehab);
		pys5.addTreatment(Constants.neuralMobil);
		pys5.addTreatment(Constants.acupuncture);
		
		Map<String,List<String>> expToTreat5 = new HashMap<>();
		expToTreat5.put(Constants.rehabilation, new ArrayList<>());
		expToTreat5.put(Constants.osteopathy, new ArrayList<>());
		
		expToTreat5.get(Constants.rehabilation).add(Constants.poolRehab);
		expToTreat5.get(Constants.osteopathy).add(Constants.neuralMobil);
		expToTreat5.get(Constants.osteopathy).add(Constants.acupuncture);
		pys5.setExpToTreatments(expToTreat5);
		
		Map<Integer,List<String>> timings5 = new HashMap<>();
		
		timings5.put(3, new ArrayList<String>(){{
            add("9-11");
            add("13-15");
            add("16-18");
            }} );
		timings5.put(4, new ArrayList<String>(){{
            add("10-12");
            add("15-17");
            }} );
		timings5.put(6, new ArrayList<String>(){{
            add("10-12");
            add("16-18");
            }} );
		timings5.put(1, new ArrayList<String>(){{
            add("7-9");
            add("11-13");
            add("14-16");
            }} );
		
		pys5.setTimings(timings5);
		physicians.put(pys5.getId(), pys5);
		physiciansByExpertise.get(Constants.rehabilation).add(pys5);
		physiciansByExpertise.get(Constants.osteopathy).add(pys5);
		
	}
	
	public void addAllExpertises() {
		expertises = new ArrayList<>();
		expertises.add(Constants.physioTherapy);
		expertises.add(Constants.osteopathy);
		expertises.add(Constants.rehabilation);
	}
	
	public boolean registerNewPatient(int id, String name, String address, String num) {
		if(patients.containsKey(id)) {
			return false;
		}
		else {
			synchronized(this) {
				patients.put(id, new Patient(id, name, address, num));
			}
			return true;
		}
	}
	
	public void bookAppointment(int patientID) {
		System.out.println("1. Look for treatments by expertise");
		System.out.println("2. Look for the physicians");
		System.out.print("Select 1 or 2: ");
		Scanner sc = new Scanner(System.in);
		int option = sc.nextInt();
		if(option == 1) {
			bookAppointmentByExpertise(patientID);
		}else if(option == 2) {
			
		}
	}
	
	public void bookAppointmentByExpertise(int patientID) {
		for(int i=0; i<expertises.size(); i++) {
			System.out.println(i+1+". "+expertises.get(i));
		}
		System.out.print("Please select the expertise: ");
		Scanner sc = new Scanner(System.in);
		int option = sc.nextInt();
		String exp = expertises.get(option-1);
		System.out.print("Please enter the date on which you are looking to book appointment in dd-mm-yyyy format: ");
		String date = sc.next();
		boolean isValid = Utils.validateDate(date);
		if(!isValid) {
			return;
		}
		int day = Utils.getDayFromDate(date);
		List<Physician> phys = physiciansByExpertise.get(exp);
		List<Appointment> availableApps = new ArrayList<>();
		for(int i =0; i<phys.size(); i++) {
			Physician phy = phys.get(i);
			List<String> timings = phy.getTimings().get(day);
			if(timings==null)
				continue;
			List<Appointment> apps = null;
			if(appointments.get(date)!=null)
				apps= appointments.get(date).get(phy.getId());
			for(String time: timings) {
				if(apps==null || verifyAvailability(time, apps)) {
					for(String treatment: phy.getExpToTreatments().get(exp)) {
						Appointment appointment = new Appointment();
						appointment.setPhysicianID(phy.getId());
						appointment.setAppointmentDate(date);
						appointment.setPhysicianName(phy.getFullName());
						appointment.setPatientID(patientID);
						appointment.setTiming(time);
						appointment.setTreatment(treatment);
						availableApps.add(appointment);
					}
				}
			}
		}
		if(availableApps.size()==0){
			System.out.println("No appointments available for the selected day. please try with some other date");
			return;
		}
		System.out.println("s.no\tPhysician Name\tTreatment Name\t\tAppointment Timing");
		for(int i=0;i<availableApps.size(); i++) {
			Appointment appointment = availableApps.get(i);
			System.out.println(i+1+".\t"+appointment.getPhysicianName()+"\t"+appointment.getTreatment()+"\t\t"+appointment.getTiming());
		}
		System.out.print("Please select one of the above appointments: ");
		int num = sc.nextInt();
		Appointment app = availableApps.get(num-1);
		blockAppointment(app);
		
	}
	
	
	
	public synchronized void blockAppointment(Appointment app) {
		app.setAppointmentID(Appointment.max++);
		if(appointments.get(app.getAppointmentDate())==null) {
			Map<Integer,List<Appointment>> apps = new HashMap<>();
			apps.put(app.getPhysicianID(), new ArrayList<>());
			apps.get(app.getPhysicianID()).add(app);
			appointments.put(app.getAppointmentDate(), apps);
		}else {
			Map<Integer,List<Appointment>> apps = appointments.get(app.getAppointmentDate());
			if(apps.get(app.getPhysicianID())==null) {
				apps.put(app.getPhysicianID(), new ArrayList<>());
				apps.get(app.getPhysicianID()).add(app);
			}else {
				apps.get(app.getPhysicianID()).add(app);
			}
		}
		if(appointmentsByPatient.get(app.getPatientID())==null) {
			appointmentsByPatient.put(app.getPatientID(), new ArrayList<>());
			appointmentsByPatient.get(app.getPatientID()).add(app);
		}else {
			appointmentsByPatient.get(app.getPatientID()).add(app);
		}
		
		System.out.println("Appointment booked successfully. Appointment ID: "+app.getAppointmentID());
	}
	
	public boolean verifyAvailability(String time, List<Appointment> apps) {
		for(Appointment app: apps) {
			if(app.getTiming().equals(time) && app.isCancelled()==false) {
				return false;
			}
		}
		return true;
	}

	public boolean verifyPatient(int id) {
		return patients.containsKey(id);
	}
	
	public List<Appointment> getAppointmentsByPatientID(int id){
		return appointmentsByPatient.get(id).stream().filter(app -> app.isCancelled()==false).collect(Collectors.toList());
	}
	
	public void cancelAppointment(int patientID, int appointmentID) {
		List<Appointment> appointments = getAppointmentsByPatientID(patientID);
		for(Appointment app: appointments) {
			if(app.getAppointmentID() == appointmentID) {
				cancelAppointment(app);
			}
		}
	}
	
	public synchronized void cancelAppointment(Appointment app) {
		app.setCancelled(true);
	}
	
	
}
