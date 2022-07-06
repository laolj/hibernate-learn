package com.example.demo.service;

import com.example.demo.pojo.Book;
import com.example.demo.repository.BookDao;
import com.example.demo.repository.TestJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author llj
 * @create 2022-07-06 23:01
 */
@Service
public class BookService {

    @Autowired
    private BookDao bookDao;

    @Autowired
    private TestJpaRepository testJpaRepository;


    public void testJpa(){
        List<Book> all = testJpaRepository.findAll();
        System.out.println(all);
        Pageable of = PageRequest.of(0, 10);
        Page<Book> all1 = testJpaRepository.findAll(of);
        System.out.println(all1.toString());
    }

    public Book getBookById(int bookId){
        Book book= bookDao.getBookById(bookId);
        return book;
    }

    public List<Book> getAllBooks(){
        return bookDao.getAllBooks();
    }

    public synchronized boolean addBook(Book book){
        if(bookDao.bookExists(book.getTitle(),book.getCategory())){
            return false;
        }else {
            bookDao.addBook(book);
            return true;
        }
    }
    public void updateBook(Book book){
        bookDao.updateBook(book);
    }

    public void deleteBook(int bookId){
        bookDao.deleteBook(bookId);
    }
}
