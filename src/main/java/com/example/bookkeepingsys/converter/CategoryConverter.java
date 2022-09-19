package com.example.bookkeepingsys.converter;

import com.example.bookkeepingsys.model.Category;
import com.example.bookkeepingsys.pojo.CategoryPojo;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class CategoryConverter {
   private final ModelMapper modelMapper;

    public CategoryConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public Category pojoToEnity(CategoryPojo categoryPojo)
    {
        return this.modelMapper.map(categoryPojo, Category.class);
    }
}
