package com.example.bookkeepingsys.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookTransactionDetails {
    private Integer memberId;
    private String memberName;
    private Integer bookId;
    private String bookName;
    private String isbn;
    private Date toDate;
    private Date fromDate;
    private String rentStatus;
}
