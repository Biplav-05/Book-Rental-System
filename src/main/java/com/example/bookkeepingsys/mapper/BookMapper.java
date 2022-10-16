package com.example.bookkeepingsys.mapper;

import com.example.bookkeepingsys.model.Author;
import com.example.bookkeepingsys.model.Category;
import com.example.bookkeepingsys.pojo.BookAuthorCategory;
import com.example.bookkeepingsys.pojo.BookPoJoFindBook;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BookMapper {
  @Select("select tbl_book.id as bookId,isbn, name as bookName,photo,published_date as publishedDate,\n" +
          "       rating,stock_count as stockCount from tbl_book")
  List<BookAuthorCategory> allDetails();

  @Select("select id as bookId,name,isbn,rating,\n" +
          "       stock_count as stock,published_date,photo from tbl_book")
  List<BookPoJoFindBook> allBooks();

  @Select("select count(id) from  tbl_author where id=#{id}")
  Integer countAuthor(List<Integer> id);

  @Select("select * from tbl_category where id=#{id}")
  Category allCategory(Integer id);

  @Select("select * from tbl_author where id=#{id}")
  List<Author> allAuthor(List<Integer> id);


}
