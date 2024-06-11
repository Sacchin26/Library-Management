package com.besant.Servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.besant.Services.BookSevice;
import com.besant.models.Book;

public class GetByPriceServlet  extends HttpServlet{
@Override
protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
	// TODO Auto-generated method stub

	int price=Integer.parseInt(arg0.getParameter("price"));
	List<Book> blist=new ArrayList<Book>();
	BookSevice bo= new BookSevice();
	blist=bo.getByPriceSevice(price);
	
	arg0.setAttribute("ab", blist);
	
	arg0.getRequestDispatcher("GetByPriceResponse.jsp").forward(arg0, arg1);
	
}
}
