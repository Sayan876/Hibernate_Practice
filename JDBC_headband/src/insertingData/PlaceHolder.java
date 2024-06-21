package insertingData;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class PlaceHolder {
	public static void main(String[] args) {
		Connection con = null;
		Statement stmt = null;
		String qry = "insert into btm.student values(107, 'Jill', 37)";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver is loaded and registred");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=Sayan@1936");
			System.out.println("Connection has been established with the server");
			stmt = con.createStatement();
			System.out.println("Platform Created");
			stmt.executeUpdate(qry);
			System.out.println("Record Inserted");
		}
		catch(ClassNotFoundException | SQLException e) {
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
