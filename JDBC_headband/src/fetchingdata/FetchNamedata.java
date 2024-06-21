package fetchingdata;
import java.util.*;
import java.sql.*;
public class FetchNamedata {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String qry = "select * from btm.student where Name=?";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=Sayan@1936");
			pstmt = con.prepareStatement(qry);
			
			System.out.println("Enter the name of the student");
			String sname = sc.next();
			pstmt.setString(1, sname);
			rs = pstmt.executeQuery();
			if(rs.next()) {
			   int sid = rs.getInt(1);
			   String ssname = rs.getString(2);
			   int sperc = rs.getInt(4);
			   System.out.println("The id is " + sid);
			   System.out.println("The name is "+ ssname);
			   System.out.println("The percentage is " + sperc);
			}else {
				System.err.println("No data Found");
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
