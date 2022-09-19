package com.example.bookkeepingsys.mapper;

import com.example.bookkeepingsys.pojo.CategoryPojo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CategoryMapper {
    @Select("select * from tbl_category")
    List<CategoryPojo> listOfCategory();
}
