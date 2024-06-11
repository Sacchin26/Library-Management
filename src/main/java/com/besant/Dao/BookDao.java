package com.besant.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.besant.models.Book;
import com.besant.models.DatabasePath;
import com.mysql.cj.jdbc.CallableStatement;

public class BookDao {

    int r;
	String username = "root";
	String pwd = "1234";
	String url = "jdbc:mysql://localhost:3306/sys";
	
	
	String insqry = "insert into book(bname,author,price,quntity) values(?,?,?,?)";
    String getqry="select * from book";
    

	public String createDtobook(Book obj,DatabasePath obj2) {
		
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
		} 
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {

			Connection connection = DriverManager.getConnection(obj2.getUrl(), obj2.getUsername(), obj2.getPwd());
			PreparedStatement preparedStatement = connection.prepareStatement(insqry);

			
			preparedStatement.setString(1, obj.getBname());

			preparedStatement.setString(2, obj.getAuthor());
			preparedStatement.setInt(3, obj.getPrice());
			preparedStatement.setInt(4, obj.getQuntity());

			
			r = preparedStatement.executeUpdate();
			
			connection.close();
			preparedStatement.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (r == 1) {
			return "RECORDS INSERTED";
		} else {
			return "RECORDS NOT INSERTED";
		}
	}
	
	
	//-----------------GET ALL DATA--------------------------
	
	public List<Book> getAllBookDtoData(){
		List<Book> book=new ArrayList<Book>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		
		try {
			
			Connection connection=DriverManager.getConnection(url, username, pwd);
			PreparedStatement preparedStatement=connection.prepareStatement(getqry);
			
			ResultSet r = preparedStatement.executeQuery();
			
				while(r.next())
				{
					Book br=new Book();
					br.setBookid(r.getInt("bookid"));
					br.setBname(r.getString("bname"));
					br.setAuthor(r.getString("author"));
					br.setPrice(r.getInt("price"));
					br.setQuntity(r.getInt("quntity"));
					book.add(br);
					
			}
				connection.close();	
                preparedStatement.close();
		} 
	
	      catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return book;
		
	}
	
	//---------------UPDATE
	
	
	String upqry="update book set bname=?,author=?,price=?,quntity=? where bookid=?";
	int result;
	public String updateBookDao(Book obj)
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	Connection connection;
	try {
		connection = DriverManager.getConnection(url,username,pwd);
		PreparedStatement preparedStatement=connection.prepareStatement(upqry);
		
          preparedStatement.setString(1,obj.getBname());
          preparedStatement.setString(2, obj.getAuthor());
          preparedStatement.setInt(3, obj.getPrice());
          preparedStatement.setInt(4, obj.getQuntity());
          preparedStatement.setInt(5, obj.getBookid());

          
          int result = preparedStatement.executeUpdate();
          connection.close();
          preparedStatement.close();
          if (result == 1) {
      		return "RECORDS UPDATED";
      	} 
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
		return "RECORDS NOT UPDATED";
	}
	
	
	
	
	//-------------DELETE BY ID
	
	public String DeleteByByID(int id,DatabasePath obj) {
		String upqry="delete from book where bookid=?";
			
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Connection connection= DriverManager.getConnection(obj.getUrl(),obj.getUsername(),obj.getPwd());
			PreparedStatement preparedStatement=connection.prepareStatement(upqry);
			preparedStatement.setInt(1,id);
		int delres	=preparedStatement.executeUpdate();
			
			if(delres==1)
			return "DATA IS DELETED";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return "DATA NOT DELETED";
	}
	
	
	
	//==============GET BT ID
	
	public Book getBYIdData(int id) {
		Book br=new Book();

		String getbyid="select * from book where bookid=? ";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			Connection connection=DriverManager.getConnection(url,username,pwd);
			PreparedStatement preparedStatement=connection.prepareStatement(getbyid);
			preparedStatement.setInt(1, id);
			ResultSet r=preparedStatement.executeQuery();
			
			while(r.next()) {
				
				br.setBookid(r.getInt("bookid"));
				br.setBname(r.getString("bname"));
				br.setAuthor(r.getString("author"));
				br.setPrice(r.getInt("price"));
				br.setQuntity(r.getInt("quntity"));
				
		}

			connection.close();
				preparedStatement.close();
				
		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return br;
	
	}
	
	
	
	//------get by price using store  procedure query 
	
	public  List<Book> getBYPrice(int pri) {
		
		List<Book> list=new ArrayList<Book>();
	
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			Connection connection=DriverManager.getConnection(url,username,pwd);

		   CallableStatement callableStatement=(CallableStatement) connection.prepareCall("{call getbypri(?)}");
		   callableStatement.setInt(1, pri);
			ResultSet r=callableStatement.executeQuery();
			
			while(r.next()) {
				Book br=new Book();
				br.setBookid(r.getInt("bookid"));
				br.setBname(r.getString("bname"));
				br.setAuthor(r.getString("author"));
				br.setPrice(r.getInt("price"));
				br.setQuntity(r.getInt("quntity"));
			   // System.out.println(br);
			list.add(br);
				
		}
			
			connection.close();
			callableStatement.close();
				
		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		
	
	}
	
	public List<Book> getbyauthor(String author)
	{
		List<Book> list=new ArrayList<Book>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			Connection connection=DriverManager.getConnection(url,username,pwd);
			CallableStatement callableStatement =(CallableStatement) connection.prepareCall("{call authorname(?)}");
			callableStatement.setString(1, author);
			
			ResultSet r=callableStatement.executeQuery();
			
			while(r.next())
			{
				Book obj=new Book();
				obj.setBookid(r.getInt("bookid"));
				obj.setBname(r.getString("bname"));
				obj.setAuthor(r.getString("author"));
				obj.setPrice(r.getInt("price"));
				obj.setQuntity(r.getInt("quntity"));
				list.add(obj);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	}
	
	

