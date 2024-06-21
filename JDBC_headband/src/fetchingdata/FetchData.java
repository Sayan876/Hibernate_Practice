package fetchingdata;
import java.sql.*;
public class FetchData {
   public static void main(String[] args) {
	int c = 0;
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String qry = "Select * from btm.student";//DQL
	try {
		Class.forName("com.mysql.jdbc.Driver");
		con =DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=Sayan@1936");
		System.out.println("Connection established!");
		pstmt = con.prepareStatement(qry);
		rs = pstmt.executeQuery();
		while(rs.next()) {
			int sid = rs.getInt(1);
			String sname = rs.getString(2);
			int sperc = rs.getInt(4);
			c++;
			System.out.println("Column " + c);
			System.out.println("Student id is " + sid);
			System.out.println("Student name is " +sname);
			System.out.println("Student percentage is " + sperc);
			System.out.println("===============================");
		}
		
		System.out.println("Total number of records "+c);
		
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	finally {
		if(rs!= null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(pstmt!=null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(con!=null) {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
}
