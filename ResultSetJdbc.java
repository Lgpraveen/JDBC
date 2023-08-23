package jdbc;

import java.sql.*;


public class ResultSetJdbc 
{
	public static void main(String[] args) throws SQLException
	{
		
		Driver driver = new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(driver);
		
		Connection con = DriverManager.getConnection( "jdbc:mysql:/jdbcone?user=root&password=pk2805");
		
		Statement st = con.createStatement();
		boolean res = st.execute ("select empid,mobile from employee");
		
		System.out.println(res);
		
		ResultSet result = st.getResultSet();
		
		while(result.next()) 
		{
			
			System.out.println(result.getInt(1)+"   "+result.getLong("mobile"));
		
		}
		
		con.close();		
		
	}

}
