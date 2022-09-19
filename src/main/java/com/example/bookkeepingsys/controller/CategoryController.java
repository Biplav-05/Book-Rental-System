package com.example.bookkeepingsys.controller;

import com.example.bookkeepingsys.misc.ApiResponse;
import com.example.bookkeepingsys.pojo.CategoryPojo;
import com.example.bookkeepingsys.service.CategoryService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("category/")
public class CategoryController extends ApiResponse {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    //Get all category details
    @GetMapping("getAll")
    public ApiResponse getAllCategory() {
        return categoryService.totalCategory();
    }

    //save Category
    @PostMapping("saveAndUpdateCategory")
    public ApiResponse saveAndUpdate(@RequestBody CategoryPojo categoryPojo)
    {
        return categoryService.saveAndUpdate(categoryPojo);
    }
}
