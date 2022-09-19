package com.example.bookkeepingsys.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoryPojo {
    private Integer id;
    @NotBlank(message = "Category name cannot be blank")
    private String name;
    @NotBlank(message = "Description cannot be blank")
    private String description;
}
