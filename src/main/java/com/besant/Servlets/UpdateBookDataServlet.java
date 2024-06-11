package com.besant.Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.besant.Services.BookSevice;
import com.besant.models.Book;

public class UpdateBookDataServlet extends HttpServlet{
@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	// TODO Auto-generated method stub

    int bookid=Integer.parseInt(req.getParameter("bookid"));
	String bname=req.getParameter("bname");
	String author=req.getParameter("author");
	int price=Integer.parseInt(req.getParameter("price"));
	int quntity=Integer.parseInt(req.getParameter("quntity"));
	
	Book bt=new Book();
	bt.setBookid(bookid);
	bt.setBname(bname);
	bt.setAuthor(author);
	bt.setPrice(price);
	bt.setQuntity(quntity);
	
	BookSevice bo=new BookSevice();
	
	String res=bo.bookUpdate(bt);
	System.out.println(res);
	req.setAttribute("aa", bookid);
	req.setAttribute("bb", res);
	req.getRequestDispatcher("UpdateResponse.jsp").forward(req, resp);

}
}
