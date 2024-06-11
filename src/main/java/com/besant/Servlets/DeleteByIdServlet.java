package com.besant.Servlets;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.besant.Services.BookSevice;
import com.besant.models.DatabasePath;

public class DeleteByIdServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		ServletContext ctx=getServletContext();
		String url=ctx.getInitParameter("url");
		String username=ctx.getInitParameter("username");
		String pwd=ctx.getInitParameter("pwd");
		
		DatabasePath obj=new DatabasePath();
		obj.setUrl(url);
		obj.setUsername(username);
		obj.setPwd(pwd);
		
	int bookid=Integer.parseInt(req.getParameter("bookid"));
	
     BookSevice bs= new BookSevice();
        String res=bs.bookDelete(bookid,obj);
        req.setAttribute("bb",bookid);
	req.setAttribute("aa", res);
	req.getRequestDispatcher("DeleteByIdresponse.jsp").forward(req, resp);
	}
}
