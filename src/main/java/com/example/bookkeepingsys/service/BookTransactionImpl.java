package com.example.bookkeepingsys.service;

import com.example.bookkeepingsys.converter.BookTransactionConverter;
import com.example.bookkeepingsys.mapper.BookTransactionMapper;
import com.example.bookkeepingsys.misc.ApiResponse;
import com.example.bookkeepingsys.model.BookTransaction;
import com.example.bookkeepingsys.pojo.BookPojo;
import com.example.bookkeepingsys.pojo.BookTransactionPojo;
import com.example.bookkeepingsys.pojo.MemberPojo;
import com.example.bookkeepingsys.repository.BookTransactionRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookTransactionImpl extends ApiResponse implements BookTransactionService{
    private final BookTransactionConverter bookTransactionConverter;
    private final BookTransactionRepository bookTransactionRepository;

    private final BookTransactionMapper bookTransactionMapper;

    public BookTransactionImpl(BookTransactionConverter bookTransactionConverter, BookTransactionRepository bookTransactionRepository, BookTransactionMapper bookTransactionMapper) {
        this.bookTransactionConverter = bookTransactionConverter;
        this.bookTransactionRepository = bookTransactionRepository;
        this.bookTransactionMapper = bookTransactionMapper;
    }

    @Override
    public ApiResponse addNewTransaction(BookTransactionPojo bookTransactionPojo) {

            if (bookTransactionPojo.getMemberId() != null && bookTransactionPojo.getBookId() != null) {
                Optional<BookPojo> bookId = bookTransactionMapper.getBookId(bookTransactionPojo.getBookId());
                if (bookId.isPresent()) {
                    Optional<MemberPojo> specificMember = bookTransactionMapper.findSpecificMember(bookTransactionPojo.getMemberId());
                    if (specificMember.isPresent()) {
                        //Optional<BookTransactionPojo> checkMemberTransaction = bookTransactionMapper.checkMemberTransaction(bookTransactionPojo.getMemberId());
                        String rentStatus = bookTransactionMapper.getRentStatus(bookTransactionPojo.getMemberId());
                        if (rentStatus==null || !rentStatus.equals("Rent_Book")) {

                            Integer count = bookTransactionMapper.stockCount(bookTransactionPojo.getBookId());
                            if (count >= 1) {
                                BookTransaction bookTransaction = bookTransactionConverter.pojoToEntity(bookTransactionPojo);
                                bookTransaction = bookTransactionRepository.save(bookTransaction);
                                bookTransactionMapper.decreaseBookCount(bookTransactionPojo.getBookId());
                                return success("book transaction is done ", null);

                            }
                            return error("Book id:" + bookTransactionPojo.getBookId() + " has 0 books left", null);
                        }
                        return error("Member id " + bookTransactionPojo.getMemberId() + " already rented book", null);

                    }
                    return error("Member id :" + bookTransactionPojo.getMemberId() + " is not present", null);

                }
                return error("Book id: " + bookTransactionPojo.getMemberId() + " is not present", null);

            }
            return error(bookTransactionPojo.getBookId() + " or " + bookTransactionPojo.getMemberId() + " is null", null);


    }

    @Override
    public ApiResponse getAllDetails() {
        return success("ALl transaction details ",bookTransactionMapper.getAllTranasactionDetails());

    }

    @Override
    public ApiResponse findTodayTransaction() {
        return success("Today's Book Transaction Details...",bookTransactionMapper.getTodayTransactionDetails());
    }

    @Override
    public ApiResponse returnBook(BookTransactionPojo bookTransactionPojo) {

        if(bookTransactionPojo.getMemberId()!=null && bookTransactionPojo.getBookId()!=null)
        {
            Optional<BookPojo> bookId = bookTransactionMapper.getBookId(bookTransactionPojo.getBookId());
            if(bookId.isPresent())
            {
                Optional<MemberPojo> specificMember = bookTransactionMapper.findSpecificMember(bookTransactionPojo.getMemberId());
                if(specificMember.isPresent())
                {
                    String rentStatus = bookTransactionMapper.getRentStatus(bookTransactionPojo.getMemberId());
                    if(rentStatus.equals("Rent_Book"))
                    {
                        BookTransaction bookTransaction = bookTransactionConverter.pojoToEntity(bookTransactionPojo);
                        bookTransaction = bookTransactionRepository.save(bookTransaction);
                        bookTransactionMapper.increaseBookCount(bookTransactionPojo.getBookId());
                        return success("book transaction is done ", null);
                    }

                }
                return error("Member Id : "+bookTransactionPojo.getMemberId()+" does not rent any book",null);

            }
            return error("Book Id : "+bookTransactionPojo.getBookId()+" does not exist",null);

        }
        return error("book id or member id is null",null);


    }

}
