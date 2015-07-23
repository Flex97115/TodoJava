package com.supinfo.suptodo.model;

import java.sql.*;
import java.util.ArrayList;

import com.supinfo.suptodo.controller.ConnectionDb;
import com.supinfo.suptodo.element.User;

public class JdbcUser {
	private Connection myConnection = null;
	
	public boolean createUser( User u ){
		User user = null;
		User myNewUser = null;
		boolean isDone = false; 
		
		user = findUserBylogin(u.getLogin());
		myConnection = ConnectionDb.getConnection();
		if ( user == null){
			try {
				int intAdmin = 0;
				if ( u.isAdmin() ){
					intAdmin = 1;
				} else {
					intAdmin = 0;
				}
				 
				int stmt = myConnection.createStatement().executeUpdate("INSERT INTO user (login, password, isAdmin) VALUES ( \""+u.getLogin()+"\",\""+u.getPassword()+"\",\""+intAdmin+"\")");
				
				myNewUser = findUserBylogin(u.getLogin());
				if ( stmt == 1) {
					if ( myNewUser != null){
						isDone = true;
					}
				}
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					myConnection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		return isDone;
	}
	
	public User findUserBylogin( String login ){
		myConnection = ConnectionDb.getConnection();
		User user = null;
		try{
			System.out.println(login.toUpperCase());
			PreparedStatement pstmt = myConnection.prepareStatement("SELECT * FROM user WHERE UPPER(login) = ?");
			pstmt.setString(1, login.toUpperCase());
			pstmt.executeQuery();
			ResultSet rs = pstmt.getResultSet();
			
			if (rs != null) {
				while(rs.next()) {
					
					String loginStr = rs.getString("login");
					String password = rs.getString("password");
					boolean isAdmin = rs.getBoolean("isAdmin");
					user = new User( loginStr , password , isAdmin);
				} 
			} else {
				System.out.println("IS NULL");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				myConnection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return user;
	}
	
	public ArrayList<User> getAllUser(){
		ArrayList<User> myArray = new ArrayList<User>();
		myConnection = ConnectionDb.getConnection();
		try{
			ResultSet rs = myConnection.createStatement().executeQuery("Select * FROM user ");
			if ( rs != null){
				User myUser;
				while(rs.next()){
					String login = rs.getString("login");
					String password = rs.getString("password");
					int numIsAdmin = rs.getInt("isAdmin");
					boolean isAdmin = false;
					if (numIsAdmin == 1){
						isAdmin = true;
					}
					myUser = new User(login , password , isAdmin);
					myArray.add(myUser);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				myConnection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return myArray;
	}
}
