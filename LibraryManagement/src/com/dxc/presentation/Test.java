package com.dxc.presentation;

import java.util.*;

import com.dxc.Services.AdminServiceImpl;
import com.dxc.Services.IAdminService;
import com.dxc.Services.IUserService;
import com.dxc.Services.UserServiceImpl;
import com.dxc.pojos.User;

import com.dxc.pojos.Book;

public class Test
{
	public static void main(String[] args) {
		int choice;
		Scanner sc= new Scanner(System.in);
		
		IAdminService AdminService=new AdminServiceImpl();
		IUserService UserService= new UserServiceImpl();
		
		while(true)
		{
			System.out.println("1.login as admin...");
			System.out.println("2.login as user...");
			System.out.println("Enter ur choice");
			choice= sc.nextInt();
			switch(choice)
			{
			case 1 :
				System.out.println("Enter adminid");
				System.out.println("Enter password");
				int adminid=sc.nextInt();
				String password=sc.next();
				boolean b1=AdminService.Authenticate(adminid,password);
				if(b1==true) {
					while(true)
					{
						System.out.println("1.Add user");
						System.out.println("2.Add  books");
						System.out.println("3.see books");
						System.out.println("4.see user");
						System.out.println("5.delete books");
						System.out.println("6.delete user");
						System.out.println("7.getbalance");
						System.out.println("8. closeConnection");
						System.out.println("Enter ur choice");
						choice= sc.nextInt();
						switch(choice)
						{
						case 1:
							System.out.println("Enter uid,uname,password,bname,balance");
							AdminService.addUser(new User(sc.nextInt(),sc.next(),sc.next(),sc.next(),sc.nextDouble()));
						    break;
						
						case 2:
							System.out.println("Enter bid,bname,status");
							AdminService.addBooks(new Book(sc.nextInt(),sc.next(),sc.next()));
						    break;
							
						case 3 :
							List<Book> list=AdminService.getAllBooks();
							for(Book b:list)
								b.display();
							System.out.println();
							break;
							
						case 4 :
							List<User> list1=AdminService.getAllUser();
							for(User u:list1)
								u.display1();
							System.out.println();
							break;
							
						case 5 :
							System.out.println("Enter bid of book to be removed");
						    int c=sc.nextInt();
						    AdminService.removeBooks(c);
							break;
							
						case 6 :
							System.out.println("Enter uid of user to be removed");
							int d=sc.nextInt();
						    AdminService.removeUser(d);
							break;
						
						case 7 :
							System.out.println("Enter uid of user to be view balance ");
							int uid=sc.nextInt();
					 	    double balance=AdminService.getbalance(uid);
					 	   System.out.println("balance="+balance);
							break;
							
						 case 8 :
							System.out.println("Logout Successfully from admin.......!!!!!");
							AdminService.closeConnection();
							System.exit(0);
						   break;
						}
					}
					
				}
				break;
				
			case 2 :
				
				System.out.println("Enter userid");
				System.out.println("Enter password");
				int userid =sc.nextInt();
				String password1=sc.next();
				boolean b2=UserService.Authenticate(userid,password1);
				if(b2==true)
				{
					System.out.println("user login Successfully....!!!");
				while(true)
				{
					System.out.println("1.show bookslist");
					System.out.println("2.issue book");
					System.out.println("3.return book");
					System.out.println("4.closeConnection");
					choice= sc.nextInt();
					switch (choice)
					{
					case 1 :
						List<Book> list=UserService.getAllBooks();
						for(Book b:list)
							b.display();
						System.out.println();
						break;
						
					case 2 :
						System.out.println("Enter bid");
						UserService.issuebook(userid, sc.nextInt());
						break;
						
					case 3 :
						System.out.println("Enter bid returned");
						System.out.println("Enter noofdays");
						UserService.returnbook(userid, sc.nextInt(),sc.nextInt());
						break;
						 
					case 4 :
					   System.out.println("Logout Successfully from User.....!!!!!");
					   UserService.closeConnection();
					   System.exit(0);
				       break;
					}
				}
				
				}
				else
					System.out.println("incorrect login credentials");
				break;
			
			}
		}
		
	}
}
