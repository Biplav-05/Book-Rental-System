package com.example.bookkeepingsys.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_book", uniqueConstraints = {@UniqueConstraint(name = "unique_isbn_number", columnNames = "isbn")})
@Service
public class Book {
    @Id
    @SequenceGenerator(sequenceName = "book_seq_gen", name = "book_seq", allocationSize = 1)
    @GeneratedValue(generator = "book_seq_gen", strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String isbn;
    private Double rating;
    private Integer stockCount;
    private Date publishedDate;
    private String photo;


    //step-1

    @ManyToMany
    @JoinTable(
            //this will make a new database table by adding both table primary key
            name = "tbl_book_author",
            joinColumns = @JoinColumn(name = "book_id", foreignKey = @ForeignKey(name = "fk_book_id")),
            inverseJoinColumns = @JoinColumn(name = "author_id", foreignKey = @ForeignKey(name = "fk_author_id"))
    )
    private List<Author> authorSet;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "categoryID", referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "fk_category_id"))
    private Category category;

    @JsonIgnore
    @OneToMany(mappedBy = "book")
    private List<BookTransaction> bookTransactions;

    public void addAuthorToBook(List<Author> author) {

        authorSet.add((Author) author);
    }

    public void assignCategory(Category category1) {
        this.category = category1;
    }
}
