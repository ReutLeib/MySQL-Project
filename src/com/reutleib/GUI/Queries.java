package com.reutleib.GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.reutlelib.softwareAreas.ConnectionMng;
import com.reutlelib.softwareAreas.DBFunctions;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Queries extends JFrame {

	private JPanel contentPane;
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
	public Queries() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 756, 507);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnBack.setBounds(552, 29, 154, 44);
		contentPane.add(btnBack);
		
		JButton btnForAParticular = new JButton("<html>\r\nFor a particular development stage - <br>\r\nwhich development tools are used by the company<br> \r\nand in which project\r\n</html>");
		btnForAParticular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QueryOne one = new QueryOne();
				one.setVisible(true);
			}
		});
		btnForAParticular.setBounds(48, 76, 401, 69);
		contentPane.add(btnForAParticular);
		
		JLabel lblSelectQuery = new JLabel("<html>\r\n<u><b>\r\nSelect Query :\r\n</u>\r\n</html>");
		lblSelectQuery.setBounds(48, 16, 174, 44);
		contentPane.add(lblSelectQuery);
		
		JButton btnForAParticular_1 = new JButton("<html>\r\nFor a particular project - <br> \r\nwho are the engineers working in it\r\n</html>");
		btnForAParticular_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QueryTwo two = new QueryTwo();
				two.setVisible(true);
			}
		});
		btnForAParticular_1.setBounds(48, 161, 283, 49);
		contentPane.add(btnForAParticular_1);
		
		JButton btnWhoAreThe = new JButton("<html>\r\nWho are the three most interesting projects<br>\r\nand who are the three least interesting\r\n</html>");
		btnWhoAreThe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				// The 3 most interesting projects:
				preparedStat = ConnectionMng.getInstance().preparedStatment(DBFunctions.project_threeMostInterested);
				try {
					rs = preparedStat.executeQuery();
					System.out.println("The 3 most interesting projects:");
					System.out.printf("%-16s %-15s %-15s ","project number","project name","total muny");
					System.out.println("");
					while(rs.next()){
						//System.out.println(rs.getInt(1) +"\t\t"+ rs.getString(2) +"\t\t"+ rs.getInt(3));
						System.out.printf("%-16d %-15s %-15s ",rs.getInt(1),rs.getString(2),rs.getInt(3));
						System.out.println("");
					}
					System.out.println("____________________________________________\n\n");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				// The 3 least interesting projects:
				preparedStat = ConnectionMng.getInstance().preparedStatment(DBFunctions.project_threeLastInterested);
				try {
					rs = preparedStat.executeQuery();
					System.out.println("The 3 least interesting projects:");
					System.out.printf("%-16s %-15s %-15s ","project number","project name","total muny");
					System.out.println("");
					while(rs.next()){
						//System.out.println(rs.getInt(1) +"\t\t"+ rs.getString(2) +"\t\t"+ rs.getInt(3));
						System.out.printf("%-16d %-15s %-15s ",rs.getInt(1),rs.getString(2),rs.getInt(3));
						System.out.println("");
					}
					System.out.println("____________________________________________\n\n");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		btnWhoAreThe.setBounds(48, 226, 344, 56);
		contentPane.add(btnWhoAreThe);
		
		JButton btnWhatAreThe = new JButton("<html>\r\nWhat are the expected milestones in the coming month<br>\r\nand how much money should be received\r\n</html>");
		btnWhatAreThe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//The expected milestones in the coming month:
				preparedStat = ConnectionMng.getInstance().preparedStatment(DBFunctions.milestones_totalMunyAndSubmission);
				try {
					rs = preparedStat.executeQuery();
					System.out.println("The expected milestones in the coming month:");
					System.out.printf("%-16s %-15s","submossion","amount of muny");
					System.out.println("");
					while(rs.next()){
						//System.out.println(rs.getInt(1) +"\t\t"+ rs.getString(2) +"\t\t"+ rs.getInt(3));
						System.out.printf("%-16s %-15d",rs.getString(1),rs.getInt(2));
						System.out.println("");
					}
					System.out.println("__________________________________\n\n");
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				//how much muny should be received:
				preparedStat = ConnectionMng.getInstance().preparedStatment(DBFunctions.milestones_totalMuny);
				try {
					rs = preparedStat.executeQuery();
					System.out.println("The total muny should be received:");
					while(rs.next()){
						System.out.println(rs.getString(1));
					}
					System.out.println("__________________________________\n\n");
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnWhatAreThe.setBounds(48, 298, 423, 56);
		contentPane.add(btnWhatAreThe);
		
		JButton btnTheBusyEngineers = new JButton("<html>\r\nThe busy engineers - <br>\r\nWhat are the names of engineers working on all projects\r\n</html>");
		btnTheBusyEngineers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				preparedStat = ConnectionMng.getInstance().preparedStatment(DBFunctions.query_busyEngineers);
				try {
					rs = preparedStat.executeQuery();
					System.out.println("The busy engineers -");
					System.out.printf("%-16s %-15s %-15s\n","engineer id","first name", "last name");
					
					while(rs.next()){
						System.out.printf("%-16d %-15s %-15s",rs.getInt(1),rs.getString(2),rs.getString(3));
						System.out.println("");
					}
					System.out.println("__________________________________________\n\n");
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
								
			}
		});
		btnTheBusyEngineers.setBounds(48, 370, 438, 56);
		contentPane.add(btnTheBusyEngineers);
	}

}
