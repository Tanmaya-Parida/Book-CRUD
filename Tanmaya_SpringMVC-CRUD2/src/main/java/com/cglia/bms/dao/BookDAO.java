package com.cglia.bms.dao;

import java.util.List;

import com.cglia.bms.model.Book;

public interface BookDAO {
	
	public Integer save(Book book);
	
	public Book getById(Integer id);
	
	public int update(Book book);
	
	public int deleteById(Integer id);
	
	public List<Book> getAll();
}
