package com.reutlelib.softwareAreas;
import com.reutleib.GUI.*;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.Statement;
import java.util.ArrayList;



public class SoftwareAreasDemo {

	public static void main(String[] args) throws SQLException {
		
		ConnectionMng manager = ConnectionMng.getInstance();
		PreparedStatement preparedStmt = null;
		Statement statement = null;
		ResultSet result = null;
		ArrayList<Project> projects = new ArrayList<>();
		
		System.out.println(manager);
		
		// start GUI
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DBFinalProject window = new DBFinalProject();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}
	

}
