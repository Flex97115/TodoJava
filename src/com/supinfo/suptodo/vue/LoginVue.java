package com.supinfo.suptodo.vue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JPasswordField;

import com.supinfo.suptodo.element.User;
import com.supinfo.suptodo.model.JdbcUser;

public class LoginVue extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField loginTextField;
	private JPasswordField passwordField;
	/**
	 * Create the frame.
	 */
	public LoginVue() {
		setTitle("suptodo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 230, 170);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{113, 103, 36, 45, -23, 0, -9, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblLogin = new JLabel("Login");
		GridBagConstraints gbc_lblLogin = new GridBagConstraints();
		gbc_lblLogin.insets = new Insets(0, 0, 5, 5);
		gbc_lblLogin.gridx = 1;
		gbc_lblLogin.gridy = 0;
		contentPane.add(lblLogin, gbc_lblLogin);
		
		JLabel lblLogin_1 = new JLabel("login :");
		GridBagConstraints gbc_lblLogin_1 = new GridBagConstraints();
		gbc_lblLogin_1.anchor = GridBagConstraints.EAST;
		gbc_lblLogin_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblLogin_1.gridx = 0;
		gbc_lblLogin_1.gridy = 2;
		contentPane.add(lblLogin_1, gbc_lblLogin_1);
		
		loginTextField = new JTextField();
		GridBagConstraints gbc_loginTextField = new GridBagConstraints();
		gbc_loginTextField.gridwidth = 2;
		gbc_loginTextField.insets = new Insets(0, 0, 5, 5);
		gbc_loginTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_loginTextField.gridx = 1;
		gbc_loginTextField.gridy = 2;
		contentPane.add(loginTextField, gbc_loginTextField);
		loginTextField.setColumns(10);
		
		JLabel lblPassword = new JLabel("password :");
		GridBagConstraints gbc_lblPassword = new GridBagConstraints();
		gbc_lblPassword.anchor = GridBagConstraints.EAST;
		gbc_lblPassword.insets = new Insets(0, 0, 5, 5);
		gbc_lblPassword.gridx = 0;
		gbc_lblPassword.gridy = 3;
		contentPane.add(lblPassword, gbc_lblPassword);
		
		passwordField = new JPasswordField();
		GridBagConstraints gbc_passwordField = new GridBagConstraints();
		gbc_passwordField.gridwidth = 2;
		gbc_passwordField.insets = new Insets(0, 0, 5, 5);
		gbc_passwordField.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordField.gridx = 1;
		gbc_passwordField.gridy = 3;
		contentPane.add(passwordField, gbc_passwordField);
		
		ArrayList<User> myArray = (new JdbcUser()).getAllUser();
		
		JButton loginBtn = new JButton("Connect");
		loginBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!myArray.isEmpty()){
					char[] input = passwordField.getPassword();
					String password = String.copyValueOf(input);
					for( int i = 0 ; i <= myArray.size()-1 ; i++ ){
						if( myArray.get(i).getLogin().equals(loginTextField.getText()) && myArray.get(i).getPassword().equals(password)){
							if(myArray.get(i).isAdmin()){
								setVisible(false);
								ManagerVue managerFrame = new ManagerVue();
								managerFrame.setVisible(true);
								break;
							} else {
								setVisible(false);
								EmployeeVue employeeFrame = new EmployeeVue();
								employeeFrame.setVisible(true);
								break;
							}
							
						}
					}
					loginTextField.setText("");
					passwordField.setText("");
					if( isVisible() ){
				    	   getToolkit().beep();
					}
				}
			}
		});
		GridBagConstraints gbc_loginBtn = new GridBagConstraints();
		gbc_loginBtn.insets = new Insets(0, 0, 0, 5);
		gbc_loginBtn.gridx = 1;
		gbc_loginBtn.gridy = 5;
		contentPane.add(loginBtn, gbc_loginBtn);
	}

}
