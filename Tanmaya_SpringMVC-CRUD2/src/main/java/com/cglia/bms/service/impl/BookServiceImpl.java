package com.cglia.bms.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cglia.bms.dao.BookDAO;
import com.cglia.bms.model.Book;
import com.cglia.bms.service.BookService;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDAO bookDAO;

    @Override
    public Integer saveBook(Book book) {
        return bookDAO.save(book);
    }

    @Override
    public Book getBookById(Integer id) {
        return bookDAO.getById(id);
    }

    @Override
    public int updateBook(Book book) {
        return bookDAO.update(book);
    }

    @Override
    public int deleteBookById(Integer id) {
        return bookDAO.deleteById(id);
    }

    public List<Book> getAllBooks() {
        return bookDAO.getAll();
    }

}
