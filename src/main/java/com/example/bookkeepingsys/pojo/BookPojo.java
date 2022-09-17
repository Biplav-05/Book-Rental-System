package com.example.bookkeepingsys.pojo;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class BookPojo {
    private Integer id;
    private String name;
    private String isbn;
    private double rating;
    private Integer stockCount;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date publishedDate;
    private String photo;
}
