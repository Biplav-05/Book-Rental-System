package com.example.bookkeepingsys.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookAuthorCategory {
    private Integer bookId;
    private String bookName;
   private String isbn;
    private Double rating;
    private Integer stockCount;
   private Date publishedDate;
    private String photo;



}
