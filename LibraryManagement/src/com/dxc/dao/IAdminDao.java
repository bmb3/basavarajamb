package com.dxc.dao;

import java.util.List;

import com.dxc.pojos.Book;
import com.dxc.pojos.User;

public interface IAdminDao
{
	public boolean Authenticate(int adminid, String password);
	public List<Book> getAllBooks();
	public List<User> getAllUser();
	public void addBooks(Book b);
	public void addUser(User u);
	public void removeBooks(int bid);
	public void removeUser(int uid);
	public double getbalance(int uid);
	public void closeConnection();

}
