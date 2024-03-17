package com.js.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GetByName {
	public static void main(String[] args) {
		Connection c=null;
		try {
			Class.forName(Util.PATH);
			c=DriverManager.getConnection(Util.URL, Util.USER, Util.PWD);
			Statement s= c.createStatement();
			ResultSet rs=s.executeQuery("select * from person where person='muskan'");
			
			while(rs.next()) {
				System.out.println("Person id = "+rs.getInt("id"));
				System.out.println("Person name = "+ rs.getString("person"));
				System.out.println("Person age = "+ rs.getInt("age"));
			}
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		finally {
			try {
				c.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
