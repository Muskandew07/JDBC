package com.js.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Update {

	public static void main(String[] args) {
		Connection c = null;
		try {
			Class.forName(Util.PATH);
			c = DriverManager.getConnection(Util.URL,Util.USER,Util.PWD);
			Statement s = c.createStatement();
			int res = s.executeUpdate("update person set person='Reena',age=23 where id=3");
			if(res>0) {
				System.out.println("Updated :)");
			}else {
				System.out.println("Sorry, No person with that id :( ");	
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				c.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

	}

}
