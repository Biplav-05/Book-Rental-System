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
    private final Book bookModel;
    private final BookRepository bookRepository;
    private final BookConverter bookConverter;
    private final AuthorRepository authorRepository;
    private final BookMapper bookMapper;
    private final CategoryRepository categoryRepository;

    public BookImpl(BookRepository bookRepository, BookConverter bookConverter, AuthorRepository authorRepository, BookMapper bookMapper, CategoryRepository categoryRepository, Book bookModel) {
        this.bookRepository = bookRepository;
        this.bookConverter = bookConverter;

        this.authorRepository = authorRepository;
        this.bookMapper = bookMapper;
        this.categoryRepository = categoryRepository;
        this.bookModel = bookModel;
    }

    @Override
    public ApiResponse getAllBooks() {

        //return success("All the books are",bookRepository.findAll());
        //return success("Book details ", bookMapper.allDetails());
        //BookAuthorCategoryTotalDetails abc = new BookAuthorCategoryTotalDetails();
        //List<BookAuthorCategoryTotalDetails> totalList = new ArrayList<>();

//      bookMapper.totalDetails().stream().map(a->a.getBookId()==a.getBookId()).
//               collect(Collectors.toCollection((am)->abc.setBookId()))
//        BookAuthorCategoryTotalDetails bookAuthorCategoryTotalDetails=null;


//        BookAuthorCategoryTotalDetails bookAuthorCategoryTotalDetails = new BookAuthorCategoryTotalDetails();
//        List<BookAuthorCategoryTotalDetails> newList = new ArrayList<>();


//          List<BookAuthorCategoryAll> bookId= bookMapper.totalDetails().stream().filter(a->a.getBookId()!=a.getBookId()).collect(Collectors.toList());
//return success("okok",bookId);


//        for (BookAuthorCategoryAll bookAuthorCategoryAll : bookMapper.totalDetails()) {
//
//            List<Integer> bid = new ArrayList<Integer>();
//            bid.add(bookAuthorCategoryAll.getBookId());
//
//            if (bid.contains(bookAuthorCategoryAll.getBookId())) {
//
//                bookAuthorCategoryTotalDetails.setBookName(bookAuthorCategoryAll.getBookName());
//                bookAuthorCategoryTotalDetails.setAuthorName(Collections.singletonList(bookAuthorCategoryAll.getAuthorName()));
//                bookAuthorCategoryTotalDetails.setIsbn(bookAuthorCategoryAll.getIsbn());
//                bookAuthorCategoryTotalDetails.setIsbn(bookAuthorCategoryAll.getIsbn());
//                bookAuthorCategoryTotalDetails.setBookId(bookAuthorCategoryAll.getBookId());
//                bookAuthorCategoryTotalDetails.setCategoryName(bookAuthorCategoryAll.getCategoryName());
//                bookAuthorCategoryTotalDetails.setRating(bookAuthorCategoryAll.getRating());
//                bookAuthorCategoryTotalDetails.setStockCount(bookAuthorCategoryAll.getStockCount());
//                bookAuthorCategoryTotalDetails.setPublishedDate(bookAuthorCategoryAll.getPublishedDate());
//                bookAuthorCategoryTotalDetails.setPhoto(bookAuthorCategoryAll.getPhoto());
//                newList.add(bookAuthorCategoryTotalDetails);
//
//            }
//            bookAuthorCategoryTotalDetails.setBookName(bookAuthorCategoryAll.getBookName());
//            bookAuthorCategoryTotalDetails.setAuthorName(Collections.singletonList(bookAuthorCategoryAll.getAuthorName()));
//            bookAuthorCategoryTotalDetails.setIsbn(bookAuthorCategoryAll.getIsbn());
//            bookAuthorCategoryTotalDetails.setIsbn(bookAuthorCategoryAll.getIsbn());
//            bookAuthorCategoryTotalDetails.setBookId(bookAuthorCategoryAll.getBookId());
//            bookAuthorCategoryTotalDetails.setCategoryName(bookAuthorCategoryAll.getCategoryName());
//            newList.add(bookAuthorCategoryTotalDetails);
//
//        }
//
//
//        return success("kkk", newList);
        return null;
        // return success("okok",bookMapper.totalDetails());

    }

    @Override
    public ApiResponse addBook(BookPojo bookPojo) {
        Book book = bookConverter.bookPojoToEntity(bookPojo);
        List<Integer> authors = bookPojo.getAuthorId();
        if (authors.size() == bookMapper.countAuthor(authors)) {
            Optional<Category> categoryId = categoryRepository.findById(bookPojo.getCategoryId());
            if (categoryId.isPresent()) {

                Book newBook = new Book();
                newBook.setName(bookPojo.getName());
                newBook.setIsbn(bookPojo.getIsbn());
                newBook.setPhoto(bookPojo.getPhoto());
                newBook.setRating(bookPojo.getRating());
                newBook.setStockCount(bookPojo.getStockCount());
                newBook.assignCategory(bookMapper.allCategory(bookPojo.getCategoryId()));
                newBook.addAuthorToBook(bookMapper.allAuthor(bookPojo.getAuthorId()));
                bookRepository.save(newBook);
                return success("ok added", null);

            }
            return error("Category id " + bookPojo.getCategoryId() + "does not exist", null);

        }
        return error("Author id: " + bookPojo.getAuthorId() + " didn't found", null);

        //return null;

    }

    @Override
    public ApiResponse bookToAuthor(Integer bookId, Integer authorId) {
        Optional<Book> booksId = bookRepository.findSpecificBook(bookId);
        Optional<Author> authorsId = authorRepository.findSpecificAuthor(authorId);
        if (bookId != null && authorId != null) {
            if (booksId.isPresent() && authorsId.isPresent()) {
                Book book = bookRepository.getBook(bookId).get();
                Author author = authorRepository.getAuthor(authorId).get();

                //book.addAuthorToBook(author);
                bookRepository.save(book);
                return success(author.getName() + "  is added to  " + book.getName(), null);
            }
            return error("bokID or author id is not present..", null);

        }
        return error("error", null);
    }

    @Override
    public ApiResponse addCategoryToBook(Integer bookId, Integer categoryId) {

        Optional<Book> book = bookRepository.findById(bookId);
        Optional<Category> category = categoryRepository.findById(categoryId);


        if (book.isPresent() && category.isPresent()) {
            Book book1 = bookRepository.findById(bookId).get();
            Category category1 = categoryRepository.findById(categoryId).get();
            book1.assignCategory(category1);
            bookRepository.save(book1);
            return success("Category : " + category1.getName() + " is assign to book :" + book1.getName(), null);

        }
        return error("bookId or categoryId is not present in db", null);


    }

    @Override
    public ApiResponse getAllBookWhithoutJoin() {

        //return success("All Books Whithout Join", bookRepository.findAll());
//       List<ListAllAuthorBookCategory> a = bookConverter.listAllAuthorBookCategories(bookRepository.findAll());
//       return success("All Data ",a);
        return success("A;ll data", bookRepository.findAll());

    }

    @Override
    public ApiResponse findBookOnly() {
        return success("Book data", bookMapper.allBooks());
    }


}
