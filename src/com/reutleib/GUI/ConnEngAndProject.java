package com.reutleib.GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.reutlelib.softwareAreas.ConnectionMng;
import com.reutlelib.softwareAreas.DBFunctions;
import com.reutlelib.softwareAreas.Engineer;
import com.reutlelib.softwareAreas.Model;

import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

// TABLE NAME 'working at'
public class ConnEngAndProject extends JFrame {

	private JPanel contentPane;
	private JTextField txtNumProject;
	private JTextField txtEngID;
	private JButton btnInsertConnection;
	public static Integer numProject = 0;
	public static Integer engID = 0;
	
	PreparedStatement preparedStatement = null;
	private JButton btnDeleteConnection;
	private JTextField txtMoveToProject;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConnEngAndProject frame = new ConnEngAndProject();
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
	public ConnEngAndProject() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 637, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton button = new JButton("Back");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		button.setBounds(458, 16, 142, 40);
		contentPane.add(button);

		txtNumProject = new JTextField();
		txtNumProject.setText("number project");
		txtNumProject.setColumns(10);
		txtNumProject.setBounds(27, 23, 168, 26);
		contentPane.add(txtNumProject);

		txtEngID = new JTextField();
		txtEngID.setText("engineer id");
		txtEngID.setColumns(10);
		txtEngID.setBounds(27, 65, 168, 26);
		contentPane.add(txtEngID);

		btnInsertConnection = new JButton("insert connection");
		btnInsertConnection.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numProject = Integer.parseInt(txtNumProject.getText()); 
				engID = Integer.parseInt( txtEngID.getText());
				
				preparedStatement = ConnectionMng.getInstance().preparedStatment(DBFunctions.quaryWorkingOn);
				
				try {
					preparedStatement.setInt(1, Integer.parseInt(txtNumProject.getText()));
					preparedStatement.setInt(2, Integer.parseInt(txtEngID.getText()));
					preparedStatement.execute();
					
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
				
			}
		});
		btnInsertConnection.setBackground(Color.GREEN);
		btnInsertConnection.setBounds(27, 127, 155, 40);
		contentPane.add(btnInsertConnection);
		
		btnDeleteConnection = new JButton("delete connection?");
		btnDeleteConnection.setBackground(Color.GREEN);
		btnDeleteConnection.setBounds(27, 188, 168, 40);
		contentPane.add(btnDeleteConnection);
		
		JButton btnUpdateConnection = new JButton("update connection");
		btnUpdateConnection.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					preparedStatement = ConnectionMng.getInstance().preparedStatment(DBFunctions.update_workingOn);
					
					preparedStatement.setInt(1, Integer.parseInt(txtMoveToProject.getText()));
					preparedStatement.setInt(2, Integer.parseInt(txtEngID.getText()));
					preparedStatement.setInt(3, Integer.parseInt(txtNumProject.getText()));
					preparedStatement.setInt(4, Integer.parseInt(txtEngID.getText()));


					preparedStatement.executeUpdate();

				} catch (Exception e2) {
					// TODO: handle exception
					System.out.println("exception from update_Engineer table!");
					e2.printStackTrace();
				}
			}
		});
		btnUpdateConnection.setBackground(Color.GREEN);
		btnUpdateConnection.setBounds(399, 169, 179, 40);
		contentPane.add(btnUpdateConnection);
		
		txtMoveToProject = new JTextField();
		txtMoveToProject.setText("move to project number");
		txtMoveToProject.setColumns(10);
		txtMoveToProject.setBounds(379, 127, 199, 26);
		contentPane.add(txtMoveToProject);
		
		
		txtNumProject.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				if (txtNumProject.getText().isEmpty()) {
					txtNumProject.setText("number project");
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				txtNumProject.setText("");
			}
		});
		
		txtEngID.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				if (txtEngID.getText().isEmpty()) {
					txtEngID.setText("engineer id");
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				txtEngID.setText("");
			}
		});
	
		txtMoveToProject.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				if (txtMoveToProject.getText().isEmpty()) {
					txtMoveToProject.setText("move to project number");
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				txtMoveToProject.setText("");
			}
		});
	}
	
	

	public Integer getnumProject() {
		return numProject;
	}

	public Integer getengID() {
		return engID;
	}
}
