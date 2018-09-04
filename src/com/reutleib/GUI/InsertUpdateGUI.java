package com.reutleib.GUI;

import com.reutlelib.softwareAreas.*;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Button;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class InsertUpdateGUI extends JFrame {

	private JPanel contentPane;
	// project details
	private JTextField txtProjectNumber;
	private JTextField txtProjectName;
	private JTextField txtCustomerName;
	private JTextField txtStartDate;
	private JTextField txtDescription;
	private JTextField txtDevelopmentTools;
	// engineer details
	private JTextField txtEngi;
	private JTextField txtFirstName;
	private JTextField txtLastName;
	private JTextField txtBirthday;
	private JTextField txtAge;
	private JTextField txtCity;
	private JTextField txtStreet;
	private JTextField txtStreetNumber;
	// software area details
	private JTextField txtAreaNumber;
	private JTextField txtAreaName;
	private JTextField txtExpertise;
	private JButton btnInsert;
	private JButton btnUpdate;

	private JButton btnInsertPhone;
	private JButton btnInsertDevelopmentStages;
	private JButton btnInsertMilestones;
	private JTextField txtAreaNumber_1;

	PreparedStatement preparedStmt = null;
	private JLabel lblExplanation;
	private JButton btnConnectionBetweenEngineer;
	private JButton btnInsertGrades;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InsertUpdateGUI frame = new InsertUpdateGUI();
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
	public InsertUpdateGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1202, 755);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnNewButton = new JButton("Back to menu");
		btnNewButton.addActionListener(new ActionListener() {
			// back to menu
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnNewButton.setBounds(1005, 16, 142, 40);
		contentPane.add(btnNewButton);

		txtProjectNumber = new JTextField();
		txtProjectNumber.setText("project number");
		txtProjectNumber.setBounds(15, 16, 146, 26);
		contentPane.add(txtProjectNumber);
		txtProjectNumber.setColumns(10);

		txtProjectName = new JTextField();
		txtProjectName.setText("project name");
		txtProjectName.setColumns(10);
		txtProjectName.setBounds(15, 50, 146, 26);
		contentPane.add(txtProjectName);

		txtCustomerName = new JTextField();
		txtCustomerName.setText("customer name ");
		txtCustomerName.setColumns(10);
		txtCustomerName.setBounds(15, 92, 146, 26);
		contentPane.add(txtCustomerName);

		txtStartDate = new JTextField();
		txtStartDate.setText("start date");
		txtStartDate.setColumns(10);
		txtStartDate.setBounds(15, 134, 146, 26);
		contentPane.add(txtStartDate);

		txtDescription = new JTextField();
		txtDescription.setText("description");
		txtDescription.setColumns(10);
		txtDescription.setBounds(15, 176, 238, 26);
		contentPane.add(txtDescription);

		txtDevelopmentTools = new JTextField();
		txtDevelopmentTools.setText("development tools");
		txtDevelopmentTools.setColumns(10);
		txtDevelopmentTools.setBounds(15, 216, 238, 26);
		contentPane.add(txtDevelopmentTools);

		txtEngi = new JTextField();
		txtEngi.setText("id");
		txtEngi.setColumns(10);
		txtEngi.setBounds(279, 16, 146, 26);
		contentPane.add(txtEngi);

		txtFirstName = new JTextField();
		txtFirstName.setText("first name");
		txtFirstName.setColumns(10);
		txtFirstName.setBounds(279, 50, 146, 26);
		contentPane.add(txtFirstName);

		txtLastName = new JTextField();
		txtLastName.setText("last name");
		txtLastName.setColumns(10);
		txtLastName.setBounds(279, 92, 146, 26);
		contentPane.add(txtLastName);

		txtBirthday = new JTextField();
		txtBirthday.setText("birthday");
		txtBirthday.setColumns(10);
		txtBirthday.setBounds(279, 134, 146, 26);
		contentPane.add(txtBirthday);

		txtAge = new JTextField();
		txtAge.setText("age");
		txtAge.setColumns(10);
		txtAge.setBounds(279, 176, 146, 26);
		contentPane.add(txtAge);

		txtCity = new JTextField();
		txtCity.setText("city");
		txtCity.setColumns(10);
		txtCity.setBounds(279, 216, 146, 26);
		contentPane.add(txtCity);

		txtStreet = new JTextField();
		txtStreet.setText("street");
		txtStreet.setColumns(10);
		txtStreet.setBounds(279, 255, 146, 26);
		contentPane.add(txtStreet);

		txtStreetNumber = new JTextField();
		txtStreetNumber.setText("street number");
		txtStreetNumber.setColumns(10);
		txtStreetNumber.setBounds(279, 297, 146, 26);
		contentPane.add(txtStreetNumber);

		JButton btnInsertProject = new JButton("update project");
		btnInsertProject.setBounds(15, 554, 142, 40);
		contentPane.add(btnInsertProject);
		btnInsertProject.setBackground(Color.GREEN);
		btnInsertProject.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				preparedStmt = ConnectionMng.getInstance().preparedStatment(DBFunctions.update_Project);
				try {
					preparedStmt.setInt(1, Integer.parseInt(txtProjectNumber.getText()));
					preparedStmt.setString(2, txtProjectName.getText());
					preparedStmt.setString(3, txtCustomerName.getText());
					preparedStmt.setString(4, txtStartDate.getText());
					preparedStmt.setString(5, txtDescription.getText());
					preparedStmt.setString(6, txtDevelopmentTools.getText());

					preparedStmt.setInt(7, Integer.parseInt(txtProjectNumber.getText()));

					preparedStmt.executeUpdate();
				} catch (Exception e2) {
					// TODO: handle exception
					System.out.println("exception from update_Project table!");
					e2.printStackTrace();
				}

			}
		});

		JButton btnInsertEnginner = new JButton("insert engineer");
		btnInsertEnginner.setBounds(279, 498, 142, 40);
		contentPane.add(btnInsertEnginner);
		btnInsertEnginner.setBackground(Color.GREEN);

		btnInsertEnginner.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				try {
					// start transaction
					ConnectionMng.getInstance().autoCommitToggle();

					Model.prepareEngineer(
							new Engineer(Integer.parseInt(txtEngi.getText()), txtFirstName.getText(),
									txtLastName.getText(), txtBirthday.getText(),
									Integer.parseInt(txtAge.getText()), txtCity.getText(), txtStreet.getText(),
									txtStreetNumber.getText()),
							ConnectionMng.getInstance().preparedStatment(DBFunctions.insert_Engineer)).execute();
					PreparedStatement stat = ConnectionMng.getInstance().preparedStatment(DBFunctions.quaryWorkingAt);
					
					try {
						
						stat.setInt(1, Integer.parseInt(txtAreaNumber_1.getText()));
						stat.setInt(2, Integer.parseInt(txtEngi.getText()));
						stat.execute();
					} catch (Exception e2) {
						// TODO: handle exception
						e2.printStackTrace();
					}
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

		JButton button = new JButton("insert project");
		button.setBounds(15, 488, 142, 40);
		contentPane.add(button);
		button.setBackground(Color.GREEN);
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					Model.prepareProject(
							new Project(Integer.parseInt(txtProjectNumber.getText()), txtProjectName.getText(),
									txtCustomerName.getText(), txtStartDate.getText(),
									txtDescription.getText(), "---"),
							ConnectionMng.getInstance().preparedStatment(DBFunctions.insert_Project)).execute();

				} catch (NumberFormatException | SQLException e) {
					// TODO Auto-generated catch block
					System.out.println("exception from insert_Project table!");
					e.printStackTrace();
				}
			}
		});
		

		JButton btnUpdateEngineer = new JButton("update engineer");
		btnUpdateEngineer.setBounds(279, 554, 157, 40);
		contentPane.add(btnUpdateEngineer);
		btnUpdateEngineer.setBackground(Color.GREEN);

		btnUpdateEngineer.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				try {
					preparedStmt = ConnectionMng.getInstance().preparedStatment(DBFunctions.update_Engineer);
					// update Engineer area
					if (normalValue(txtEngi.getText(), "id")) {

					}
					preparedStmt.setInt(1, Integer.parseInt(txtEngi.getText()));
					preparedStmt.setString(2, txtFirstName.getText());
					preparedStmt.setString(3, txtLastName.getText());
					preparedStmt.setString(4, txtBirthday.getText());
					preparedStmt.setInt(5, Integer.parseInt(txtAge.getText()));
					preparedStmt.setString(6, txtCity.getText());
					preparedStmt.setString(7, txtStreet.getText());
					preparedStmt.setString(8, txtStreetNumber.getText());
					preparedStmt.setInt(9, Integer.parseInt(txtEngi.getText()));

					preparedStmt.executeUpdate();

				} catch (Exception e2) {
					// TODO: handle exception
					System.out.println("exception from update_Engineer table!");
					e2.printStackTrace();
				}

			}
		});

		txtAreaNumber = new JTextField();
		txtAreaNumber.setText("area number");
		txtAreaNumber.setColumns(10);
		txtAreaNumber.setBounds(497, 16, 146, 26);
		contentPane.add(txtAreaNumber);

		txtAreaName = new JTextField();
		txtAreaName.setText("area name");
		txtAreaName.setColumns(10);
		txtAreaName.setBounds(497, 50, 146, 26);
		contentPane.add(txtAreaName);

		txtExpertise = new JTextField();
		txtExpertise.setText("expertise");
		txtExpertise.setColumns(10);
		txtExpertise.setBounds(497, 92, 146, 26);
		contentPane.add(txtExpertise);

		btnInsert = new JButton("insert software area");
		btnInsert.setBounds(501, 175, 171, 40);
		contentPane.add(btnInsert);
		btnInsert.setBackground(Color.GREEN);

		btnInsert.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					Model.prepareSoftWareArea(new SoftwareArea(Integer.parseInt(txtAreaNumber.getText()),
							txtAreaName.getText(), txtExpertise.getText()),

							ConnectionMng.getInstance().preparedStatment(DBFunctions.insert_SoftwareArea)).execute();
				} catch (Exception e2) {
					// TODO: handle exception
					System.out.println("exception from insert_SoftwareArea table!");
					e2.printStackTrace();
				}
			}
		});

		btnUpdate = new JButton("update software area");
		btnUpdate.setBounds(497, 241, 191, 40);
		contentPane.add(btnUpdate);
		btnUpdate.setBackground(Color.GREEN);

		btnInsertPhone = new JButton("insert phone");
		btnInsertPhone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PhonesNumber phone = new PhonesNumber();
				phone.setVisible(true);
			}
		}); // end addActionListener
		btnInsertPhone.setBounds(279, 414, 142, 40);
		contentPane.add(btnInsertPhone);

		btnInsertDevelopmentStages = new JButton("insert development stages");
		btnInsertDevelopmentStages.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DevelopmentStages insert = new DevelopmentStages();
				insert.setVisible(true);
			}
		});
		btnInsertDevelopmentStages.setBounds(15, 375, 217, 40);
		contentPane.add(btnInsertDevelopmentStages);

		btnInsertMilestones = new JButton("insert milestones");
		btnInsertMilestones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProjectMilestones insert = new ProjectMilestones();
				insert.setVisible(true);
			}
		});
		btnInsertMilestones.setBounds(15, 319, 164, 40);
		contentPane.add(btnInsertMilestones);

		txtAreaNumber_1 = new JTextField();
		txtAreaNumber_1.setText("area number");
		txtAreaNumber_1.setColumns(10);
		txtAreaNumber_1.setBounds(279, 353, 146, 26);
		contentPane.add(txtAreaNumber_1);
		
		lblExplanation = new JLabel("<html>  e x p l a n a t i o n ! <br><br>\r\n<b><u>\r\nProject:\r\n</b><br></u>\r\nAfter entering the project click on: 'insert milestones' and enter details. <br>\r\nand then click: 'insert development tools' and enter details. <br>\r\nThen back to the this menu<br>\r\n<br><b><u>\r\nengineer:\r\n</b><br></u>\r\nAfter entering the engineer click on: 'insert phone' <br>\r\nand enter phone by phone, then back to this menu. <br>\r\n<b><br><u>\r\nSoftware Area:\r\n</b><br></u>\r\nAfter you create both an 'Engineer' and a 'Software Area', you can associate the engineer with a software area by clicking: 'Connection between engineer and Software Area'.\r\n</html>");
		lblExplanation.setBounds(629, 308, 457, 313);
		contentPane.add(lblExplanation);
		
		btnConnectionBetweenEngineer = new JButton("<html> Connection between <br> engineer and Project </html>\r\n");
		btnConnectionBetweenEngineer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConnEngAndProject connEngSoft = new ConnEngAndProject();
				connEngSoft.setVisible(true);
			}
		});
		btnConnectionBetweenEngineer.setBounds(806, 107, 238, 63);
		contentPane.add(btnConnectionBetweenEngineer);
		
		btnInsertGrades = new JButton("insert grades");
		btnInsertGrades.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Grades grade = new Grades();
				grade.setVisible(true);
						
			}
		});
		btnInsertGrades.setBounds(853, 184, 157, 45);
		contentPane.add(btnInsertGrades);

		btnUpdate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				preparedStmt = ConnectionMng.getInstance().preparedStatment(DBFunctions.update_SoftwareArea);
				try {
					// update software area
					preparedStmt.setInt(1, Integer.parseInt(txtAreaNumber.getText()));
					preparedStmt.setString(2, txtAreaName.getText());
					preparedStmt.setString(3, txtExpertise.getText());
					preparedStmt.setInt(4, Integer.parseInt(txtAreaNumber.getText()));
					preparedStmt.executeUpdate();
				} catch (Exception e2) {
					// TODO: handle exception
					System.out.println("exception from update_SoftwareArea table!");
					e2.printStackTrace();
				}

			}
		});

		// -------------------------------------------------------------
		// Manipulation of JtextField

		txtProjectNumber.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {
				if (txtProjectNumber.getText().isEmpty()) {
					txtProjectNumber.setText("project number");
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				txtProjectNumber.setText("");
			}
		});

		txtProjectName.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {
				if (txtProjectName.getText().isEmpty()) {
					txtProjectName.setText("project name");
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				txtProjectName.setText("");
			}
		});

		txtCustomerName.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {
				if (txtCustomerName.getText().isEmpty()) {
					txtCustomerName.setText("customer name");
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				txtCustomerName.setText("");
			}
		});

		txtStartDate.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {
				if (txtStartDate.getText().isEmpty()) {
					txtStartDate.setText("start date");
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				txtStartDate.setText("");
			}
		});

		txtDescription.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {
				if (txtDescription.getText().isEmpty()) {
					txtDescription.setText("description");
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				txtDescription.setText("");
			}
		});

		txtDevelopmentTools.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {
				if (txtDevelopmentTools.getText().isEmpty()) {
					txtDevelopmentTools.setText("development tools");
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				txtDevelopmentTools.setText("");
			}
		});

		txtEngi.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {
				if (txtEngi.getText().isEmpty()) {
					txtEngi.setText("id");
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				txtEngi.setText("");
			}
		});

		txtFirstName.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {
				if (txtFirstName.getText().isEmpty()) {
					txtFirstName.setText("first name");
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				txtFirstName.setText("");
			}
		});

		txtLastName.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {
				if (txtLastName.getText().isEmpty()) {
					txtLastName.setText("last name");
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				txtLastName.setText("");
			}
		});

		txtBirthday.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {
				if (txtBirthday.getText().isEmpty()) {
					txtBirthday.setText("birthday");
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				txtBirthday.setText("");
			}
		});

		txtAge.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {
				if (txtAge.getText().isEmpty()) {
					txtAge.setText("age");
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				txtAge.setText("");
			}
		});

		txtCity.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {
				if (txtCity.getText().isEmpty()) {
					txtCity.setText("city");
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				txtCity.setText("");
			}
		});

		txtStreet.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {
				if (txtStreet.getText().isEmpty()) {
					txtStreet.setText("street");
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				txtStreet.setText("");
			}
		});

		txtStreetNumber.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {
				if (txtStreetNumber.getText().isEmpty()) {
					txtStreetNumber.setText("street number");
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				txtStreetNumber.setText("");
			}
		});

		txtAreaNumber.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {
				if (txtAreaNumber.getText().isEmpty()) {
					txtAreaNumber.setText("area number");
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				txtAreaNumber.setText("");
			}
		});

		txtAreaName.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {
				if (txtProjectNumber.getText().isEmpty()) {
					txtProjectNumber.setText("area name");
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				txtAreaName.setText("");
			}
		});

		txtExpertise.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {
				if (txtProjectNumber.getText().isEmpty()) {
					txtProjectNumber.setText("expertise");
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				txtExpertise.setText("");
			}
		});
		
		txtAreaNumber_1.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {
				if (txtAreaNumber_1.getText().isEmpty()) {
					txtAreaNumber_1.setText("street");
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				txtAreaNumber_1.setText("");
			}
		});

	} // end constructor

	// -------------------------------------------------------------
	// Functions

	public boolean normalValue(String txtField, String check) {

		if (txtField.equals(check))
			return true;
		return false;

	}



}
