package com.reutleib.GUI;
import com.reutlelib.softwareAreas.*;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.print.Printable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import org.eclipse.wb.swing.FocusTraversalOnArray;

import java.awt.Component;
import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.JMenuBar;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

import java.awt.Panel;
import java.awt.Label;
import java.awt.Choice;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JLabel;

public class DBFinalProject {

	
	public JFrame frame;
	private JButton btnProjectTable;
	private JTable table;
	String[] tablesCB= {"","Projec table", "Engineer table", "SoftwareArea table"};
	JComboBox comboBox = new JComboBox(tablesCB);
	PreparedStatement preparedStat = null;
	ResultSet rs = null;
	
	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public DBFinalProject() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1124, 575);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		btnProjectTable = new JButton("INSERT \\ UPDATE");
		btnProjectTable.addActionListener(new ActionListener() {
			// INSERT !
			public void actionPerformed(ActionEvent arg0) {
				InsertUpdateGUI insert = new InsertUpdateGUI();
				insert.setVisible(true);
			}
		});
		btnProjectTable.setBounds(877, 84, 191, 29);
		frame.getContentPane().add(btnProjectTable);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener() {
			// DELETE !
			public void actionPerformed(ActionEvent arg0) {
				DeleteGUI delete = new DeleteGUI();
				delete.setVisible(true);
			}
		});
		btnDelete.setBounds(941, 144, 127, 29);
		frame.getContentPane().add(btnDelete);
		
		JButton btnQueiris = new JButton("QUERIES");
		btnQueiris.addActionListener(new ActionListener() {
			// QUERIES !
			public void actionPerformed(ActionEvent e) {
				Queries querie = new Queries();
				querie.setVisible(true);
			}
		});
		btnQueiris.setBounds(941, 251, 127, 29);
		frame.getContentPane().add(btnQueiris);
		
		JButton btnRefresh = new JButton("refresh");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnRefresh.setBounds(941, 28, 127, 29);
		frame.getContentPane().add(btnRefresh);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(54, 110, 768, 372);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == comboBox) {
					JComboBox cb = (JComboBox) e.getSource();
					String msg = (String) cb.getSelectedItem();
					switch (msg) {
					case "":
						break;
					case "Projec table":
						try {

							preparedStat = ConnectionMng.getInstance().preparedStatment(DBFunctions.selectFrom+"project");
							

							rs = preparedStat.executeQuery();
							System.out.println("Projects: ");
							System.out.println("__________");
							System.out.println("number projec \t project name \t customer name \t start date \t description \t development tools \t grade");
							while(rs.next()){
								
								System.out.printf("%-16d %-15s %-15s %-15s %-15s %-23s %-16d ",rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDate(4),rs.getString(5),rs.getString(6),rs.getInt(7));
								System.out.println("");
								
							}
							System.out.println("______________________________________________________________________________________________________________");
							
						} catch (NumberFormatException | SQLException e2) {
							// TODO Auto-generated catch block
							System.out.println("exception from insert_Project table!");
							e2.printStackTrace();
						}
						break;
					case "Engineer table":
						try {

							preparedStat = ConnectionMng.getInstance().preparedStatment(DBFunctions.selectFrom+"engineer");
							

							rs = preparedStat.executeQuery();
							System.out.println("Engineers: ");
							System.out.println("__________");
							System.out.println("engineer id \t first name \t last name \t birthday \t age \t city \t street \t number");
							while(rs.next()){
					
								System.out.printf("%-16d %-15s %-15s %-15s %-7d %-7s %-15s %-5d",rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDate(4),rs.getInt(5),rs.getString(6),rs.getString(7),rs.getInt(8));
								System.out.println("");
							}
							System.out.println("______________________________________________________________________________________________________________");
							
						} catch (NumberFormatException | SQLException e2) {
							// TODO Auto-generated catch block
							System.out.println("exception from insert_Project table!");
							e2.printStackTrace();
						}

						break;
					case "SoftwareArea table":
						try {

							preparedStat = ConnectionMng.getInstance().preparedStatment(DBFunctions.selectFrom+"software_area");
							

							rs = preparedStat.executeQuery();
							System.out.println("SoftwareArea: ");
							System.out.println("__________");
							System.out.println("area number \t name \t\t expertise \t");
							while(rs.next()){
								System.out.printf("%-16d %-15s %-15s",rs.getInt(1),rs.getString(2),rs.getString(3));
								System.out.println("");
								}
							System.out.println("_________________________________________");
							
						} catch (NumberFormatException | SQLException e2) {
							// TODO Auto-generated catch block
							System.out.println("exception from insert_Project table!");
							e2.printStackTrace();
						}

						break;
					default:
						break;
					}}
			}
		});
		comboBox.setBounds(349, 59, 179, 35);
		frame.getContentPane().add(comboBox);
		
		JLabel lblChooseWhichTable = new JLabel("<html><b><h2>\r\nChoose which table  <br>\r\nyou'd like to view: </html>");
		lblChooseWhichTable.setBounds(169, 24, 202, 57);
		frame.getContentPane().add(lblChooseWhichTable);
		frame.getContentPane().setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{btnProjectTable}));
	
		
		frame.addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent arg0) {
				// TODO Auto-generated method stub
				ConnectionMng.getInstance().initiolazingConnection();
				
			}
			
			@Override
			public void windowIconified(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeiconified(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeactivated(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowClosing(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowClosed(WindowEvent arg0) {
				// TODO Auto-generated method stub
				// close connection
				ConnectionMng.getInstance().closeConnection();
				
			}
			
			@Override
			public void windowActivated(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		}); 
	}
}

