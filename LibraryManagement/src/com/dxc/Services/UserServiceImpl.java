package com.dxc.Services;

import java.util.List;

import com.dxc.dao.IUserDao;
import com.dxc.dao.UserDaoImpl;
import com.dxc.pojos.Book;

public class UserServiceImpl implements IUserService
{
private IUserDao dao=new UserDaoImpl();
	@Override
	public List<Book> getAllBooks() {
	
		return dao.getAllBooks();
	}

	public boolean Authenticate(int userid, String password1) {
	
		 return dao.Authenticate(userid,password1);
	}

	@Override
	public void issuebook(int uid, int bid) {
		dao.issuebook(uid, bid);
		
	}

	@Override
	public void returnbook(int uid, int bid, int noofdays) {
		dao.returnbook(uid, bid,noofdays);
		
	}

	@Override
	public void closeConnection() {
		dao.closeConnection();
		
	}

}
