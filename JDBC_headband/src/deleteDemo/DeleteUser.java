package deleteDemo;
import java.sql.*;
import java.util.*;
public class DeleteUser {
   public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	    Connection con = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    String qry = "delete from btm.student where id = ?";
	    		
	
	try {
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=Sayan@1936");
		pstmt = con.prepareStatement(qry);
		System.out.println("Enter the student id you want to delete");
		int sid = sc.nextInt();
		pstmt.setInt(1, sid);
		pstmt.executeUpdate();
		System.out.println("Record has been deleled of " + sid);
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	finally {
		if(con!=null) {
			try {
				con.close();
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
		
		if(rs!=null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
}
