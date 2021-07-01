package com.te.jdbcfile;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Assignment2
{
	public static void main(String[] args)
	{
		Connection connection=null;
		Statement statement=null;
		String url1="jdbc:mysql://localhost:3306/employee?user=root&password=root";
		String query2="delete from deptt where loc='chicago'";
	   try {
		Class.forName("com.mysql.jdbc.Driver");
		connection=DriverManager.getConnection(url1);
		 statement=connection.createStatement();
			int result=statement.executeUpdate(query2);
			if(result !=0) {
				System.out.println(result+"no of row affected");
				System.out.println("Data inserted successfully");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
