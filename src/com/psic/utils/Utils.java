package com.psic.utils;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Utils {
	
	public static int getDayFromDate(String date) {

		Calendar cal = Calendar.getInstance();
		String[] days = date.split("-");
		cal.set(Integer.parseInt(days[2]), Integer.parseInt(days[1])-1, Integer.parseInt(days[0]));
		return cal.get(Calendar.DAY_OF_WEEK);
	
	}
	
	public static boolean validateDate(String date) {
		Calendar cal = Calendar.getInstance();
		String[] days = date.split("-");
		cal.set(Integer.parseInt(days[2]), Integer.parseInt(days[1])-1, Integer.parseInt(days[0]));
		Date currDate = new Date();
		if(currDate.after(cal.getTime())) {
			System.out.println("Appointments for the selected date is already closed. Please try again with valid date");
			return false;
		}
		long mill = cal.getTime().getTime() - currDate.getTime();
		long diff = TimeUnit.DAYS.convert(mill, TimeUnit.MILLISECONDS);
		if(diff>28) {
			System.out.println("Bookings for the selected date is not opened yet.");
			return false;
		}
		
		return true;
	}

}
