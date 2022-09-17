package com.example.bookkeepingsys.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_author")
public class Author {
    @Id
    @SequenceGenerator(sequenceName = "tbl_author_seq_gen", name = "tbl_author_seq", allocationSize = 1)
    @GeneratedValue(generator = "tbl_author_seq_gen", strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String email;
    private String mobileNumber;
    /*for many to many mapping to the Book entity
    Author table is origin table and Book is inverse table*/
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "tbl_book_author", joinColumns = {
            @JoinColumn(name = "authorId", referencedColumnName = "id")

    }
            , inverseJoinColumns = {
            @JoinColumn(name = "bookId", referencedColumnName = "id")
    })
    private List<Book> book;
}
