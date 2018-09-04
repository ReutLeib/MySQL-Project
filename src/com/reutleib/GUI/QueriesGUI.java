//package com.reutleib.GUI;
//import com.reutlelib.softwareAreas.*;
//
//import java.awt.BorderLayout;
//import java.awt.EventQueue;
//
//import javax.swing.*;
//import javax.swing.border.EmptyBorder;
//
//import java.awt.event.ActionListener;
//import java.sql.Connection;
//import java.awt.event.ActionEvent;
//import javax.sql.*;
//
//public class QueriesGUI extends JFrame {
//
//	private JPanel contentPane;
//
//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					QueriesGUI frame = new QueriesGUI();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
//
//	/**
//	 * Create the frame.
//	 */
//
//	public QueriesGUI() {
//		
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setBounds(100, 100, 1198, 582);
//		contentPane = new JPanel();
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//		setContentPane(contentPane);
//		
//		JButton btnBack = new JButton("Back");
//		btnBack.setBounds(1007, 62, 142, 40);
//		btnBack.addActionListener(new ActionListener() {
//			// back to menu 
//			public void actionPerformed(ActionEvent e) {
//				setVisible(false);
//			}
//		});
//		contentPane.setLayout(null);
//		contentPane.add(btnBack);
//		
//		JButton button_1 = new JButton("refresh");
//		button_1.setBounds(1010, 16, 127, 29);
//		contentPane.add(button_1);
//		
//		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
//		tabbedPane.setBounds(25, 71, 953, 412);
//		contentPane.add(tabbedPane);
//		
//		JPanel panel = new JPanel();
//		tabbedPane.addTab("עברית", null, panel, null);
//		
//		JButton btnShow = new JButton("show");
//		btnShow.addActionListener(new ActionListener() {
//			// SHOW
//			public void actionPerformed(ActionEvent e) {
//			}
//		});
//		btnShow.setBounds(1007, 137, 142, 40);
//		contentPane.add(btnShow);
//	}
//
//}
