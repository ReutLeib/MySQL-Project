package com.reutlelib.softwareAreas;
import com.reutleib.GUI.*;

import java.sql.Date;
import java.util.List;

public class Project {

	private int projectNumber;
	private String projectName;
	private String customerName;
	private String startDate;
	private String description;
	private String developmentTools;
	
	// _______ Project milestones ______________
	
	public static class ProjectMilestones{
		
		private int projectMilestonesNumber;
		private int milestonesNumber;
		private String date;
		private String 	submission;
		private int amountOfMany;
		
		public ProjectMilestones(){}

		public ProjectMilestones(int projectMilestonesNumber, int milestonesNumber, String date, String submission,
				int amountOfMany) {
			super();
			this.projectMilestonesNumber = projectMilestonesNumber;
			this.milestonesNumber = milestonesNumber;
			this.date = date;
			this.submission = submission;
			this.amountOfMany = amountOfMany;
		}

		public int getProjectMilestonesNumber() {
			return projectMilestonesNumber;
		}

		public void setProjectMilestonesNumber(int projectMilestonesNumber) {
			this.projectMilestonesNumber = projectMilestonesNumber;
		}

		public int getMilestonesNumber() {
			return milestonesNumber;
		}

		public void setMilestonesNumber(int milestonesNumber) {
			this.milestonesNumber = milestonesNumber;
		}

		public String getDate() {
			return date;
		}

		public void setDate(String date) {
			this.date = date;
		}

		public String getSubmission() {
			return submission;
		}

		public void setSubmission(String submission) {
			this.submission = submission;
		}

		public int getAmountOfMany() {
			return amountOfMany;
		}

		public void setAmountOfMany(int amountOfMany) {
			this.amountOfMany = amountOfMany;
		}
		
		
		
	}

	// _______ Development Stages ______________ 
	
	public static class DevelopmentStages{
		private int projectStageNumber;
		private String stageName;
		private String tools;
		
		public DevelopmentStages(){}
		
		public DevelopmentStages(int projectStageNumber, String stageName, String tools) {
			super();
			this.projectStageNumber = projectStageNumber;
			this.stageName = stageName;
			this.tools = tools;
		}

		public int getProjectStageNumber() {
			return projectStageNumber;
		}

		public void setProjectStageNumber(int projectStageNumber) {
			this.projectStageNumber = projectStageNumber;
		}

		public String getstageName() {
			return stageName;
		}

		public void setstageName(String stageName) {
			this.stageName = stageName;
		}

		public String gettools() {
			return tools;
		}

		public void settools(String tools) {
			this.tools = tools;
		}
		
		
		
	}
	
	// _______ END ______________ 
	

	public Project(){}
	
	public Project(int projectNumber, String projectName, String customerName, String startDate, String description,
			String developmentTools) {
		
		super();
		this.projectNumber = projectNumber;
		this.projectName = projectName;
		this.customerName = customerName;
		this.startDate = startDate;
		this.description = description;
		this.developmentTools = developmentTools;
	}
	
	
	// getters & setters:
	public int getProjectNumber() {
		return projectNumber;
	}
	public void setProjectNumber(int projectNumber) {
		this.projectNumber = projectNumber;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDevelopmentTools() {
		return developmentTools;
	}
	public void setDevelopmentTools(String developmentTools) {
		this.developmentTools = developmentTools;
	}


	
	
	
}
