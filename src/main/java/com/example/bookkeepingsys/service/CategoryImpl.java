package com.example.bookkeepingsys.service;

import com.example.bookkeepingsys.converter.CategoryConverter;
import com.example.bookkeepingsys.mapper.CategoryMapper;
import com.example.bookkeepingsys.misc.ApiResponse;
import com.example.bookkeepingsys.model.Category;
import com.example.bookkeepingsys.pojo.CategoryPojo;
import com.example.bookkeepingsys.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryImpl extends ApiResponse implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;
    private CategoryConverter categoryConverter;


    public CategoryImpl(CategoryRepository categoryRepository, CategoryMapper categoryMapper, CategoryConverter categoryConverter) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
        this.categoryConverter = categoryConverter;
    }

    @Override
    public ApiResponse totalCategory() {
        return success("List of category",categoryMapper.listOfCategory());
    }

    @Override
    public ApiResponse saveAndUpdate(CategoryPojo categoryPojo) {
        Category category = categoryConverter.pojoToEnity(categoryPojo);


        Optional<Category> categoryStatus = categoryRepository.checkStatus(categoryPojo.getName());
        if (!categoryStatus.isPresent()) {
            category = categoryRepository.save(category);
            return success("Category inserted", null);
        }
        return error("Category Name : " + categoryPojo.getName() + " already exist ", null);


    }
}
