package com.reutlelib.softwareAreas;
import com.reutleib.GUI.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionMng {

	// JDBC driver name and database URL
	static final String driver = "com.mysql.jdbc.Driver";
	// protocol: (useSSL=true couse exception)
	static final String protocol = "jdbc:mysql://localhost:3306/db_reutleib?useSSL=true";
	public static Connection connection = null;
	Statement statement = null;
	ResultSet rs = null;
	ResultSet tables = null; // for checking if specific table exist
	java.sql.DatabaseMetaData dbm = null;
	private Boolean commit = true; 

	// reference to GUI
	// in GUI need to be a reference to connection
	
	//singletone
	private ConnectionMng(){}
	private static ConnectionMng instance = null;
	public static ConnectionMng getInstance(){
		if(instance == null){
			instance = new ConnectionMng();
		}
		return instance;
	}
	
	public void initiolazingConnection() {

		try {
			// Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");
			// Open connection
			connection = DriverManager.getConnection(protocol, Model.user, Model.password);
			connection.setAutoCommit(commit);
			// execute a query
			statement = connection.createStatement();
			/* Tests before creating tables */
			dbm = connection.getMetaData();

			// ----------------------------------------------------
			
			
			
			/* project table */
			tables = dbm.getTables(null, null, "project", null);
			if (!(tables.next())) {
				// table does not exist:
				try {
					statement.execute(DBFunctions.createTable_Project);
				} catch (SQLException e) {
					System.out.println("SQLException info:");
					System.out.println(e.getMessage());
				}
			}

			/* ProjectMilestones table */
			tables = dbm.getTables(null, null, "project_milestones", null);
			if (!(tables.next())) {
				// table does not exist:
				try {
					statement.execute(DBFunctions.createTable_ProjectMilestones);
				} catch (SQLException e) {
					System.out.println("SQLException info:");
					System.out.println(e.getMessage());
				}
			}

			/* Engineer table */
			tables = dbm.getTables(null, null, "engineer", null);
			if (!(tables.next())) {
				// table does not exist:
				try {
					statement.execute(DBFunctions.craeteTable_Engineer);
				} catch (SQLException e) {
					System.out.println("SQLException info:");
					System.out.println(e.getMessage());
				}
			}

			/* SoftwareArea table */
			tables = dbm.getTables(null, null, "software_area", null);
			if (!(tables.next())) {
				// table does not exist:
				try {
					statement.execute(DBFunctions.createTable_SoftwareArea);
				} catch (SQLException e) {
					System.out.println("SQLException info:");
					System.out.println(e.getMessage());
				}
			}

			/* EngineerPhoneNumber table */
			tables = dbm.getTables(null, null, "engineer_phone_number", null);
			if (!(tables.next())) {
				// table does not exist:
				try {
					statement.execute(DBFunctions.createTable_EngineerPhoneNumber);
				} catch (SQLException e) {
					System.out.println("SQLException info:");
					System.out.println(e.getMessage());
				}
			}
			
			
			/* DevelopmentStages table */
			tables = dbm.getTables(null, null, "Development_Stages", null);
			if (!(tables.next())) {
				// table does not exist:
				try {
					statement.execute(DBFunctions.createTable_DevelopmentStages);
				} catch (SQLException e) {
					System.out.println("SQLException info:");
					System.out.println(e.getMessage());
				}
			}
			
			

			/* working-on relation table */
			tables = dbm.getTables(null, null, "working_on", null);
			if (!(tables.next())) {
				// table does not exist:
				try {
					statement.execute(DBFunctions.createRelationTable_WorkingOn);
				} catch (SQLException e) {
					System.out.println("SQLException info:");
					System.out.println(e.getMessage());
				}
			}

			/* WorkingAt relation table */
			tables = dbm.getTables(null, null, "working_at	", null);
			if (!(tables.next())) {
				// table does not exist:
				try {
					statement.execute(DBFunctions.createRelationTable_WorkingAt);
				} catch (SQLException e) {
					System.out.println("SQLException info:");
					System.out.println(e.getMessage());
				}
			}
			
			/* Grades table  with TRIGGER*/
			tables = dbm.getTables(null, null, "grades	", null);
			if (!(tables.next())) {
				// table does not exist:
				try {
					statement.execute(DBFunctions.createTable_Grades);
					statement.execute(DBFunctions.dropTrigger);
					statement.execute(DBFunctions.trigger_gradeMonth);
				} catch (SQLException e) {
					System.out.println("SQLException info:");
					System.out.println(e.getMessage());
				}
			}
			
			
			/* totalMunyOfProjects view table */
			tables = dbm.getTables(null, null, "totalMunyOfProjects", null);
			if (!(tables.next())) {
				// table does not exist:
				try {
					statement.execute(DBFunctions.createView_TotalMunyOfProjects);
				} catch (SQLException e) {
					System.out.println("SQLException info:");
					System.out.println(e.getMessage());
				}
			}
			
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} 
	} // end function

	public void closeConnection(){
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public PreparedStatement preparedStatment(String statment) {
		try {
			return connection.prepareStatement(statment);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Statement getStatement() throws SQLException{
		return connection.createStatement();
		}
	
	public PreparedStatement preparedStatmentForQuary(String stat){
		try {
			return connection.prepareStatement(stat);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	// methods:
	
	public Connection getConnection(){
		return connection;
	}
	
	// transaction
	public void autoCommitToggle() throws SQLException{
		commit = !commit;
		
		connection.setAutoCommit(commit);
	}
}



