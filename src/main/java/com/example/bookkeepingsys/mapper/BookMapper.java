package com.example.bookkeepingsys.mapper;

import com.example.bookkeepingsys.pojo.BookAuthorCategory;
import com.example.bookkeepingsys.pojo.BookPoJoFindBook;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
@Mapper
public interface BookMapper {
//    @Select("select tbl_book.id as bookId,tbl_book.name as bookName,isbn,photo,published_date as publishedDate,rating,stock_count as stockCount,\n" +
//            "       tbl_author.name as authorName,tbl_category.name as category from  tbl_book,tbl_category,tbl_author,tbl_book_author\n" +
//            "where tbl_author.id=tbl_book_author.author_id and tbl_book.id=tbl_book_author.book_id\n" +
//            "and tbl_category.id=tbl_book.categoryid")
//   @Select("select tbl_book.id as bookId,isbn,name,photo,published_date as " +
//           "publishedDate,rating,stock_count as stockCount from tbl_book;")
//    @Select("select tbl_book_author.book_id ,tbl_book_author.author_id,tbl_author.id ," +
//            "tbl_author.email,tbl_author.mobile_number,tbl_author.name from tbl_book_author\n" +
//            "inner join tbl_author on tbl_book_author.author_id = tbl_author.id")
//   @Select("select tbl_category.id as categoryId, name,description from tbl_category")

  @Select("select tbl_book.id as bookId ,tbl_book.name as book,tbl_author.name as author,tbl_category.name as category\n" +
          "from tbl_book\n" +
          "    cross join tbl_book_author cross join tbl_author cross join tbl_category\n" +
          "         where tbl_author.id=tbl_book_author.author_id and  tbl_book.id=tbl_book_author.book_id\n" +
          "           and tbl_book.categoryid=tbl_category.id;")
    List<BookAuthorCategory> allDetails();

  @Select("select id as bookId,name,isbn,rating,\n" +
          "       stock_count as stock,published_date,photo from tbl_book")
  List<BookPoJoFindBook> allBooks();

}
