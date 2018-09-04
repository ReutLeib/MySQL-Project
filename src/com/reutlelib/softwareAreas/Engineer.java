package com.reutlelib.softwareAreas;
import com.reutleib.GUI.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;

public class Engineer {
	private int engineerID;
	private String engineerFirstName;
	private String engineerLastName;
	private String engineerBirthday;
	private int engineerAge;
	private String addressCity;
	private String addressStreet;
	private String addressNumber;
	
	// _________ engineer phones __________
	
	public static class EngineerPhoneNumber{
		
		private int engineerPhoneID;
		private int phoneNumber;
		
		public EngineerPhoneNumber() {}

		public EngineerPhoneNumber(int engineerPhoneID, int phoneNumber) {
			super();
			this.engineerPhoneID = engineerPhoneID;
			this.phoneNumber = phoneNumber;
		}

		public int getEngineerPhoneID() {
			return engineerPhoneID;
		}

		public void setEngineerPhoneID(int engineerPhoneID) {
			this.engineerPhoneID = engineerPhoneID;
		}

		public int getPhoneNumber() {
			return phoneNumber;
		}

		public void setPhoneNumber(int phoneNumber) {
			this.phoneNumber = phoneNumber;
		}
		
		
		
		
		
	}

	public Engineer(){}
	
	public Engineer(int engineerID, String engineerFirstName, String engineerLastName, String engineerBirthday,
			int engineerAge, String addressCity, String addressStreet, String addressNumber) {
		super();
		this.engineerID = engineerID;
		this.engineerFirstName = engineerFirstName;
		this.engineerLastName = engineerLastName;
		this.engineerBirthday = engineerBirthday;
		this.engineerAge = engineerAge;
		this.addressCity = addressCity;
		this.addressStreet = addressStreet;
		this.addressNumber = addressNumber;
	}
	//getters & setters:

	public int getEngineerID() {
		return engineerID;
	}

	public void setEngineerID(int engineerID) {
		this.engineerID = engineerID;
	}

	public String getEngineerFirstName() {
		return engineerFirstName;
	}

	public void setEngineerFirstName(String engineerFirstName) {
		this.engineerFirstName = engineerFirstName;
	}

	public String getEngineerLastName() {
		return engineerLastName;
	}

	public void setEngineerLastName(String engineerLastName) {
		this.engineerLastName = engineerLastName;
	}

	public String getEngineerBirthday() {
		return engineerBirthday;
	}

	public void setEngineerBirthday(String engineerBirthday) {
		this.engineerBirthday = engineerBirthday;
	}

	public int getEngineerAge() {
		return engineerAge;
	}

	public void setEngineerAge(int engineerAge) {
		this.engineerAge = engineerAge;
	}

	public String getAddressCity() {
		return addressCity;
	}

	public void setAddressCity(String addressCity) {
		this.addressCity = addressCity;
	}

	public String getAddressStreet() {
		return addressStreet;
	}

	public void setAddressStreet(String addressStreet) {
		this.addressStreet = addressStreet;
	}

	public String getAddressNumber() {
		return addressNumber;
	}

	public void setAddressNumber(String addressNumber) {
		this.addressNumber = addressNumber;
	}
	
	
	
	
	
	
}
