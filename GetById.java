package com.js.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GetById {

	public static void main(String[] args) {
		try {
			Class.forName(Util.PATH);
			Connection c = DriverManager.getConnection(Util.URL, Util.USER, Util.PWD);
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery("Select * from person where id=2");
			if (rs.next()) {
				System.out.println("Person Id=" + rs.getInt("id"));
				System.out.println("Person Name=" + rs.getString("person"));
				System.out.println("Person Age=" + rs.getInt("age"));

			} else {
				System.out.println("No person with Given id");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();

		}
	}

}
