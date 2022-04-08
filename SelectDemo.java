import java.sql.*;
import java.util.*;
class SelectDemo
{
	public static void main(String args[])
	{
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver Loaded");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@ntsocietyserver:1521:oralbrce","IPC109","IPC109");
			System.out.println("established");
			Scanner s=new Scanner(System.in);
			System.out.println("enter your employeeid");
			int empno=s.nextInt();
			Statement st=con.createStatement();
			String sql="select *from emp";
			ResultSet rs=st.executeQuery(sql);
			boolean result=false;
			while(rs.next())
			{
				if(empno==rs.getInt(1))
				{
					System.out.println("valid user");
					System.out.println("hello"+rs.getString(2));
					result=true;
					break;
				}
			}
			if(result==false)
			{	
				System.out.println("invalid user");
			}

		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}