package com.supinfo.suptodo.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class ConnectionDb {
	
	public static Connection getConnection(){
		
		Connection myConnection = null;
		
		try {
			  Class.forName(com.mysql.jdbc.Driver.class.getName());

			  
			} catch(ClassNotFoundException ex) {
			  System.out.println("Can’t load the Driver");
			}
		
		try {
			myConnection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:8889/suptodo","root","root");
			System.out.println("You are connected");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Can't connect to database ");
			e.printStackTrace();
		}
		
		return myConnection;

	}
}
