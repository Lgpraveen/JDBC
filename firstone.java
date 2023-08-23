package jdbc;
import com.mysql.cj.jdbc.Driver;

import java.sql.*;
public class firstone
{
	public static void main(String[] args) throws SQLException
	{
		
		// load and register the driver
		
		Driver driver = new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(driver);
		
		//establish the connection
		
		String dburl = "jdbc:mysql:/jdbcone";
		String user ="root";
		String password = "pk2805";
		Connection con = DriverManager.getConnection(dburl,user,password);
		
		//create statement and pass the query
		
		Statement st = con.createStatement();
		String query = "insert into employee values(3,\"gopal\",\"chennai\",745679)";
//		String query  "delete from employee where empid =3";
		
//		process the result
		
		int result = st.executeUpdate(query);
//		while(result.next()) {
//		System.out.println(result.getInt(1)+" "+result.getString(2)+" "+result.getString(3)+" "+result.getLong("mobile"));
//	}
		System.out.println(result);
		
//		close the connection
		
		st.close();
		con.close();		
		
	}

	public static void insert() {
		// TODO Auto-generated method stub
		
	}
}
