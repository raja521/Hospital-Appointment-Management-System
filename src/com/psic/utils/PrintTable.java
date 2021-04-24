package com.psic.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.psic.pojo.Appointment;

public class PrintTable {
	
	/*//Physician Name, treatment name, patient name, date, time, room
	
	public  void print(List<String> headers, List<Appointment> apps) {
		Map<String, Integer> max = findMaxLength(headers.size(), apps);
		printRow(max, headers);
		System.out.println();
		printHeaders(max, headers);
		System.out.println();
		printRow(max, headers);
		System.out.println();
		
		for(int i=0; i<apps.size(); i++) {
			Appointment app = apps.get(i);
			System.out.print("|  ");
			System.out.print(app.getPhysicianName());
			int spaces = (max.get("Physician Name") - app.getPhysicianName().length());
			printSpaces(spaces);
		
			
		}
		
		
		
	}
	
	public void printSpaces(int len) {
		for(int i=0; i<len; i++) {
			System.out.print(" ");
		}
	}
	
	public void printRow(Map<String, Integer> map, List<String> headers) {
		for(int i=0; i<headers.size(); i++) {
			if(i==0) {
				System.out.print("+");
			}
			for(int temp=0; temp <(map.get(headers.get(i))+4); temp++) {
				System.out.print("-");
			}
			System.out.println("+");
		}
	}
	
	public void printHeaders(Map<String, Integer> map, List<String> headers) {
		for(int i=0; i<headers.size(); i++) {
			System.out.print("|  ");
			System.out.print(headers.get(i));
			int spaces = map.get(headers.get(i)) - headers.get(i).length();
			for(int temp =0; temp< spaces; temp++) {
				System.out.print(" ");
			}
			System.out.print("  ");
			
		}
		System.out.print("|");
	}
	
	public Map<String, Integer> findMaxLength(int length, List<Appointment> apps){
		Map<String, Integer> map = new HashMap<>();
		map.put("Date", 10);
		map.put("Time", 5);
		map.put("Room", 4);
		map.put("Physician Name", "Physician Name".length());
		map.put("Treatment Name", "Treatment Name".length());
		map.put("Patient Name", "Patient Name".length());
		for(Appointment app: apps) {
			if(map.containsKey("Physician Name") && map.get("Physician Name") <app.getPhysicianName().length()) {
				map.put("Physician Name", app.getPhysicianName().length());
			}else {
				map.put("Physician Name", app.getPhysicianName().length());
			}
			
			if(map.containsKey("Treatment Name") && map.get("Treatment Name") <app.getTreatment().length()) {
				map.put("Treatment Name", app.getPhysicianName().length());
			}else {
				map.put("Treatment Name", app.getPhysicianName().length());
			}
			
			if(map.containsKey("Patient Name") && map.get("Patient Name") <app.getPatientName().length()) {
				map.put("Patient Name", app.getPhysicianName().length());
			}else {
				map.put("Patient Name", app.getPhysicianName().length());
			}
			
			
		}
		
		
		return map;
	}*/
	
	
	public static  void print(List<List<String>> headers, List<String> head) {
		Map<Integer, Integer> map = getMaxLength(headers, head);
		for(int i=0; i< headers.get(0).size(); i++) {
			if(i==0)
				System.out.print("+");
			for(int temp =0; temp<(map.get(i)+4); temp++) {
				System.out.print("-");
			}
			System.out.print("+");
		}
		
		
		System.out.println();
		
		for(int i=0; i<head.size(); i++) {
			System.out.print("|  ");
			System.out.print(head.get(i));
			int spaces = map.get(i);
			for(int j=0; j<(spaces -head.get(i).length()); j++) {
				System.out.print(" ");
			}
			System.out.print("  ");
		}
		System.out.print("|");
		System.out.println();
		for(int i=0; i< headers.get(0).size(); i++) {
			if(i==0)
				System.out.print("+");
			for(int temp =0; temp<(map.get(i)+4); temp++) {
				System.out.print("-");
			}

			System.out.print("+");
		}
		
		System.out.println("");
		
		for(int i=0; i<headers.size(); i++) {
			List<String> row = headers.get(i);
			for(int j=0; j<row.size(); j++) {
				System.out.print("|  ");
				System.out.print(row.get(j));
				int spaces = map.get(j);
				for(int temp =0; temp< (spaces-row.get(j).length()); temp++) {
					System.out.print(" ");
				}
				System.out.print("  ");
				
			}
			System.out.print("|");
			System.out.println("");
		}
		for(int i=0; i< headers.get(0).size(); i++) {
			if(i==0)
				System.out.print("+");
			for(int temp =0; temp<(map.get(i)+4); temp++) {
				System.out.print("-");
			}

			System.out.print("+");
		}
		System.out.println();
	}
	
	public static Map<Integer, Integer> getMaxLength(List<List<String>> list, List<String> headers) {
		Map<Integer, Integer> map = new HashMap<>();
		for(int i=0; i<headers.size(); i++) {
			map.put(i, headers.get(i).length());
		}
		for(int i=0; i<list.size(); i++) {
			List<String> row = list.get(i);
			for(int j=0; j<row.size(); j++) {
				if(map.containsKey(j) && map.get(j) < row.get(j).length()) {
					map.put(j, row.get(j).length());
				}else {
					if(!map.containsKey(j))
						map.put(j, row.get(j).length());
				}
			}
		}
		
		return map;
	}
	
}
