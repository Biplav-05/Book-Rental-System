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
@Table(name = "tbl_student")
public class Student {
    @Id
    @SequenceGenerator(sequenceName = "tbl_student_seq_gen",name = "tbl_student_seq",allocationSize = 1)
    @GeneratedValue(generator = "tbl_student_seq_gen",strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String email;
    private String phone;
    private String address;
    @OneToMany(targetEntity = BookTransaction.class,cascade = CascadeType.ALL)
    @JoinColumn(name="studentId",referencedColumnName = "id")
    private List<BookTransaction> bookTransaction;
}
