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
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class Grades extends JFrame {

	private JPanel contentPane;
	private JTextField textProjectNumber;
	private JTextField txtEngineerId;
	private JButton btnDeletePhone;
	
	PreparedStatement preparedStatement = null;
	private JTextField txtGrade;
	
	PreparedStatement preparedStmt = null;
	private JLabel lblTheMonthIs;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Grades frame = new Grades();
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
	public Grades() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 519, 346);
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
		
		textProjectNumber = new JTextField();
		textProjectNumber.setText("project number");
		textProjectNumber.setColumns(10);
		textProjectNumber.setBounds(28, 23, 168, 26);
		contentPane.add(textProjectNumber);
		textProjectNumber.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {
				if (textProjectNumber.getText().isEmpty()) {
					textProjectNumber.setText("project number");
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				textProjectNumber.setText("");
			}
		});
		
		JButton insert_Phone = new JButton("insert grade");
		insert_Phone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				preparedStmt = ConnectionMng.getInstance().preparedStatment(DBFunctions.insert_grade);
				try {
					preparedStmt.setInt(1, Integer.parseInt(textProjectNumber.getText()));
					preparedStmt.setInt(2, Integer.parseInt(txtEngineerId.getText()));
					preparedStmt.setInt(3, Integer.parseInt(txtGrade.getText()));

					preparedStmt.execute();
				} catch (Exception e2) {
					// TODO: handle exception
					System.out.println("exception from update_Project table!");
					e2.printStackTrace();
				}
			
			}
		});
		insert_Phone.setBackground(Color.GREEN);
		insert_Phone.setBounds(28, 218, 142, 40);
		contentPane.add(insert_Phone);
		
		txtEngineerId = new JTextField();
		txtEngineerId.setText("engineer id");
		txtEngineerId.setColumns(10);
		txtEngineerId.setBounds(28, 61, 168, 26);
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
		
		btnDeletePhone = new JButton("update grade");
		btnDeletePhone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				preparedStmt = ConnectionMng.getInstance().preparedStatment(DBFunctions.update_grade);
				try {
					preparedStmt.setInt(1, Integer.parseInt(textProjectNumber.getText()));
					preparedStmt.setInt(2, Integer.parseInt(txtEngineerId.getText()));
					preparedStmt.setInt(3, Integer.parseInt(txtGrade.getText()));
					// where
					preparedStmt.setInt(5, Integer.parseInt(textProjectNumber.getText()));
					preparedStmt.setInt(6, Integer.parseInt(txtEngineerId.getText()));

					preparedStmt.execute();
				} catch (Exception e2) {
					// TODO: handle exception
					System.out.println("exception from update_Project table!");
					e2.printStackTrace();
				}
			}
		});
		btnDeletePhone.setBackground(Color.GREEN);
		btnDeletePhone.setBounds(241, 218, 142, 40);
		contentPane.add(btnDeletePhone);
		
		txtGrade = new JTextField();
		txtGrade.setText("grade");
		txtGrade.setColumns(10);
		txtGrade.setBounds(28, 103, 168, 26);
		contentPane.add(txtGrade);
		
		JLabel lblGradeInsertA = new JLabel("<html>\r\ngrade: <br>\r\nInsert a number from <br> 1 to 10<br>\r\n</html>");
		lblGradeInsertA.setBounds(211, 88, 202, 57);
		contentPane.add(lblGradeInsertA);
		
		lblTheMonthIs = new JLabel("<html>\r\nThe month is updated automatically!\r\n</html>");
		lblTheMonthIs.setBounds(28, 145, 168, 57);
		contentPane.add(lblTheMonthIs);
		
		txtGrade.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {
				if (txtGrade.getText().isEmpty()) {
					txtGrade.setText("grade");
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				txtGrade.setText("");
			}
		});
	}
}
