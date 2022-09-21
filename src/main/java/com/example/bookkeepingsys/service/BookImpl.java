package com.example.bookkeepingsys.service;

import com.example.bookkeepingsys.converter.BookConverter;
import com.example.bookkeepingsys.mapper.BookMapper;
import com.example.bookkeepingsys.misc.ApiResponse;
import com.example.bookkeepingsys.model.Author;
import com.example.bookkeepingsys.model.Book;
import com.example.bookkeepingsys.model.Category;
import com.example.bookkeepingsys.pojo.BookPojo;
import com.example.bookkeepingsys.repository.AuthorRepository;
import com.example.bookkeepingsys.repository.BookRepository;
import com.example.bookkeepingsys.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookImpl extends ApiResponse implements BookService {
    private BookRepository bookRepository;
    private BookConverter bookConverter;

    private AuthorRepository authorRepository;
    private BookMapper bookMapper;
    private CategoryRepository categoryRepository;

    public BookImpl(BookRepository bookRepository, BookConverter bookConverter, AuthorRepository authorRepository, BookMapper bookMapper, CategoryRepository categoryRepository) {
        this.bookRepository = bookRepository;
        this.bookConverter = bookConverter;
        this.authorRepository = authorRepository;
        this.bookMapper = bookMapper;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public ApiResponse getAllBooks() {

        //return success("All the books are",bookRepository.findAll());
        return success("Book details ", bookMapper.allDetails());

    }

    @Override
    public ApiResponse addBook(BookPojo bookPojo) {
        Book book = bookConverter.bookPojoToEntity(bookPojo);

        //return success("book is saved",null)

        Optional<Category> categoryId = categoryRepository.findById(bookPojo.getCategoryId());
        // Optional<Book> bookId = bookRepository.findById(book.getId());
        if (categoryId.isPresent()) {
            bookRepository.save(book);
            Book b1 = bookRepository.findById(book.getId()).get();
            Category c1 = categoryRepository.findById(bookPojo.getCategoryId()).get();
            b1.assignCategory(c1);
            bookRepository.save(b1);
            return success(book.getName() + " is added and book's category is " + c1.getName(), null);
        }
        return error("Category id " + bookPojo.getCategoryId() + "does not exist", null);
        // return success("Book added ...",null);

    }

    @Override
    public ApiResponse bookToAuthor(Integer bookId, Integer authorId) {


        Optional<Book> booksId = bookRepository.findSpecificBook(bookId);
        Optional<Author> authorsId = authorRepository.findSpecificAuthor(authorId);
        if (bookId != null && authorId != null) {
            if (booksId.isPresent() && authorsId.isPresent()) {
                Book book =  bookRepository.getBook(bookId).get();
                Author author = authorRepository.getAuthor(authorId).get();

                book.addAuthorToBook(author);
                bookRepository.save(book);
                return success(author.getName() + "  is added to  " + book.getName(), null);
            }
            return error("bokID or author id is not present..", null);

        }
        return error("empty id......", null);


    }

    @Override
    public ApiResponse addCategoryToBook(Integer bookId, Integer categoryId) {

        Optional<Book> book = bookRepository.findById(bookId);
        Optional<Category> category = categoryRepository.findById(categoryId);


        if (bookId != null && categoryId != null) {
            if (book.isPresent() && category.isPresent()) {
                Book book1 = bookRepository.findById(bookId).get();
                Category category1 = categoryRepository.findById(categoryId).get();
                book1.assignCategory(category1);
                bookRepository.save(book1);
                return success("Category : " + category1.getName() + " is assign to book :" + book1.getName(), null);

            }
            return error("bookId or categoryId is not present in db", null);
        }
        return error("bookId  or categoryId is null", null);


    }

    @Override
    public ApiResponse getAllBookWhithoutJoin() {
        return success("All Books Whithout Join", bookRepository.findAll());
    }

    @Override
    public ApiResponse findBookOnly() {
        return success("Book data",bookMapper.allBooks());
    }
}
