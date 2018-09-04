package com.reutleib.GUI;
import com.reutlelib.softwareAreas.*;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class DeleteGUI extends JFrame {

	private JPanel contentPane;
	private JTextField txtInsert;
	private JTextField txtEngineerId;
	private JTextField txtAreaNumber;
	PreparedStatement preparedStmt = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteGUI frame = new DeleteGUI();
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
	public DeleteGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			// back to menu 
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnNewButton.setBounds(548, 32, 154, 44);
		contentPane.add(btnNewButton);
		
		txtInsert = new JTextField();
		txtInsert.setText("project number");
		txtInsert.setColumns(10);
		txtInsert.setBounds(29, 41, 181, 26);
		contentPane.add(txtInsert);
		
		txtEngineerId = new JTextField();
		txtEngineerId.setText("engineer id");
		txtEngineerId.setColumns(10);
		txtEngineerId.setBounds(263, 41, 181, 26);
		contentPane.add(txtEngineerId);
		
		JButton btnDeleteProject = new JButton("delete project");
		btnDeleteProject.setBounds(42, 101, 154, 44);
		contentPane.add(btnDeleteProject);
		btnDeleteProject.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					// start transaction
					ConnectionMng.getInstance().autoCommitToggle();
					
					preparedStmt = ConnectionMng.getInstance().preparedStatment(DBFunctions.delete_workingOn);
					preparedStmt.setInt(1, Integer.parseInt(txtInsert.getText()));
					preparedStmt.execute();
					
					preparedStmt = ConnectionMng.getInstance().preparedStatment(DBFunctions.delete_milestonesOne);
					preparedStmt.setInt(1, Integer.parseInt(txtInsert.getText()));
					preparedStmt.execute();
					
					preparedStmt = ConnectionMng.getInstance().preparedStatment(DBFunctions.delete_DevelopmentStagesOne);
					preparedStmt.setInt(1, Integer.parseInt(txtInsert.getText()));
					preparedStmt.execute();
					
					preparedStmt =  ConnectionMng.getInstance().preparedStatment(DBFunctions.delete_Project);
					// delete data from Project table
					preparedStmt.setInt(1,Integer.parseInt(txtInsert.getText()));
					preparedStmt.execute();
					
					ConnectionMng.getInstance().getConnection().commit();
					
				} catch (SQLException e) {
					// TODO: handle exception
					try {
						ConnectionMng.getInstance().getConnection().rollback();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					System.out.println("exception from delete_Project table!");
					e.printStackTrace();
				} finally {
					try {
						// end transaction
						ConnectionMng.getInstance().autoCommitToggle();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		
		JButton btnDeleteEngineer = new JButton("delete engineer");
		btnDeleteEngineer.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				try {
					// start transaction
					ConnectionMng.getInstance().autoCommitToggle();
					
					preparedStmt = ConnectionMng.getInstance().preparedStatment(DBFunctions.delete_workingAt);
					preparedStmt.setInt(1, Integer.parseInt(txtEngineerId.getText()));
					preparedStmt.execute();
					
					preparedStmt = ConnectionMng.getInstance().preparedStatment(DBFunctions.delete_workingOn);
					preparedStmt.setInt(1, Integer.parseInt(txtEngineerId.getText()));
					preparedStmt.execute();
					
					preparedStmt = ConnectionMng.getInstance().preparedStatment(DBFunctions.delete_phoneById);
					preparedStmt.setInt(1, Integer.parseInt(txtEngineerId.getText()));
					preparedStmt.execute();
					
					preparedStmt = ConnectionMng.getInstance().preparedStatment(DBFunctions.delete_Engineer);
					preparedStmt.setInt(1, Integer.parseInt(txtEngineerId.getText()));
					preparedStmt.execute();
										
					ConnectionMng.getInstance().getConnection().commit();

				} catch (Exception e2) {
					// TODO: handle exception
					try {
						ConnectionMng.getInstance().getConnection().rollback();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

					System.out.println("exception from insert_engineer table!");
					e2.printStackTrace();
				} finally {
					try {
						// end transaction
						ConnectionMng.getInstance().autoCommitToggle();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		btnDeleteEngineer.setBounds(276, 101, 154, 44);
		contentPane.add(btnDeleteEngineer);
		
		txtAreaNumber = new JTextField();
		txtAreaNumber.setText("area number");
		txtAreaNumber.setColumns(10);
		txtAreaNumber.setBounds(147, 286, 181, 26);
		contentPane.add(txtAreaNumber);
		
		JButton btnDeleteSoftwareArea = new JButton("delete software area");
		btnDeleteSoftwareArea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					// start transaction
					ConnectionMng.getInstance().autoCommitToggle();
					
					preparedStmt = ConnectionMng.getInstance().preparedStatment(DBFunctions.delete_byArea_workingAt);
					preparedStmt.setInt(1, Integer.parseInt(txtAreaNumber.getText()));
					preparedStmt.execute();
					
					preparedStmt =  ConnectionMng.getInstance().preparedStatment(DBFunctions.delete_SoftwareArea);
					preparedStmt.setInt(1,Integer.parseInt(txtAreaNumber.getText()));
					preparedStmt.execute();
					
					ConnectionMng.getInstance().getConnection().commit();
					
				} catch (SQLException e2) {
					// TODO: handle exception
					try {
						ConnectionMng.getInstance().getConnection().rollback();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					System.out.println("exception from delete_Project table!");
					e2.printStackTrace();
				} finally {
					try {
						// end transaction
						ConnectionMng.getInstance().autoCommitToggle();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		
		btnDeleteSoftwareArea.setBounds(130, 343, 212, 44);
		contentPane.add(btnDeleteSoftwareArea);
		
		// project
		txtInsert.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				if(txtInsert.getText().isEmpty()){
					txtInsert.setText("project number");
				}
			}
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				txtInsert.setText("");
				
			}
		});
		
		// Engineer 
		txtEngineerId.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				if(txtEngineerId.getText().isEmpty()){
					txtEngineerId.setText("engineer id");
				}			
			}
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				txtEngineerId.setText("");
			}
		});

		// software area
		txtAreaNumber.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				if(txtAreaNumber.getText().isEmpty()){
					txtAreaNumber.setText("area number");
				}	
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				txtAreaNumber.setText("");
			}
		});
	}
}
