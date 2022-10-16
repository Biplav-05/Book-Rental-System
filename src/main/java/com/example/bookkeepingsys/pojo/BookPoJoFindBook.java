package com.example.bookkeepingsys.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookPoJoFindBook {
    private Integer bookId;
    private String name;
    private String isbn;
    private String photo;
    private String published_date;
    private Integer Stock;
    private String rating;
}
