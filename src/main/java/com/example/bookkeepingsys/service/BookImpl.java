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

import java.util.Optional;

@Service
public class BookImpl extends ApiResponse implements BookService{
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
        return success("Book details ",bookMapper.allDetails());

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
                return success(author.getName()+"  is added to book "+book.getName(),null);
            }
            return error("bbokID or author id is not present..",null);

        }
        return error("empty id......",null);



    }

    @Override
    public ApiResponse addCategoryToBook(Integer bookId, Integer categoryId) {

        Optional<Book> book = bookRepository.findById(bookId);
        Optional<Category> category = categoryRepository.findById(categoryId);


        if(bookId!=null && categoryId!=null)
        {
            if (book.isPresent() && category.isPresent())
            {
                Book book1 = bookRepository.findById(bookId).get();
                Category category1 = categoryRepository.findById(categoryId).get();
                book1.assignCategory(category1);
                bookRepository.save(book1);
                return  success("Category : "+category1.getName()+" is assign to book :"+book1.getName(),null);

            }
            return error("bookId or categoryId is not present in db",null);
        }
        return error("bookId  or categoryId is null",null);



    }

    @Override
    public ApiResponse getAllBookWhithoutJoin() {
        return success("All Books Whithout Join",bookRepository.findAll());
    }
}
