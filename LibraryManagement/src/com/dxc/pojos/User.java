package com.dxc.pojos;


public class User 
{
  private int uid;
  private String uname;
  private String password;
  private String bname;
  private double balance;
  
  public User()
  {
	  
  }

public User(int uid, String uname, String password,String bname, double balance) {
	super();
	this.uid = uid;
	this.uname = uname;
	this.password = password;
	this.bname = bname;
	this.balance = balance;
}

public int getUid() {
	return uid;
}

public void setUid(int uid) {
	this.uid = uid;
}

public String getUname() {
	return uname;
}

public void setUname(String uname) {
	this.uname = uname;
}

public String getPassword() {
	return password;
}

public String getBname() {
	return bname;
}

public void setBname(String bname) {
	this.bname = bname;
}

public void setPassword(String password) {
	this.password = password;
}

public double getBalance() {
	return balance;
}

public void setBalance(double balance) {
	this.balance = balance;
}
  
  public void display1()
  {
	  System.out.println(uid+"  "+uname+"  "+password+"  "+bname+"   "+balance);
  }
}


