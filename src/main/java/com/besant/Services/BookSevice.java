package com.besant.Services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.besant.Dao.BookDao;
import com.besant.exception.InvalidBookIdException;
import com.besant.exception.InvalidPriceException;
import com.besant.models.Book;
import com.besant.models.DatabasePath;


public class BookSevice {

	   String res;

	public String createbook(Book obj,DatabasePath obj2) {
		
		if(obj.getPrice()<200 || obj.getQuntity()<5)
		{
			try {
			throw new InvalidPriceException("Price should be lessthan 200 or Quantity lessthan 5");
		
		}
			catch(Exception e) {
				System.out.println(e);
				return "records  not inserted Price should be lessthan 200 or Quantity lessthan 5";
			}
		
		}
			BookDao dao=new BookDao();
			 res	=dao.createDtobook(obj,obj2);
				return res;
	

	}
	
	
	
	public List<Book> getAllData(){
		BookDao bao=new BookDao();
		
		return bao.getAllBookDtoData();
	}
	
	
	
	
	public String bookUpdate(Book obj) {
		
	
	if(obj.getBookid()<1)
	{
		try
		{
	
		
		throw new InvalidBookIdException("inavalid id ");
	}
	catch(Exception e){
		System.out.println(e);
	}
	}
	
	BookDao up=new BookDao();
	String res=up.updateBookDao(obj);
		
		
		return res;
		
	}
	
	public String bookDelete(int id,DatabasePath obj)
	
	{
		BookDao ba=new BookDao();
	String	res=ba.DeleteByByID(id,obj);
	return res;
	}
	
	public Book getByIDService(int id)
	{
		BookDao bd=new BookDao();
		
		
		return bd.getBYIdData(id);
		
	}
	
	public List<Book> getByPriceSevice(int price)
	{

		BookDao bd=new BookDao();
		
		return bd.getBYPrice(price);
	
	}	
	
	public List<Book> getbyauthorService(String author)
	{
		BookDao bdao=new BookDao();
		return bdao.getbyauthor(author);
	}
}
		
		
		
	
	
	
	

