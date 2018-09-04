package com.reutlelib.softwareAreas;
import com.reutleib.GUI.*;

public class SoftwareArea {
	private int areaNumber;
	private String areaName;
	private String expertise;
	
	
	public SoftwareArea(){}
			
	public SoftwareArea(int areaNumber, String areaName, String expertise){
		super();
		this.areaNumber = areaNumber;
		this.areaName = areaName;
		this.expertise = expertise;
	}

	public int getAreaNumber() {
		return areaNumber;
	}

	public void setAreaNumber(int areaNumber) {
		this.areaNumber = areaNumber;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public String getExpertise() {
		return expertise;
	}

	public void setExpertise(String expertise) {
		this.expertise = expertise;
	}
	
	
}
