package com.js.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GetAll {

	public static void main(String[] args) {
		Connection c = null;
		try {
			Class.forName(Util.PATH);
			c= DriverManager.getConnection(Util.URL, Util.USER, Util.PWD);
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery("Select * from person");
			while(rs.next()) {
				System.out.println("Person Id=" + rs.getInt("id"));
				System.out.println("Person Name=" + rs.getString("person"));
				System.out.println("Person Age=" + rs.getInt("age"));
				System.out.println("====================================");
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
