package jdbc;
import java.sql.*;
import java.util.Arrays;
import java.util.Scanner;
public class BatchExecutionPrepst 
{
	public static void main(String[] args) throws SQLException
	{
		Driver driver = new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(driver);
		
		Connection con = DriverManager.getConnection( "jdbc:mysql:/jdbcone?user=root&password=pk2805");
		System.out.println("select the operation to thr perform based");
		System.out.println("Choose your option \n 1.Insert Employee \n 2.Delete employee \n 3.update employee");
		Scanner sc= new Scanner(System.in);
		int operation = sc.nextInt();
		switch(operation)
		{
		case 1:
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
				
				pst.addBatch();
				Number--;
			
		}
			pst.executeBatch();
		
		}
		break;
		
		case 2:
		{
			PreparedStatement pt = con.prepareStatement("delete from employee where empid = ?");
			System.out.println("enter the rows you want to delete");
			int number = sc.nextInt();
			while(number>0) {
				System.out.println("enter the id you want to delete");
				int id = sc.nextInt();
				pt.setInt(1, id);
				
				pt.addBatch();
				number--;
				
			}
			pt.executeBatch();
			
		}
		break;
		
		case 3:
		{
			PreparedStatement st = con.prepareStatement("update employee set mobile= ? where empid =?");
			System.out.println("Enter the ID");
			int empid = sc.nextInt();
			System.out.println("Enter the Name of mobile");
			long mobile = sc.nextLong();
			
			
			st.setLong(1, mobile);
			st.setInt(2, empid);
			st.addBatch();
			st.executeBatch();
		}
		
		break;
		
		}	
		
	}

}
