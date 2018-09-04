package com.reutlelib.softwareAreas;
import com.reutleib.GUI.*;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Model {

		static final String user = "Reut";
		static final String password = "reut123456";
		
		// project:
		public static PreparedStatement prepareProject(Project project, PreparedStatement prepareStat) throws SQLException{
			
			prepareStat.setInt(1, project.getProjectNumber());
			prepareStat.setString(2, project.getProjectName());
			prepareStat.setString(3, project.getCustomerName());
			prepareStat.setString(4, project.getStartDate());
			prepareStat.setString(5, project.getDescription());
			prepareStat.setString(6, project.getDevelopmentTools());
			
			return prepareStat;
		}
		
		//engineer:
		public static PreparedStatement prepareEngineer(Engineer engineer, PreparedStatement prepareStat) throws SQLException{
			
			prepareStat.setInt(1, engineer.getEngineerID());
			prepareStat.setString(2, engineer.getEngineerFirstName());
			prepareStat.setString(3,engineer.getEngineerLastName() );
			prepareStat.setString(4, engineer.getEngineerBirthday());
			prepareStat.setInt(5, engineer.getEngineerAge());
			prepareStat.setString(6, engineer.getAddressCity() );
			prepareStat.setString(7, engineer.getAddressStreet());
			prepareStat.setString(8, engineer.getAddressNumber());
			
			return prepareStat;
		}
		
		// SoftWareArea:
		public static PreparedStatement prepareSoftWareArea(SoftwareArea softwateArea, PreparedStatement prepareStat) throws SQLException{
			
			prepareStat.setInt(1, softwateArea.getAreaNumber());
			prepareStat.setString(2, softwateArea.getAreaName());
			prepareStat.setString(3, softwateArea.getExpertise());
		
			return prepareStat;
		}
		
		// prepare Development Stages:
		public static PreparedStatement prepareDevelopmentStages(Project.DevelopmentStages stages, PreparedStatement prepareStat) throws SQLException{
			
			prepareStat.setInt(1, stages.getProjectStageNumber());
			prepareStat.setString(2, stages.getstageName());
			prepareStat.setString(3,stages.gettools() );
			
			return prepareStat;
		}
		
		public static PreparedStatement prepareMilestones(Project.ProjectMilestones milestones, PreparedStatement prepareStat) throws SQLException{
			
			prepareStat.setInt(1, milestones.getProjectMilestonesNumber());
			prepareStat.setInt(2, milestones.getMilestonesNumber());
			prepareStat.setString(3, milestones.getDate());
			prepareStat.setString(4, milestones.getSubmission());
			prepareStat.setInt(5, milestones.getAmountOfMany());
			
			return prepareStat;
		}
		
		public static PreparedStatement preparePhoneNumber(Engineer.EngineerPhoneNumber phone, PreparedStatement prepareStat) throws SQLException{

			prepareStat.setInt(1, phone.getEngineerPhoneID());
			prepareStat.setInt(2, phone.getPhoneNumber());
			
			return prepareStat;
		}
		
		// process project:
		public static void processResultSet_project(ResultSet set, ArrayList<Project> projects) throws SQLException{
			
			while(set.next()){
				// create new project
				projects.add(new Project(set.getInt(1),set.getString(2),set.getString(3),set.getString(4),set.getString(5),set.getString(6) ));
			}			
		}
		
		// process engineer:
		public static void processResultSet_engineer(ResultSet set, ArrayList<Engineer> engineer) throws SQLException{
			
			while(set.next()){
				// create new project
				engineer.add(new Engineer(set.getInt(1),set.getString(2),set.getString(3),set.getString(4),set.getInt(5),set.getString(6), set.getString(7),set.getString(8) ));
			}			
		}
		
}
