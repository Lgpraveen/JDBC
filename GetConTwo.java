package jdbc;

import java.io.IOException;
import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;


public class GetConTwo 
{
	public static void main(String[] args) throws SQLException ,IOException
	{
		Driver driver = new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(driver);
		
		FileInputStream fis = new FileInputStream("C:\\Users\\hp\\java-work\\Jdbcdemo\\src\\jdbc\\abc");
		Properties p = new Properties();
		p.load(fis);
		
		Connection con = DriverManager.getConnection(p.getProperty("url"), p);
		Statement st = con.createStatement();
		int res = st.executeUpdate("delete from employee where empid=10");
	}

}
