package com.psic.junit;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;

import com.psic.manager.AppointmentManager;
import com.psic.pojo.Appointment;

public class TestClass {
	
	@Test
	public void addPatient() {
		AppointmentManager.getInstance().registerNewPatient(100, "Raja Sekhar", "Hydera", "909");
		assertTrue(AppointmentManager.getInstance().patientsSize() == 16);
	}
	
	@Test
	public void bookAppoinment() {
		Appointment app = new Appointment();
		app.setAppointmentID(1);
		app.setPatientID(123);
		app.setPhysicianID(1005);
		AppointmentManager.getInstance().blockAppointment(app);
		assertTrue(AppointmentManager.getInstance().getAppointmentsByPatientID(123).size()==1);
	}
	

}
