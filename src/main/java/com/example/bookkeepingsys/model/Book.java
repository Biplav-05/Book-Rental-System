package com.example.bookkeepingsys.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_book")
public class Book {
    @Id
    @SequenceGenerator(sequenceName = "book_seq_gen", name = "book_seq", allocationSize = 1)
    @GeneratedValue(generator = "book_seq_gen", strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String isbn;
    private double rating;
    private Integer stockCount;
    private Date publishedDate;
    private String photo;

   /* this code is for many to many mapping to Author entity
    book entity is inverse table*/

    @ManyToMany(mappedBy = "book", fetch = FetchType.LAZY)
    private Set<Author> author;

    @OneToMany(targetEntity = BookTransaction.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "bookId",referencedColumnName = "id")
    private List<BookTransaction> bookTransaction;


}
