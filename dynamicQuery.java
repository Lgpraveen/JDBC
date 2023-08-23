package jdbc;

import java.sql.*;
import java.util.Scanner;

public class dynamicQuery
{
	public static void main(String[] args) throws SQLException
	{
		Scanner sc= new Scanner(System.in);
		Driver driver = new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(driver);
		
		Connection con = DriverManager.getConnection( "jdbc:mysql:/jdbcone?user=root&password=pk2805");
		System.out.println("select the operation to thr perform based");
		System.out.println("CREATE - READ - UPDATE - DELETE");
		
		String operation = sc.next();	
		
		switch(operation) 
		{
		case "CREATE":
		{
			PreparedStatement pst = con.prepareStatement("insert into employee values(?,?,?,?) ");
			System.out.println("enter the numbers rows to be inserted = ");
			int Number = sc.nextInt();
			
			while(Number>=1)
			{
				System.out.println("Enter the ID");
				int empid = sc.nextInt();
				System.out.println("Enter the Name of Employee");
				String empname = sc.next();
				System.out.println("Enter the Name of address");
				String address = sc.next();
				System.out.println("Enter the mobile");
				long mobile = sc.nextLong();
				
				pst.setInt(1, empid);
				pst.setString(2, empname);
				pst.setString(3, address);
				pst.setLong(4, mobile);
				
				pst.executeUpdate();
				
				Number--;
				
				
				
			}
		}
		break;
		
		case "READ":
		{
			PreparedStatement pst = con.prepareStatement("select * from employee");
			ResultSet rs = pst.executeQuery();
			while(rs.next()) 
			{
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getLong("mobile"));
			}
		}
		break;
		
		case "UPDATE":
		{
			PreparedStatement pst = con.prepareStatement("update employee set mobile= ? where empid =?");
			System.out.println("Enter the ID");
			int empid = sc.nextInt();
			System.out.println("Enter the Name of address");
			long mobile = sc.nextLong();
			
			pst.setInt(1, empid);
			pst.setLong(2, mobile);
			
			pst.executeUpdate();
		}
		break;
		
		case "DELETE":
		{
			PreparedStatement pst = con.prepareStatement("delete from employee where empname  =? ");
			System.out.println("Enter the ID TO DELETED");
			int empid = sc.nextInt();
			
			pst.setInt(1, empid);
			pst.executeUpdate();
		}
		break;
		}
		
	}

}
