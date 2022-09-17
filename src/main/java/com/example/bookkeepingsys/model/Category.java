package com.example.bookkeepingsys.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_category")
public class Category {
    @Id
    @SequenceGenerator(sequenceName = "tbl_category_seq_gen",name="tbl_category_seq",allocationSize = 1)
    @GeneratedValue(generator = "tbl_category_seq_gen",strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String description;

    @OneToMany(targetEntity = Book.class,cascade = CascadeType.ALL)
    @JoinColumn(name="categoryId",referencedColumnName = "id")
    private List<Book> book;
}
