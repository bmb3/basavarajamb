package com.dxc.pojos;

public class Book
{
	private int bid;
	private String bname;
	private String status;
	
	
	public Book() {
		
	}


	public Book(int bid, String bname, String status) {
		super();
		this.bid = bid;
		this.bname = bname;
		this.status = status;
	}


	public int getBid() {
		return bid;
	}


	public void setBid(int bid) {
		this.bid = bid;
	}


	public String getBname() {
		return bname;
	}


	public void setBname(String bname) {
		this.bname = bname;
	}
	
	
	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public void display() {
		System.out.println(bid+" "+bname+" "+status);
	}
}