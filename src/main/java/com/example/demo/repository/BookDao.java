package com.example.demo.repository;

import com.example.demo.pojo.Book;

import java.util.List;

/**
 * @author llj
 * @create 2022-07-06 22:59
 */

public interface BookDao {

    List<Book> getAllBooks();

    Book getBookById(int bookId);

    void addBook(Book book);

    void updateBook(Book book);

    void deleteBook(int bookId);

    boolean bookExists(String title,String category);


}
