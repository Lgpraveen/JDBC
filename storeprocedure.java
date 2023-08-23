package jdbc;
import java.sql.*;


public class storeprocedure 
{
	public static void main(String[] args) throws SQLException 
	{
		Driver driver = new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(driver);
		
		Connection con = DriverManager.getConnection( "jdbc:mysql:/jdbcone?user=root&password=pk2805");
		
		CallableStatement cst = con.prepareCall("call jdbcone.insert(9,'pk','abt',234567898)");
		System.out.println(cst.executeUpdate());
	}

}
