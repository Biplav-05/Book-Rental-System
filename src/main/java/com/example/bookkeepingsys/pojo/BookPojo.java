package com.example.bookkeepingsys.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookPojo {
    private Integer id;
    @NotBlank(message = "name cannot be blank")
    private String name;
    @NotBlank(message = "isbn cannot be blank")
    private String isbn;
    private double rating;
    @NotNull(message = "stock count cannot be null")
    private Integer stockCount;
    @NotNull(message = "date cannot be null")

    private Date publishedDate;
    @NotNull(message = "photo cannot be null")
    private String photo;
}
