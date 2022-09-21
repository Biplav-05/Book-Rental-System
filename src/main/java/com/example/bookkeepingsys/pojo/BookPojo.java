package com.example.bookkeepingsys.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
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
    private Double rating;
    @NotNull(message = "stock count cannot be null")
    private Integer stockCount;


    @NotNull(message = "category ID cannot be null")
    private Integer categoryId;

    @NotNull(message = "date cannot be null")
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd")
    private Date publishedDate;
    @NotNull(message = "photo cannot be null")
    private String photo;
}
