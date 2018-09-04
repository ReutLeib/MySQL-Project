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
import com.reutlelib.softwareAreas.Project;

import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.TextArea;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class PhonesNumber extends JFrame {

	private JPanel contentPane;
	private JTextField textPhoneNumber;
	private JTextField txtEngineerId;
	private JButton btnDeletePhone;
	
	PreparedStatement preparedStatement = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PhonesNumber frame = new PhonesNumber();
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
	public PhonesNumber() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
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
		btnBack.setBounds(271, 16, 142, 40);
		contentPane.add(btnBack);
		
		textPhoneNumber = new JTextField();
		textPhoneNumber.setText("phone number");
		textPhoneNumber.setColumns(10);
		textPhoneNumber.setBounds(40, 89, 168, 26);
		contentPane.add(textPhoneNumber);
		textPhoneNumber.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {
				if (textPhoneNumber.getText().isEmpty()) {
					textPhoneNumber.setText("phone number");
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				textPhoneNumber.setText("");
			}
		});
		
		JButton insert_Phone = new JButton("insert phone");
		insert_Phone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Model.preparePhoneNumber(new Engineer.EngineerPhoneNumber(
							Integer.parseInt(txtEngineerId.getText()), Integer.parseInt(textPhoneNumber.getText())), 
							ConnectionMng.getInstance().preparedStatment(DBFunctions.insert_phoneNumber)).execute();
				} catch (NumberFormatException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		insert_Phone.setBackground(Color.GREEN);
		insert_Phone.setBounds(44, 156, 142, 40);
		contentPane.add(insert_Phone);
		
		txtEngineerId = new JTextField();
		txtEngineerId.setText("engineer id");
		txtEngineerId.setColumns(10);
		txtEngineerId.setBounds(40, 33, 168, 26);
		contentPane.add(txtEngineerId);
		txtEngineerId.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				if (txtEngineerId.getText().isEmpty()) {
					txtEngineerId.setText("engineer id");
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				txtEngineerId.setText("");
			}
		});
		
		btnDeletePhone = new JButton("delete phone");
		btnDeletePhone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// delete_phone
				try {
					preparedStatement =  ConnectionMng.getInstance().preparedStatment(DBFunctions.delete_phone);
					preparedStatement.setInt(1,Integer.parseInt(textPhoneNumber.getText()));
					
					preparedStatement.execute();
					
				} catch (SQLException e2) {
					// TODO: handle exception
					System.out.println("exception from delete_phone table!");
					e2.printStackTrace();
				}
			}
		});
		btnDeletePhone.setBackground(Color.GREEN);
		btnDeletePhone.setBounds(230, 156, 142, 40);
		contentPane.add(btnDeletePhone);
	}

}
