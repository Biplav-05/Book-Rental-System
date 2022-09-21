package com.example.bookkeepingsys.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "tbl_member",uniqueConstraints = {@UniqueConstraint(name = "unique_email",columnNames = {"email"})})
public class Member {
    @Id
    @SequenceGenerator(sequenceName = "tbl_member_seq_gen",name = "tbl_member_seq",allocationSize = 1)
    @GeneratedValue(generator = "tbl_member_seq_gen",strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String email;
    private String phoneNumber;
    private String address;

    @JsonIgnore
    @OneToMany(mappedBy = "member")
    private List<BookTransaction> bookTransaction;
}
