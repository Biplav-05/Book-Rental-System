package com.example.bookkeepingsys.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;

import java.sql.Date;
import java.util.HashSet;
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


    //step-1
    @ManyToMany
    @JoinTable(
            //this will make a new database table by adding both table primary key
            name = "tbl_book_author",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id")
    )
    private Set<Author> authorSet = new HashSet<>();

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "categoryID",referencedColumnName = "id")
    private Category category;

    public void addAuthorToBook(Author author) {
        authorSet.add(author);
    }
}
