package com.example.demo.pojo;

import lombok.Data;

import javax.persistence.*;

/**
 * @author llj
 * @create 2022-07-06 22:55
 */
@Entity
@Table(name = "books")
@Data
public class Book {


    private static final long serialVersionUID = 1L;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private int bookId;


    @Column(name = "title")
    private String title;

    @Column(name = "category")
    private String category;


}
