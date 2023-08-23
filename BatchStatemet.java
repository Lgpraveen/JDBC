package jdbc;
import java.sql.*;


public class BatchStatemet 
{
	public static void main(String[] args) throws SQLException
	{
		Driver driver = new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(driver);
		Connection con = DriverManager.getConnection( "jdbc:mysql:/jdbcone?user=root&password=pk2805");
		Statement st = con.createStatement();
		
		st.addBatch("delete from employee where address ='abt'");
		st.addBatch("update employee set empname ='gopalluu' where empid=3");
		st.addBatch("insert into employee values(10,'gpk','act',45676547)");
		
		
		int[] arr=st.executeBatch();
		int start=0;
		while(start<arr.length) {
			System.out.println(arr[start]);
			start++;
		}
	}
}
