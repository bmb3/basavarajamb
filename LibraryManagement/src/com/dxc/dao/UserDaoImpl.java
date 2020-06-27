package com.dxc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dxc.pojos.Book;
import com.dxc.pojos.User;
import com.mysql.jdbc.PreparedStatement;

public class UserDaoImpl implements IUserDao
{
	
private static Connection conn;
	
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		    conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","Bmb@1905$");
			 }
		catch(Exception e)
		{
			e.printStackTrace();
		}
}

	@Override
	public boolean Authenticate(int userid, String password1) 
	{
		boolean b=false;

		try {
			PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement("select * from user ");
		
			ResultSet rset=pstmt.executeQuery();
			while(rset.next())
					{
					if(userid==rset.getInt(1) && password1.equals(rset.getString(3)))
						
					{
						b=true;
						break;
					}

					} 
					} catch(SQLException e) {
						e.printStackTrace();
					}

		return b;
	}
	public List<Book> getAllBooks()
	{
List<Book> list=new ArrayList<>();
		
		try {
			Statement stmt=conn.createStatement();
			ResultSet rset=stmt.executeQuery("select * from books");
			while(rset.next())
			{
				Book b=new Book(rset.getInt(1), rset.getString(2), rset.getString(3));
				list.add(b);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
	
		return list;
	}
	@Override
	public void issuebook(int uid, int bid) {
		try {
	Statement stmt=conn.createStatement();
	ResultSet rset=stmt.executeQuery("select bid from books");
	while(rset.next())
	{
		if(bid==rset.getInt(1))
		{
			PreparedStatement pstmt= (PreparedStatement) conn.prepareStatement("insert into book_details values(?,?)");
			pstmt.setInt(1, uid);
			pstmt.setInt(2, bid);
			pstmt.execute();
			System.out.println("Successfully recived book from library...!!!");
		}
		
			}
} catch(SQLException e) {
	e.printStackTrace();
}
		
	}
	@Override
	public void returnbook(int uid, int bid, int noofdays) {
		try {
			PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement("select balanace from user where uid=?");
			pstmt.setInt(1,uid);
			 ResultSet rs= pstmt.executeQuery();
			 rs.next();
			 double amount=rs.getDouble(1);
			 double k=amount-(5*noofdays);
			 
			 PreparedStatement pstmt1 = (PreparedStatement) conn.prepareStatement("update user set balanace=? where uid=?");
			 pstmt1.setDouble(1, k);
			 pstmt1.setInt(2, uid);
			 pstmt1.execute();
			 int reducedbalance=5*noofdays;
	        System.out.println(reducedbalance+"  "+"Rupees is deducted");
			
			PreparedStatement pstmt2=(PreparedStatement) conn.prepareStatement("delete from book_details where uid=? && bid=?");
			pstmt2.setInt(1, uid);
			pstmt2.setInt(2, bid);
			pstmt2.execute();
			System.out.println("Successfully returned the book....!!!");
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
	@Override
	public void closeConnection() {
		try {
		       conn.close();
		    } catch (SQLException e) {
		       e.printStackTrace();
		      }
		
	}


	
}