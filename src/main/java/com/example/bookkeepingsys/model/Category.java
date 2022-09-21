package com.example.bookkeepingsys.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_category",uniqueConstraints = {@UniqueConstraint(name = "unique_name",columnNames = "name")})
public class Category {
    @Id
    @SequenceGenerator(sequenceName = "tbl_category_seq_gen",name="tbl_category_seq",allocationSize = 1)
    @GeneratedValue(generator = "tbl_category_seq_gen",strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String description;

    @JsonIgnore
    @OneToMany(mappedBy = "category")
    private Set<Book> books = new HashSet<>();
}
