package com.reutleib.GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.reutlelib.softwareAreas.ConnectionMng;
import com.reutlelib.softwareAreas.DBFunctions;
import com.reutlelib.softwareAreas.Model;
import com.reutlelib.softwareAreas.Project;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class ProjectMilestones extends JFrame {

	private JPanel contentPane;
	private JTextField txtProjectMileNumber;
	private JTextField txtMileNumber;
	private JTextField txtdate;
	private JTextField txtAmountOfMany;
	private JTextField txtSubmission;
	private JButton btnBack;
	private JButton btnUpdateDevstages;
	private JButton btnInsertDevstages;
	
	PreparedStatement preparedStmt = null;
	private JButton btnDeleteMilestones;
	private JLabel lblForDeleteEnter;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProjectMilestones frame = new ProjectMilestones();
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
	public ProjectMilestones() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 680, 381);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtProjectMileNumber = new JTextField();
		txtProjectMileNumber.setText("project milestones number");
		txtProjectMileNumber.setColumns(10);
		txtProjectMileNumber.setBounds(26, 16, 217, 26);
		contentPane.add(txtProjectMileNumber);
		txtProjectMileNumber.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				if (txtProjectMileNumber.getText().isEmpty()) {
					txtProjectMileNumber.setText("project milestones number");
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				txtProjectMileNumber.setText("");
			}
		});
		
		txtMileNumber = new JTextField();
		txtMileNumber.setText("milestones number");
		txtMileNumber.setColumns(10);
		txtMileNumber.setBounds(26, 57, 146, 26);
		contentPane.add(txtMileNumber);
		txtMileNumber.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				if (txtMileNumber.getText().isEmpty()) {
					txtMileNumber.setText("milestones number");
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				txtMileNumber.setText("");
			}
		});
		
		txtdate = new JTextField();
		txtdate.setText("date");
		txtdate.setColumns(10);
		txtdate.setBounds(26, 99, 146, 26);
		contentPane.add(txtdate);
		txtdate.addFocusListener(new FocusListener() {
			
			
			@Override
			public void focusLost(FocusEvent e) {
				if (txtdate.getText().isEmpty()) {
					txtdate.setText("date");
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				txtdate.setText("");
			}
		});
		
		txtAmountOfMany = new JTextField();
		txtAmountOfMany.setText("amount of many");
		txtAmountOfMany.setColumns(10);
		txtAmountOfMany.setBounds(26, 183, 207, 26);
		contentPane.add(txtAmountOfMany);
		txtAmountOfMany.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				if (txtAmountOfMany.getText().isEmpty()) {
					txtAmountOfMany.setText("amount of many");
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				txtAmountOfMany.setText("");
			}
		});
		
		txtSubmission = new JTextField();
		txtSubmission.setText("submission");
		txtSubmission.setColumns(10);
		txtSubmission.setBounds(26, 141, 207, 26);
		contentPane.add(txtSubmission);
		txtSubmission.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {
				if (txtSubmission.getText().isEmpty()) {
					txtSubmission.setText("submission");
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				txtSubmission.setText("");
			}
		});
		
		btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			// back to menu
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnBack.setBounds(462, 26, 142, 40);
		contentPane.add(btnBack);
		
		btnUpdateDevstages = new JButton("update Milestones");
		btnUpdateDevstages.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				preparedStmt = ConnectionMng.getInstance().preparedStatment(DBFunctions.update_milestones);
				try {
					// update software area
					preparedStmt.setInt(1, Integer.parseInt(txtProjectMileNumber.getText()));
					preparedStmt.setInt(2, Integer.parseInt(txtMileNumber.getText()));
					preparedStmt.setDate(3, new Date(System.currentTimeMillis()));
					preparedStmt.setString(4, txtSubmission.getText());
					preparedStmt.setDouble(5, Double.parseDouble(txtAmountOfMany.getText()));
					preparedStmt.setInt(6, Integer.parseInt(txtProjectMileNumber.getText()));
					preparedStmt.setInt(7, Integer.parseInt(txtMileNumber.getText()));
					
					preparedStmt.executeUpdate();
				} catch (Exception e2) {
					// TODO: handle exception
					System.out.println("exception from update_milestones table!");
					e2.printStackTrace();
				}
			}
		});
		btnUpdateDevstages.setBackground(Color.GREEN);
		btnUpdateDevstages.setBounds(435, 233, 191, 40);
		contentPane.add(btnUpdateDevstages);
		
		btnInsertDevstages = new JButton("insert Milestones");
		btnInsertDevstages.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
								
				try {
					Model.prepareMilestones(new Project.ProjectMilestones(
							Integer.parseInt(txtProjectMileNumber.getText()), Integer.parseInt(txtMileNumber.getText()),
							txtdate.getText(),txtSubmission.getText(), Integer.parseInt(txtAmountOfMany.getText())), 	
							ConnectionMng.getInstance().preparedStatment(DBFunctions.insert_projectMilestones)).execute();
				} catch (NumberFormatException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnInsertDevstages.setBackground(Color.GREEN);
		btnInsertDevstages.setBounds(445, 159, 171, 40);
		contentPane.add(btnInsertDevstages);
		
		btnDeleteMilestones = new JButton("delete Milestones");
		btnDeleteMilestones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					
				preparedStmt =  ConnectionMng.getInstance().preparedStatment(DBFunctions.delete_milestonesTwo);
				try {
					preparedStmt.setInt(1,Integer.parseInt(txtProjectMileNumber.getText()));
					preparedStmt.setInt(2,Integer.parseInt(txtMileNumber.getText()));
					preparedStmt.execute();
				} catch (NumberFormatException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		btnDeleteMilestones.setBackground(Color.GREEN);
		btnDeleteMilestones.setBounds(235, 239, 171, 40);
		contentPane.add(btnDeleteMilestones);
		
		lblForDeleteEnter = new JLabel("<html>\r\nfor delete enter: <br>\r\n'project milestines number' <br>\r\n'milestones number'\r\n</html>");
		lblForDeleteEnter.setBounds(41, 243, 202, 57);
		contentPane.add(lblForDeleteEnter);
	}

}
