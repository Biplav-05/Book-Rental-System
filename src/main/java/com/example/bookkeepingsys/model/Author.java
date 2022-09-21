package com.example.bookkeepingsys.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_author",uniqueConstraints = {@UniqueConstraint( name = "unique_email",columnNames = "email")})
public class Author {
    @Id
    @SequenceGenerator(sequenceName = "tbl_author_seq_gen", name = "tbl_author_seq", allocationSize = 1)
    @GeneratedValue(generator = "tbl_author_seq_gen", strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String email;
    private String mobileNumber;

    //step-2
    @JsonIgnore
    @ManyToMany(mappedBy = "authorSet")
    private Set<Book> book = new HashSet<>();

}
