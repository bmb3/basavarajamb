package com.dxc.Services;

import java.util.List;

import com.dxc.pojos.Book;

public interface IUserService 
{
	public boolean Authenticate(int userid, String password1);
	public List<Book> getAllBooks();
	public void issuebook(int uid, int bid);
	public void returnbook(int uid, int bid, int  noofdays);
	public void closeConnection();
}
