package com.supinfo.suptodo.model;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.supinfo.suptodo.controller.ConnectionDb;
import com.supinfo.suptodo.element.Todo;

public class JdbcTodo {
	private Connection myConnection = null;
	
	public boolean addTodo( String description ){
		boolean isDone = false;
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		myConnection = ConnectionDb.getConnection();
		try {
			int stmt = myConnection.createStatement().executeUpdate("INSERT INTO todo ( description , date , isDone ) VALUES (\""+ description +"\",\""+dateFormat.format(date)+"\",0 )");
			if ( stmt == 1)
			isDone = true;
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
		
		return isDone;
	}
	
	public ArrayList<Todo> getAllTodo(){
		
		ArrayList<Todo> myArray = new ArrayList<Todo>();
		myConnection = ConnectionDb.getConnection();
		try {
			ResultSet rs = myConnection.createStatement().executeQuery("Select * FROM todo ");
			if ( rs != null){
				Todo myTodo;
				while(rs.next()){
					int id = rs.getInt("id");
					String description = rs.getString("description");
					int numIsDone = rs.getInt("isDone");
					String comment = rs.getString("comment");
					boolean isDone = false;
					if ( numIsDone == 1){
						isDone = true;
					}
					myTodo = new Todo();
					myTodo.setId(id);
					myTodo.setDescription(description);
					myTodo.setDone(isDone);
					myTodo.setComment(comment);
					myArray.add(myTodo);
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
	
	public boolean updateTodo( int id , int numIsDone , String comment ){
		boolean isComplete = false;
		Todo myTodo = null;	
		myTodo = findTodoById(id);
		if (myTodo != null){
			myConnection = ConnectionDb.getConnection();
			try{
				
				int stmt = myConnection.createStatement().executeUpdate("UPDATE todo SET isDone = \""+numIsDone+"\", comment = \""+comment+"\" WHERE id=\""+id+"\"");
				if ( stmt == 1 ){
					isComplete = true;
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
		}
		return isComplete;
	}
	
	public Todo findTodoById(int id){
		Todo myTodo = null;
		myConnection = ConnectionDb.getConnection();
		try {
			PreparedStatement pstmt = myConnection.prepareStatement("SELECT * FROM todo WHERE id = ?");
			pstmt.setInt(1, id);
			pstmt.executeQuery();
			ResultSet rs = pstmt.getResultSet();
			if ( rs != null){
				
				while(rs.next()){
					String description = rs.getString("description");
					int numIsDone = rs.getInt("isDone");
					boolean isDone = false;
					if ( numIsDone == 1){
						isDone = true;
					}
					myTodo = new Todo();
					myTodo.setId(id);
					myTodo.setDescription(description);
					myTodo.setDone(isDone);
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
		return myTodo;
		
	}
}
