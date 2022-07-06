package com.example.demo;

import com.example.demo.pojo.Book;
import com.example.demo.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@SpringBootTest
@Transactional
class DemoApplicationTests {

    @Autowired
    private BookService bookService;

    @Test
    void contextLoads() {

        List<Book> allBooks = bookService.getAllBooks();
        System.out.println(allBooks);
        bookService.testJpa();
    }

    @Test
    @Rollback(false)
    void contextLoads1(){
        for (int i = 0; i < 100; i++) {
            Book book=new Book();
            book.setTitle("title"+i);
            book.setCategory("加油"+i);
            bookService.addBook(book);
        }
//        bookService.addBook()
    }

}
