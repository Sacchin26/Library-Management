package com.besant.Servlets;
import com.besant.Dao.BookDao;
import com.besant.Services.BookSevice;
import com.besant.models.*;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CreateBookServlrt extends HttpServlet{
@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	//----config is only one servlet to access the url,username and pwd
	//config write inside the servlet xml
	/**
	ServletConfig config=getServletConfig();
	String url=config.getInitParameter("url");
	String username=config.getInitParameter("username");
	String pwd=config.getInitParameter("pwd");
	*/
	//context write outside the Servlet this help of all sevlet can acess
	ServletContext ctx=getServletContext();
	String url=ctx.getInitParameter("url");
	String username=ctx.getInitParameter("username");
	String pwd=ctx.getInitParameter("pwd");
	
	DatabasePath obj=new DatabasePath();
	obj.setUrl(url);
	obj.setUsername(username);
	obj.setPwd(pwd);
	
	
	
	
	
	
	
	String bname=req.getParameter("bname");
	String author=req.getParameter("author");
	int price=Integer.parseInt(req.getParameter("price"));
	int quntity=Integer.parseInt(req.getParameter("quntity"));
	

	
	Book bt=new Book();
	bt.setBname(bname);
	bt.setAuthor(author);
	bt.setPrice(price);
	bt.setQuntity(quntity);
	

	
	BookSevice bo=new BookSevice();
	
	
	String res=bo.createbook(bt,obj);
	
	
	
	req.setAttribute("ab", bt);
	req.setAttribute("res", res);
	
	req.getRequestDispatcher("CreateBookResponsejsp.jsp").forward(req, resp);
}
}
