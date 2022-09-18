package com.example.bookkeepingsys.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookPojo {
    private Integer id;
    private String name;
    private String isbn;
    private double rating;
    private Integer stockCount;
    private Date publishedDate;
    private String photo;
}
