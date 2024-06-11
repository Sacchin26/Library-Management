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

public class GetByAuthorServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

	String author=req.getParameter("author");
	List<Book> book=new ArrayList<Book>();
	BookSevice bookservice=new BookSevice();
	book=bookservice.getbyauthorService(author);
	
	req.setAttribute("author", book);
	req.getRequestDispatcher("GetByAuthorResponse.jsp").forward(req, resp);
	}

}
