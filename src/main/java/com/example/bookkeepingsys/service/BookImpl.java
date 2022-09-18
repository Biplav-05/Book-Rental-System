package com.example.bookkeepingsys.service;

import com.example.bookkeepingsys.converter.BookConverter;
import com.example.bookkeepingsys.misc.ApiResponse;
import com.example.bookkeepingsys.model.Author;
import com.example.bookkeepingsys.model.Book;
import com.example.bookkeepingsys.pojo.BookPojo;
import com.example.bookkeepingsys.repository.AuthorRepository;
import com.example.bookkeepingsys.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class BookImpl extends ApiResponse implements BookService{
    private BookRepository bookRepository;
    private BookConverter bookConverter;

    private AuthorRepository authorRepository;

    public BookImpl(BookRepository bookRepository, BookConverter bookConverter, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.bookConverter = bookConverter;
        this.authorRepository = authorRepository;
    }

    @Override
    public ApiResponse getAllBooks() {
//        List<Book> books = bookRepository.findAll();
//        List<BookPojo> bookPojoList = bookConverter.bookEntityToPojoList(books);
        return success("All the books are",bookRepository.findAll());
    }

    @Override
    public ApiResponse addBook(BookPojo bookPojo) {
        Book book = bookConverter.bookPojoToEntity(bookPojo);
       book= bookRepository.save(book);
        return success("Book added ...",null);
    }

    @Override
    public ApiResponse bookToAuthor(Integer bookId, Integer authorId) {

        Optional<Book> booksId = bookRepository.findById(bookId);
        Optional<Author> authorsId = authorRepository.findAllById(authorId);
        if(bookId!=null && authorId!=null)
        {
            if(booksId.isPresent() && authorsId.isPresent())
            {
                Book book = bookRepository.findById(bookId).get();
                Author author = authorRepository.findById(authorId).get();

                book.addAuthorToBook(author);
                bookRepository.save(book);
                return success("author is added to book",null);
            }
            return error("bbokID or author id is not present..",null);

        }
        return error("empty id......",null);



    }
}
