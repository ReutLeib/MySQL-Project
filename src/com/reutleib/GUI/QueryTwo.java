package com.reutleib.GUI;
import com.reutlelib.softwareAreas.*;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.sql.*;

public class QueryTwo extends JFrame {

	private JPanel contentPane;
	private JTextField txtProject;
	
	PreparedStatement preparedStat = null;
	ResultSet rs = null;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Queries frame = new Queries();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public void fillCombpBox(){
		try {
			String quary = "SELECT `project_name` FROM `db_reutleib`.`project`;";
			PreparedStatement prepareStatment = ConnectionMng.getInstance().preparedStatment(quary);
			ResultSet rs = prepareStatment.executeQuery();
			
			while(rs.next()){
				
				
			}
				
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

	public QueryTwo() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 308);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(248, 16, 142, 40);
		btnBack.addActionListener(new ActionListener() {
			// back to menu 
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnBack);
		
		JButton btnShow = new JButton("show");
		btnShow.addActionListener(new ActionListener() {
			// SHOW
			public void actionPerformed(ActionEvent e) {
				
					try {

						preparedStat = ConnectionMng.getInstance().preparedStatment(DBFunctions.query_fatchProjectEngineersByArea);
						preparedStat.setInt(1, Integer.parseInt(txtProject.getText()));
						
						rs = preparedStat.executeQuery();
						System.out.println("QUERY: ");
						System.out.println("For a particular project - who are the engineers working in it");
						System.out.println("______________________________________________________________");
						System.out.println("number area\t engineer id");
						while(rs.next()){
							
							System.out.println(rs.getInt(1) +"\t\t\t"+ rs.getString(2));
						}
						System.out.println("______________________________________________________________");
					} catch (NumberFormatException | SQLException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
				}
			
		});
		btnShow.setBounds(84, 128, 142, 40);
		contentPane.add(btnShow);
		
		txtProject = new JTextField();
		txtProject.setText("project number");
		txtProject.setColumns(10);
		txtProject.setBounds(84, 68, 146, 26);
		contentPane.add(txtProject);
		
		
		txtProject.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {
				if (txtProject.getText().isEmpty()) {
					txtProject.setText("project number");
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				txtProject.setText("");
			}
		});
	}



}
