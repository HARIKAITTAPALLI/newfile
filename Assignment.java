package com.te.jdbcfile;

import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.Connection;


public class Assignment
{
	public static void main(String[] args)
	{
		
              
				Connection connection=null;
				Statement statement=null;
				String url1="jdbc:mysql://localhost:3306/employee?user=root&password=root";
				String query1="update emp set Eid=123459 where Ename='king'";
			   try {
				Class.forName("com.mysql.jdbc.Driver");
				connection=DriverManager.getConnection(url1);
				 statement=connection.createStatement();
					int result=statement.executeUpdate(query1);
					if(result !=0) {
						System.out.println(result+"no of row affected");
						System.out.println("Data inserted successfully");
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			  }
		
	}



