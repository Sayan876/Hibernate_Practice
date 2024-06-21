package loginUser;
import java.sql.*;
import java.util.*;
public class LoginAuthentication {
   public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter the name");
	String nm = sc.next();
	System.out.println("Enter the password");
	String pw = sc.next();
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String qry = "select username from btm.user where name=? and password=?";
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=Sayan@1936");
		pstmt = con.prepareStatement(qry);//set the data for place holders
		pstmt.setString(1, nm);
		pstmt.setString(2, pw);
		//Execute the query
		rs = pstmt.executeQuery();
		if(rs.next()) {
			String uname = rs.getString(1);
			System.out.println("Welcome " + uname);
		}
		else {
			System.out.println("Wrong password or doesn't exist");
		}
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
