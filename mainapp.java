package jdbc;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class mainapp 
{
	public static void main(String[] args) throws SQLException 
	{
		Scanner sc= new Scanner(System.in);
		Driver driver = new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(driver);
		
		Connection con = DriverManager.getConnection( "jdbc:mysql:/jdbcone?user=root&password=pk2805");
		
		System.out.println("Choose your option \n 1.Insert Employee \n 2.Delete employee \n 3.update employee \n 4.fetch");
		int key = sc.nextInt();
	
	switch(key) 
	{
	case 1 : 
	{
		Statement st = con.createStatement();
		String query = "insert into employee values(6,\"gopal\",\"chennai\",745679)";
		
		int result = st.executeUpdate(query);
		System.out.println(result +" rows affected");
		st.close();
		con.close();
	}
	break;
	
	case 2:
	{
		Statement st = con.createStatement();
		String query = "delete from employee where empid  =315;";
		int result = st.executeUpdate(query);
		System.out.println(result +" rows affected");
		st.close();
		con.close();
	}
	break;
	
	case 3:
	{
		Statement st = con.createStatement();
		String query = "update employee set address='vellore' where empid =2;";
		int result = st.executeUpdate(query);
		System.out.println(result +" rows affected");
		st.close();
		con.close();
	}
	break;
	
	case 4:
	{
		Statement st = con.createStatement();
		String query = "select * from employee;";
		ResultSet result = st.executeQuery(query);
		while(result.next()) 
		{
			
		System.out.println(result.getInt(1)+"   "+result.getString(2)+"   "+result.getString(3)+"   "+result.getLong("mobile"));
		
		}
		System.out.println(result);
		st.close();
		con.close();
		
	}
	}
	}

}
