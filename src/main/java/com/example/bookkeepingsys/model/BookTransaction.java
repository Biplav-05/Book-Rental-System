package com.example.bookkeepingsys.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.util.Date;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_book_transaction")
public class BookTransaction {
    @Id
    @SequenceGenerator(sequenceName = "tbl_book_transaction_seq_gen",name = "tbl_book_transaction_seq",allocationSize = 1)
    @GeneratedValue(generator = "tbl_book_transaction_seq_gen",strategy = GenerationType.IDENTITY)
    private Integer id;
    private Date fromDate;
    private Date toDate;
    private RentStatus rentStatus;


}
