package com.example.bookkeepingsys.pojo;

import com.example.bookkeepingsys.model.RentStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookTransactionPojo {
    private Integer id;

    private Date fromDate;
    private Date toDate;

    @Enumerated(EnumType.STRING)
    private RentStatus rentStatus;
    private Integer bookId;
    private Integer memberId;
}
