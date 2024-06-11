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

public class GetBookAllDataServlet extends HttpServlet{
@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	
	BookSevice bs=new BookSevice();
	List<Book> book=new ArrayList<Book>();
    book=bs.getAllData();
   req.setAttribute("book", book);
   req.getRequestDispatcher("GetBookDataResponse.jsp").forward(req, resp);
}
}
