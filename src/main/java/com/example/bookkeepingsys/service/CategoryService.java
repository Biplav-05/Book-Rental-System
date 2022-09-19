package com.example.bookkeepingsys.service;

import com.example.bookkeepingsys.misc.ApiResponse;
import com.example.bookkeepingsys.pojo.CategoryPojo;
import org.springframework.stereotype.Service;

@Service
public interface CategoryService {
    ApiResponse totalCategory();

    ApiResponse saveAndUpdate(CategoryPojo categoryPojo);
}
