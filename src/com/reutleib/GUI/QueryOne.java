package com.reutleib.GUI;

import com.reutlelib.softwareAreas.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.sql.*;

public class QueryOne extends JFrame {

	String[] namesForComboBox = { "planing", "Task management", "Configuration management", "Requirements Management",
			"design", "Unit tests", "encoding", "Software testing" };

	private JPanel contentPane;
	private JTextField txtStageName;
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

	public QueryOne() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 489, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JButton btnBack = new JButton("Back");
		btnBack.setBounds(236, 10, 142, 40);
		btnBack.addActionListener(new ActionListener() {
			// back to menu
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnBack);

		JButton button_1 = new JButton("refresh");
		button_1.setBounds(1103, 16, 127, 29);
		contentPane.add(button_1);

		JButton btnShow = new JButton("show");
		btnShow.setBounds(36, 134, 142, 40);
		btnShow.addActionListener(new ActionListener() {
			// SHOW
			public void actionPerformed(ActionEvent e) {
				
				preparedStat = ConnectionMng.getInstance().preparedStatment(DBFunctions.query_toolsAtCompany);
				try {
					preparedStat.setString(1, txtStageName.getText());
					rs = preparedStat.executeQuery();
					
					System.out.println("QUERY: ");
					System.out.println("For a particular development stage");
					System.out.println("which development tools are used by the company");
					System.out.println("and in which project:");
					System.out.println("______________________________________________________________");
					System.out.println("project number\t project name\t stage name\t tools");
					
					while(rs.next()){
						System.out.println(rs.getInt(1) +"||\t\t"+ rs.getString(2) + "||\t\t"+ rs.getString(3) + "||\t" +rs.getString(4));
					}
					
				} catch (NumberFormatException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		contentPane.add(btnShow);
		
		txtStageName = new JTextField();
		txtStageName.setText("stage name");
		txtStageName.setColumns(10);
		txtStageName.setBounds(36, 67, 146, 26);
		contentPane.add(txtStageName);
		
		JLabel label = new JLabel("<html>\r\n<u> stage name </u>\r\n<br>you can enter: <br>\r\n'planing' OR <br> 'task_managment' OR <br>\r\n'Configuration Management' OR <br>\r\nrequirements OR <br>\r\n'design' OR <br>\r\nencoding OR <br>\r\n'unit tests' OR <br> 'software testing' <br>\r\n</html>");
		label.setBounds(197, 66, 251, 205);
		contentPane.add(label);

	}

//	public void actionPerformed(ActionEvent a) {
//		if (a.getSource() == comboBox) {
//			JComboBox cb = (JComboBox) a.getSource();
//			String msg = (String) cb.getSelectedItem();
//			switch (msg) {
//			case "planing":
//				System.out.println("YAAAAA");
//				contentPane.setToolTipText("TAAAA");
//				break;
//			case "Task management":
//				System.out.println("YAAAAA");
//				contentPane.setToolTipText("TAAAA");
//				break;
//			case "Configuration management":
//
//				break;
//			case "Requirements Management":
//
//				break;
//			case "design":
//
//				break;
//			case "Unit tests":
//
//				break;
//			case "encoding":
//
//				break;
//			case "Software testing":
//
//				break;
//
//			default:
//				System.out.println("YAAAAA");
//				contentPane.setToolTipText("TAAAA");
//				break;
//			}
//		}
//
//	}
}
