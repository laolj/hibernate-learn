package com.example.demo.repository.impl;

import com.example.demo.pojo.Book;
import com.example.demo.repository.BookDao;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * @author llj
 * @create 2022-07-06 22:59
 */
@Repository
public class IBookDao implements BookDao {
    //官方给的类
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Book> getAllBooks() {
        String sql = "FROM Book as book ORDER BY book.bookId";
        return (List<Book>)entityManager.createQuery(sql).getResultList();
    }

    @Override
    public Book getBookById(int bookId) {
        return entityManager.find(Book.class,bookId);
    }

    @Override
    public void addBook(Book book) {
        entityManager.persist(book);
    }

    @Override
    public void updateBook(Book book) {
        Book book1 = getBookById(book.getBookId());
        book1.setTitle(book.getTitle());
        book1.setCategory(book.getCategory());
        entityManager.flush();
        entityManager.clear();
    }

    @Override
    public void deleteBook(int bookId) {
        entityManager.remove(getBookById(bookId));
    }

    @Override
    public boolean bookExists(String title, String category) {
        String sql = "FROM Book as book WHERE book.title=?0 and book.category=?1";
        int count = entityManager.createQuery(sql)
                .setParameter(0,title)
                .setParameter(1,category)
                .getResultList().size();
        return count > 0;
    }
}
