package updatingData;
import java.util.*;
import java.sql.*;
public class UpdatePre {
  public static void main(String[] args) {
	  Scanner sc = new Scanner(System.in);
	  Connection con = null;
	  PreparedStatement pstmt = null;
	  String qry = "Update btm.student set Name = ? where id = ?";
	  try {
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=Sayan@1936");
		pstmt = con.prepareStatement(qry);
		System.out.println("Enter the new name");
		String sname = sc.next();
		pstmt.setString(1, sname);
		System.out.println("Enter the id number");
		int sid = sc.nextInt();
		pstmt.setInt(2, sid);
		pstmt.executeUpdate();
		System.out.println("Record has been updated");
		
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
	  }
}
}
