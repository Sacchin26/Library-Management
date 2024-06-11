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

public class GetByIdAllServlet extends HttpServlet {
@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	// TODO Auto-generated method stub
	int bookid=Integer.parseInt(req.getParameter("bookid"));
	
	
	BookSevice bt=new BookSevice();
	Book ba=new Book();
	ba.setBookid(bookid);
	
	
	ba=bt.getByIDService(bookid);
	
	req.setAttribute("aa", ba);
	req.getRequestDispatcher("getByIdResponse.jsp").forward(req, resp);
	
	
	
}
}