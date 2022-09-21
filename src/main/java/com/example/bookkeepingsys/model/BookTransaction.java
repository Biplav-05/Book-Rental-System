package com.example.bookkeepingsys.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;


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
    @Enumerated(EnumType.STRING)
    private RentStatus rentStatus;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "memberId",referencedColumnName = "id",foreignKey = @ForeignKey(name = "fk_member_id"))
    private Member member;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "bookId",referencedColumnName = "id",foreignKey = @ForeignKey(name = "fk_book_id"))
    private Book book;


}
