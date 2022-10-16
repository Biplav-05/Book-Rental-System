package com.example.bookkeepingsys.converter;

import com.example.bookkeepingsys.model.Book;
import com.example.bookkeepingsys.pojo.BookPojo;
import com.example.bookkeepingsys.pojo.ListAllAuthorBookCategory;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class BookConverter {
    private ModelMapper modelMapper;

    public BookConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;

    }

    public Book bookPojoToEntity(BookPojo bookPojo)
    {
        Book book = this.modelMapper.map(bookPojo,Book.class);
        return book;

    }
    public BookPojo bookEntityToPojo(Book book)
    {
        BookPojo bookPojo = this.modelMapper.map(book,BookPojo.class);
        return bookPojo;
    }
    public List<BookPojo> bookEntityToPojoList(List<Book> book)
    {
        return book.stream().map(bookList->modelMapper.map(book,BookPojo.class)).collect(Collectors.toList());
    }
    public List<ListAllAuthorBookCategory> listAllAuthorBookCategories (List<Book> books)
    {
        return  books.stream().map(a->modelMapper.map(books,ListAllAuthorBookCategory.class)).collect(Collectors.toList());
    }
}
