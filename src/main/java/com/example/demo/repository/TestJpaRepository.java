package com.example.demo.repository;

import com.example.demo.pojo.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @author llj
 * @create 2022-07-06 23:08
 */
@Repository
public interface TestJpaRepository extends JpaRepository<Book,Integer>, JpaSpecificationExecutor<Book> {
}
