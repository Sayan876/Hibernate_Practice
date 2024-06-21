package insert_multiple;
import java.sql.*;
public class InsertMultipleDemo {
	public static void main(String[] args) 
	{
		Connection con = null;
		Statement stmt = null;
		String qry1 = "insert into btm.student values(100, 'Rayan', 56)";//DML
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=Sayan@1936");
			stmt = con.createStatement();
			
			stmt.executeUpdate(qry1);//Compilation+Execution
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(stmt!= null) 
			{
				try {
					stmt.close();
				}
				catch(SQLException e ) {
					e.printStackTrace();
				}
			}
			
			if(con!=null) {
				try {
					con.close();
				}
				catch(SQLException e) {
					e.printStackTrace();
				}
			}
			System.out.println("Closed all costly resources");
		}
	}
}
