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

public class AdminDaoImpl implements IAdminDao
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
	public List<Book> getAllBooks() {
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
	public List<User> getAllUser() {
    List<User> list1=new ArrayList<>();
		
		try {
			Statement stmt=conn.createStatement();
			ResultSet rset=stmt.executeQuery("select * from user");
			while(rset.next())
			{
			 User u=new User(rset.getInt(1), rset.getString(2), rset.getString(3),rset.getString(4), rset.getDouble(5));
				list1.add(u);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return list1;
	}

	public void addBooks(Book b) 
	{
		try {
			PreparedStatement pstmt= (PreparedStatement) conn.prepareStatement("insert into books values(?,?,?)");
			pstmt.setInt(1,b.getBid());
			pstmt.setString(2,b.getBname());
			pstmt.setString(3,b.getStatus());
		
			pstmt.execute();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}	 	
	}

	public void addUser(User u) 
	{
		try {
			PreparedStatement pstmt= (PreparedStatement) conn.prepareStatement("insert into User values(?,?,?,?,?)");
			pstmt.setInt(1,u.getUid());
			pstmt.setString(2,u.getUname());
			pstmt.setString(3,u.getPassword());
			pstmt.setString(4,u.getBname());
			pstmt.setDouble(5,u.getBalance());
			pstmt.execute();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}


	public boolean Authenticate(int  adminid, String password) 
	{
		boolean b=false;
		try {
		Statement stmt =  conn.createStatement();
	
		ResultSet rset=stmt.executeQuery("select * from admin");
		while(rset.next())
				{
		
			if(adminid==rset.getInt(1) && password.equals(rset.getString(2)))
			{
				b=true;
				System.out.println("login Successful....!!!");
			}
			else
			{
				System.out.println("Incorrect login Credentials");
			}
				
				}
				} catch(SQLException e) {
					e.printStackTrace();
				}
	return b;
	}

	@Override
	public void removeBooks(int bid) 
	{
		try {
			PreparedStatement pstmt= (PreparedStatement) conn.prepareStatement("delete from books where bid=?");
			pstmt.setInt(1,bid);
			 pstmt.execute();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}	 	
	}

	@Override
	public void removeUser(int uid)
	{
		try {
			PreparedStatement pstmt= (PreparedStatement) conn.prepareStatement("delete from user where uid=?");
			pstmt.setInt(1,uid);
			 pstmt.execute();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}	 		
	}

	@Override
	public double getbalance(int uid) {
		Statement stmt;
		double balance=0;
		try {
			stmt = conn.createStatement();
			ResultSet rs=stmt.executeQuery("select * from user");
			while(rs.next())
			{
				if(uid==rs.getInt(1))
				{
					balance=rs.getDouble(5);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return balance;
	
		
		
	}

     @Override
     public void closeConnection() 
      {
     try {
       conn.close();
    } catch (SQLException e) {
       e.printStackTrace();
      }
		
}
}
		

    


		
