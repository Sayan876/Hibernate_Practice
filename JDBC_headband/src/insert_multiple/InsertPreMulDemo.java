package insert_multiple;

import java.sql.*;

public class InsertPreMulDemo {
     public static void main(String[] args) 
     {
    	Connection con = null;
    	PreparedStatement pstmt = null;
    	String qry = "insert into btm.student values(?,?,?)";//DML
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=Sayan@1936");
			pstmt = con.prepareStatement(qry);//compilation
			//set the data for place holders 
			pstmt.setInt(1, 121);
			pstmt.setString(2, "Luffy");
			pstmt.setInt(3, 35);
			
			//Execute
			pstmt.executeUpdate();//Execution---1
			
			pstmt.setInt(1, 122);
			pstmt.setString(2, "Nami");
			pstmt.setInt(3, 69);
			
			//Execute
			pstmt.executeUpdate();//Execution---2
			
			pstmt.setInt(1, 123);
			pstmt.setString(2, "Robin");
			pstmt.setInt(3, 24);
			
			//Execute
			pstmt.executeUpdate();//Execution---3
			
			
			System.out.println("All three records have been inserted!!");
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
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
