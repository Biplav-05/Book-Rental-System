package com.example.bookkeepingsys.mapper;

import com.example.bookkeepingsys.pojo.BookAuthorCategory;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
@Mapper
public interface BookMapper {
    @Select("select tbl_book.id as bookId,tbl_book.name as bookName,isbn,photo,published_date as publishedDate,rating,stock_count as stockCount,\n" +
            "       tbl_author.name as authorName,tbl_category.name as category from  tbl_book,tbl_category,tbl_author,tbl_book_author\n" +
            "where tbl_author.id=tbl_book_author.author_id and tbl_book.id=tbl_book_author.book_id\n" +
            "and tbl_category.id=tbl_book.categoryid")
    List<BookAuthorCategory> allDetails();
}
