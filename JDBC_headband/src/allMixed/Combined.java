package allMixed;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.*;

public class Combined {
   
	public void insert() 
	{
		Scanner sc = new Scanner(System.in);
		int sid,sperc;
		String sname;
    	Connection con = null;
    	PreparedStatement pstmt = null;
    	String qry = "insert into btm.student values(?,?,?)";//DML
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=Sayan@1936");
			pstmt = con.prepareStatement(qry);//compilation
			//set the data for place holders 
			System.out.println("Enter the student ID");
			sid = sc.nextInt();
			pstmt.setInt(1, sid);
			System.out.println("Enter the student name");
			sname = sc.next();
			pstmt.setString(2, sname);
			System.out.println("Enter the student percentage");
			sperc = sc.nextInt();
			pstmt.setInt(3, sperc);
			
			//Execute
			pstmt.executeUpdate();//Execution---1
			
			
			
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
	
	public void update()
	{
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
	
	public void delete() 
	
	{
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
	public void fetchAll()
	{
		Scanner sc = new Scanner(System.in);
		int c = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String qry = sc.nextLine();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con =DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=Sayan@1936");
			System.out.println("Connection established!");
			pstmt = con.prepareStatement(qry);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int sid = rs.getInt(1);
				String sname = rs.getString(2);
				int sperc = rs.getInt(3);
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
	
	public void fetchId() 
	{
		Scanner sc = new Scanner(System.in);
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String qry = "select * from btm.student where id=?";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=Sayan@1936");
			pstmt = con.prepareStatement(qry);
			//Set the data for Place Holder
			System.out.println("Enter the student id you wanna see the details of...");
			int sid = sc.nextInt();
			pstmt.setInt(1, sid);
//			System.out.println("Enter the name of the student");
//			String sname = sc.next();
//			pstmt.setString(2, sname);
			rs = pstmt.executeQuery();
			if(rs.next()) {
			   int ssid = rs.getInt(1);
			   String ssname = rs.getString(2);
			   int sperc = rs.getInt(3);
			   System.out.println("The id of the student is " + ssid);
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
