package com.dxc.Services;

import java.util.List;

import com.dxc.dao.AdminDaoImpl;
import com.dxc.dao.IAdminDao;
import com.dxc.pojos.Book;
import com.dxc.pojos.User;


public class AdminServiceImpl implements IAdminService
{
	private IAdminDao dao=new AdminDaoImpl();

	public List<Book> getAllBooks() {
		return dao. getAllBooks();
	}

	public   List<User> getAllUser() {
		return dao.getAllUser();
	}

	public void addBooks(Book b) {
	 dao.addBooks(b);	
	}

	public void addUser(User u) {
	  dao.addUser(u);
		
	}

	public boolean Authenticate(int adminid, String password) {
		 return dao.Authenticate(adminid, password);
		
	}


	public void removeBooks(int bid) {
		dao.removeBooks(bid);
	}

	public void removeUser(int uid) {
		dao.removeUser(uid);
	
		
	}

	@Override
	public double getbalance(int uid) {
		return dao.getbalance(uid);
		
	}

      public void closeConnection()
	{
      dao. closeConnection();
	}
}
