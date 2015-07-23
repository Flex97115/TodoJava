package com.supinfo.suptodo.vue;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;

import javax.swing.JTextField;

import java.awt.Insets;

import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import com.supinfo.suptodo.element.User;
import com.supinfo.suptodo.model.JdbcUser;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class addUserVue extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField loginTextField;
	private JTextField passwordTextField;

	/**
	 * Create the frame.
	 */
	public addUserVue() {
		setTitle("SupTodo");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 300, 230);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 67, 35, 97, 93, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 36, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 0.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblAddUser = new JLabel("Add user");
		GridBagConstraints gbc_lblAddUser = new GridBagConstraints();
		gbc_lblAddUser.gridwidth = 2;
		gbc_lblAddUser.insets = new Insets(0, 0, 5, 5);
		gbc_lblAddUser.gridx = 2;
		gbc_lblAddUser.gridy = 0;
		contentPane.add(lblAddUser, gbc_lblAddUser);
		
		JLabel lblLogin = new JLabel("Login :");
		lblLogin.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblLogin = new GridBagConstraints();
		gbc_lblLogin.anchor = GridBagConstraints.EAST;
		gbc_lblLogin.insets = new Insets(0, 0, 5, 5);
		gbc_lblLogin.gridx = 1;
		gbc_lblLogin.gridy = 2;
		contentPane.add(lblLogin, gbc_lblLogin);
		
		loginTextField = new JTextField();
		GridBagConstraints gbc_loginTextField = new GridBagConstraints();
		gbc_loginTextField.gridwidth = 2;
		gbc_loginTextField.insets = new Insets(0, 0, 5, 5);
		gbc_loginTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_loginTextField.gridx = 3;
		gbc_loginTextField.gridy = 2;
		contentPane.add(loginTextField, gbc_loginTextField);
		loginTextField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password :");
		lblPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblPassword = new GridBagConstraints();
		gbc_lblPassword.anchor = GridBagConstraints.EAST;
		gbc_lblPassword.insets = new Insets(0, 0, 5, 5);
		gbc_lblPassword.gridx = 1;
		gbc_lblPassword.gridy = 3;
		contentPane.add(lblPassword, gbc_lblPassword);
		
		passwordTextField = new JTextField();
		GridBagConstraints gbc_passwordTextField = new GridBagConstraints();
		gbc_passwordTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordTextField.gridwidth = 2;
		gbc_passwordTextField.insets = new Insets(0, 0, 5, 5);
		gbc_passwordTextField.gridx = 3;
		gbc_passwordTextField.gridy = 3;
		contentPane.add(passwordTextField, gbc_passwordTextField);
		passwordTextField.setColumns(10);
		
		JLabel lblAdmin = new JLabel("Admin :");
		lblAdmin.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblAdmin = new GridBagConstraints();
		gbc_lblAdmin.anchor = GridBagConstraints.EAST;
		gbc_lblAdmin.insets = new Insets(0, 0, 5, 5);
		gbc_lblAdmin.gridx = 1;
		gbc_lblAdmin.gridy = 4;
		contentPane.add(lblAdmin, gbc_lblAdmin);
		
		JRadioButton rdbtnYes = new JRadioButton("Yes");
		GridBagConstraints gbc_rdbtnYes = new GridBagConstraints();
		gbc_rdbtnYes.anchor = GridBagConstraints.WEST;
		gbc_rdbtnYes.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnYes.gridx = 3;
		gbc_rdbtnYes.gridy = 4;
		contentPane.add(rdbtnYes, gbc_rdbtnYes);
		
		JRadioButton rdbtnNo = new JRadioButton("No");
		rdbtnNo.setSelected(true);
		GridBagConstraints gbc_rdbtnNo = new GridBagConstraints();
		gbc_rdbtnNo.anchor = GridBagConstraints.WEST;
		gbc_rdbtnNo.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnNo.gridx = 4;
		gbc_rdbtnNo.gridy = 4;
		contentPane.add(rdbtnNo, gbc_rdbtnNo);
		
		
		JButton btnAddUser = new JButton("Add");
		btnAddUser.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			
				boolean isAdmin = false;
				boolean isDone = false;
				if(rdbtnNo.isSelected()){
					isAdmin = false;
				} else if (rdbtnYes.isSelected()) {
					isAdmin = true;
				}
				if ( !loginTextField.getText().isEmpty() && !passwordTextField.getText().isEmpty()) {
					User user = new User(loginTextField.getText() , passwordTextField.getText() , isAdmin );
					JdbcUser jdbc = new JdbcUser();
					isDone = jdbc.createUser(user);
				}		
				if (isDone) {
					System.out.print("User add sucessfully");
					JOptionPane.showMessageDialog(null, "User sucessfully added");
					loginTextField.setText("");
					passwordTextField.setText("");
					rdbtnNo.setSelected(true);
				}
			}
		});
		GridBagConstraints gbc_btnAddUser = new GridBagConstraints();
		gbc_btnAddUser.insets = new Insets(0, 0, 0, 5);
		gbc_btnAddUser.gridx = 3;
		gbc_btnAddUser.gridy = 5;
		contentPane.add(btnAddUser, gbc_btnAddUser);
		
		ButtonGroup btgrp = new ButtonGroup();
		btgrp.add(rdbtnNo);
		btgrp.add(rdbtnYes);
		
	}
	

}
