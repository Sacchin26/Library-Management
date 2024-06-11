package com.besant.Services;

import java.util.List;

import com.besant.models.Book;

public interface BokSeviceInterface {
	public String createbook(Book obj);
	public List<Book> getAllData();
	public String bookUpdate(Book obj) ;
	public String bookDelete(int id);
	public Book getByIDService(int id);



}
