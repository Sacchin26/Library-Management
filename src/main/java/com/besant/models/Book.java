package com.besant.models;

public class Book {
	private  int bookid;
	private String bname;
	private String author;
	private int price;
	private int quntity;
	public Book(int bookid, String bname, String author, int price, int quntity) {
		super();
		this.bookid = bookid;
		this.bname = bname;
		this.author = author;
		this.price = price;
		this.quntity = quntity;
	}
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getBookid() {
		return bookid;
	}
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getQuntity() {
		return quntity;
	}
	public void setQuntity(int quntity) {
		this.quntity = quntity;
	}
	@Override
	public String toString() {
		return "Book [bookid=" + bookid + ", bname=" + bname + ", author=" + author + ", price=" + price + ", quntity="
				+ quntity + "]";
	}
	
	

}
