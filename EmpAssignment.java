package assignment;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;


public class EmpAssignment {
	public static void main(String[] args) throws SQLException
	{
		Scanner scanner=new Scanner(System.in);
	System.out.println("enter 1 for static ");	
	System.out.println("enter 2 for dynamic ");
	 int option =scanner.nextInt();
	 if(option==1)
	 {
		Connection connection=null;
		java.sql.Statement statement=null;
		String url="jdbc:mysql://localhost:3306/employee?user=root&password=root";
		
		try {
			connection=(Connection) DriverManager.getConnection(url);
			System.out.println("enter 1 for insert ");
			System.out.println("enter 2 for delete ");
			System.out.println("enter 3 for Update ");
			System.out.println("enter 4 for rename ");
			int value=scanner.nextInt();
			switch(value)
			{
			case(1):
			{
				String query="insert into emp values(7888,'sarika',42000,22)";
				statement=connection.createStatement();
				 int result=statement.executeUpdate(query);
				 if(result!=0)
					{
						System.out.println(result +"no of rows affected....");
						
					}
					break;
				
			}
			case(2):
			{
				String query=" delete from emp where Eid=7999";
				statement=connection.createStatement();
				 int result=statement.executeUpdate(query);
				 if(result!=0)
					{
						System.out.println(result+"no of rows affected....");
					}
					break;
					
			}
//			case(4):
//			{
//				String query=" alter table employees rename to employee_info";
//				statement=connection.createStatement();
//				 int result=statement.executeUpdate(query);
//				 if(result!=0)
//					{
//						System.out.println(result+"no of rows affected....");
//					}
//					break;
//					
//			}
			case(3):
			{
				String query=" update emp set name='haritha' where Eid=7900";
				statement=connection.createStatement();
				 int result=statement.executeUpdate(query);
				 if(result!=0)
					{
						System.out.println(result+"no of rows affected....");
					}
					break;
					
			}
			}
} catch (SQLException e) {
			
			e.printStackTrace();
		}
		 
	 }else
		 if(option==2)
		 {
			 Connection connection=null;
				java.sql.PreparedStatement preparedStatement=null;
				String url="jdbc:mysql://localhost:3306/employee?user=root&password=root";
				connection=(Connection) DriverManager.getConnection(url);
				System.out.println("enter 1 for insert ");
				System.out.println("enter 2 for delete ");
				System.out.println("enter 3 for Update ");
				System.out.println("enter 4 for rename ");
				int value=scanner.nextInt();
				switch(value)
				{
				case(1):
				{
					System.out.println("enter id u want to change ");
					int Eid=scanner.nextInt();
					System.out.println("enter name u want to change ");
					String Ename=scanner.next();
					
					String query="insert into emp values(?,?)";
					preparedStatement= connection.prepareStatement(query);
					preparedStatement.setInt(1, Eid);
					preparedStatement.setString(2, Ename);
					int result= preparedStatement.executeUpdate();
					
					
				//	 int result=statement.executeUpdate(query);
					 if(result!=0)
						{
							System.out.println(result +"no of rows affected....");
							
						}
						break;
					
				}
				case(2):
				{
					System.out.println("enter Eid u want to delete ");
					int Eid=scanner.nextInt();
					
					
					String query="delete from emp where Eid=?";
					preparedStatement= connection.prepareStatement(query);
					preparedStatement.setInt(1, Eid);
					
					int result= preparedStatement.executeUpdate();
					
				//	 int result=statement.executeUpdate(query);
					 if(result!=0)
						{
							System.out.println(result +"no of rows affected....");
							
						}
						break;
					
				}
				case(3):
				{
					System.out.println("enter id u want to insert");
					int Eid=scanner.nextInt();
					System.out.println("enter name u want to insert ");
					String Ename=scanner.next();
					System.out.println("enter salary u want to insert");
					int Esal=scanner.nextInt();
					System.out.println("enter dept u want to insert ");
					int deptno=scanner.nextInt();
					
					
					
					
					String query="insert into emp"+ " values(?,?,?,?)";
					preparedStatement= connection.prepareStatement(query);
					preparedStatement.setInt(1, Eid);
					preparedStatement.setString(2, Ename);
					preparedStatement.setInt(3, Esal);
					preparedStatement.setInt(4, deptno);
					
					
					int result= preparedStatement.executeUpdate();
					
				//	 int result=statement.executeUpdate(query);
					 if(result!=0)
						{
							System.out.println(result +"no of rows affected....");
							
						}
						break;
					
				}
				case(4):
				{
					System.out.println("enter table to want change");
					
					String name=scanner.next();
					
					
					String query="alter table emp rename to ?";
					preparedStatement= connection.prepareStatement(query);
				
					preparedStatement.setString(1, name);
					
					int result= preparedStatement.executeUpdate();
					
				//	 int result=statement.executeUpdate(query);
					 if(result!=0)
						{
							System.out.println(result +"no of rows affected....");
							
						}
						break;
					
				}
				
				
				}
				
		 

	}
	}
	}


