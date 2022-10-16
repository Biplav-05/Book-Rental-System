package com.example.bookkeepingsys.mapper;

import com.example.bookkeepingsys.pojo.BookPojo;
import com.example.bookkeepingsys.pojo.BookTransactionDetails;
import com.example.bookkeepingsys.pojo.BookTransactionPojo;
import com.example.bookkeepingsys.pojo.MemberPojo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Optional;

@Mapper
public interface BookTransactionMapper {
    @Select("select * from tbl_book where id=#{id}")
    public Optional<BookPojo> getBookId(Integer id);

    @Select("select * from tbl_member where id=#{id}")
    Optional<MemberPojo> findSpecificMember(Integer id);

    @Select("select * from tbl_book_transaction where member_id=#{id}")
    Optional<BookTransactionPojo> checkMemberTransaction(Integer id);

    @Select("select stock_count from tbl_book where id=#{id}")
    public Integer stockCount(Integer id);

    @Update("update tbl_book set stock_count=stock_count-1 where id =#{id}")
    void decreaseBookCount(Integer id);

    @Update("update tbl_book set stock_count=stock_count+1 where id =#{id}")
    void increaseBookCount(Integer id);

    // @Select("select rent_status from tbl_book_transaction where member_id=#{id} order by rent_status desc limit 1")
//    @Select("select max(rent_status) from tbl_book_transaction where member_id=#{id} group by member_id")
    @Select("select rent_status from tbl_book_transaction where member_id=#{id} and id=(select max(id) from tbl_book_transaction)")
    String getRentStatus(Integer id);

    @Select("select tbl_member.id as memberId,tbl_member.name as memberName,tbl_book.id as bookId,tbl_book.name as bookName,\n" +
            "    tbl_book.isbn,tbl_book_transaction.to_date as toDate,tbl_book_transaction.from_date as fromDate,tbl_book_transaction.rent_status as rentStatus\n" +
            "from tbl_book,tbl_book_transaction,tbl_member where tbl_book.id=tbl_book_transaction.book_id and\n" +
            "                                                    tbl_book_transaction.member_id=tbl_member.id")
    List<BookTransactionDetails> getAllTranasactionDetails();

    @Select("select tbl_member.id as memberId,tbl_member.name as memberName,tbl_book.id as bookId,tbl_book.name as bookName,\n" +
            "    tbl_book.isbn,tbl_book_transaction.to_date as toDate,tbl_book_transaction.from_date as fromDate,tbl_book_transaction.rent_status as rentStatus\n" +
            "from tbl_book,tbl_book_transaction,tbl_member where tbl_book.id=tbl_book_transaction.book_id and\n" +
            "                                                    tbl_book_transaction.member_id=tbl_member.id and from_date=DATE(CURRENT_TIMESTAMP);")
    List<BookTransactionDetails> getTodayTransactionDetails();
}
