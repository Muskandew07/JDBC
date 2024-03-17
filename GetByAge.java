package com.js.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GetByAge {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection c= null;
		try {
			Class.forName(Util.PATH);
			c=DriverManager.getConnection(Util.URL, Util.USER, Util.PWD);
			Statement s= c.createStatement();
			ResultSet rs=s.executeQuery("select * from person where age=22");
			
			while(rs.next()){
				System.out.println("Person id = "+rs.getInt("id"));
				System.out.println("Person name = "+ rs.getString("person"));
				System.out.println("Person age = "+ rs.getInt("age"));
			}
			if(rs.next()==false){
				System.out.println("No person is found");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				c.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		

	}

}
