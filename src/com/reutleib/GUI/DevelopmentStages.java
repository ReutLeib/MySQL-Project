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

public class DevelopmentStages extends JFrame {

	private JPanel contentPane;
	private JTextField txtProjectStageNumber;
	private JTextField txtStageName;
	private JTextField txtTools;
	private JButton btnBack;
	private JButton btnUpdateDevstages;
	private JButton btnInsertDevstages;

	PreparedStatement preparedStmt = null;
	private JButton btnDeleteDevstages;
	private JLabel lblForDeleteEnter;
	private JLabel lblStageName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DevelopmentStages frame = new DevelopmentStages();
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
	public DevelopmentStages() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 737, 381);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		txtProjectStageNumber = new JTextField();
		txtProjectStageNumber.setText("project stage number");
		txtProjectStageNumber.setColumns(10);
		txtProjectStageNumber.setBounds(26, 16, 171, 26);
		contentPane.add(txtProjectStageNumber);
		txtProjectStageNumber.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				if (txtProjectStageNumber.getText().isEmpty()) {
					txtProjectStageNumber.setText("project stage number");
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				txtProjectStageNumber.setText("");
			}
		});

		txtStageName = new JTextField();
		txtStageName.setText("stage name");
		txtStageName.setColumns(10);
		txtStageName.setBounds(26, 57, 146, 26);
		contentPane.add(txtStageName);
		txtStageName.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				if (txtStageName.getText().isEmpty()) {
					txtStageName.setText("stage name");
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				txtStageName.setText("");
			}
		});

		txtTools = new JTextField();
		txtTools.setText("tools");
		txtTools.setColumns(10);
		txtTools.setBounds(26, 99, 208, 26);
		contentPane.add(txtTools);
		txtTools.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				if (txtTools.getText().isEmpty()) {
					txtTools.setText("tools");
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				txtTools.setText("");
			}
		});

		btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnBack.setBounds(558, 16, 142, 40);
		contentPane.add(btnBack);

		btnUpdateDevstages = new JButton("update dev_stages");
		btnUpdateDevstages.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				preparedStmt = ConnectionMng.getInstance().preparedStatment(DBFunctions.update_DevelopmentStages);
				try {

					preparedStmt.setInt(1, Integer.parseInt(txtProjectStageNumber.getText()));
					preparedStmt.setString(2, txtStageName.getText());
					preparedStmt.setString(3, txtTools.getText());
					preparedStmt.setInt(4, Integer.parseInt(txtProjectStageNumber.getText()));
					// parseQuerySoftwareArea("area name","expertise");
					preparedStmt.executeUpdate();
				} catch (Exception e2) {
					// TODO: handle exception
					System.out.println("exception from update_SoftwareArea table!");
					e2.printStackTrace();
				}
			}
		});
		btnUpdateDevstages.setBackground(Color.GREEN);
		btnUpdateDevstages.setBounds(240, 167, 191, 40);
		contentPane.add(btnUpdateDevstages);

		btnInsertDevstages = new JButton("insert dev_stages");
		btnInsertDevstages.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					Model.prepareDevelopmentStages(
							new Project.DevelopmentStages(Integer.parseInt(txtProjectStageNumber.getText()),
									txtStageName.getText(), txtTools.getText()), 
							ConnectionMng.getInstance().preparedStatment(DBFunctions.insert_DevelopmentStages)).execute();

				} catch (Exception e2) {
					// TODO: handle exception
					System.out.println("exception from insert_developmentTools table!");
					e2.printStackTrace();
				}

			}
		});
		btnInsertDevstages.setBackground(Color.GREEN);
		btnInsertDevstages.setBounds(249, 92, 171, 40);
		contentPane.add(btnInsertDevstages);

		btnDeleteDevstages = new JButton("delete dev_stages");
		btnDeleteDevstages.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				preparedStmt = ConnectionMng.getInstance().preparedStatment(DBFunctions.delete_DevelopmentStagesOne);
				try {
					preparedStmt.setInt(1, Integer.parseInt(txtProjectStageNumber.getText()));
//					preparedStmt.setInt(2, Integer.parseInt(txtStageName.getText()));
					preparedStmt.execute();
				} catch (NumberFormatException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnDeleteDevstages.setBackground(Color.GREEN);
		btnDeleteDevstages.setBounds(249, 255, 171, 40);
		contentPane.add(btnDeleteDevstages);

		lblForDeleteEnter = new JLabel("<html>\r\nfor delete enter: <br>\r\n'project stage number' <br>\r\n</html>");
		lblForDeleteEnter.setBounds(72, 252, 202, 57);
		contentPane.add(lblForDeleteEnter);

		lblStageName = new JLabel(
				"<html>\r\n<u> stage name </u>\r\n<br>you can enter: <br>\r\n'planing' OR <br> 'task_managment' OR <br>\r\n'Configuration Management' OR <br>\r\nrequirements OR <br>\r\n'design' OR <br>\r\nencoding OR <br>\r\n'unit tests' OR <br> 'software testing' <br>\r\n</html>");
		lblStageName.setBounds(449, 72, 251, 205);
		contentPane.add(lblStageName);
	}

}
