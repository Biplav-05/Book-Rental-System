package com.example.bookkeepingsys.service;

import com.example.bookkeepingsys.converter.AuthorConverter;
import com.example.bookkeepingsys.misc.ApiResponse;
import com.example.bookkeepingsys.model.Author;
import com.example.bookkeepingsys.pojo.AuthorPojo;
import com.example.bookkeepingsys.repository.AuthorRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthorImpl extends ApiResponse implements  AuthorService {

    private AuthorRepository authorRepository;
    private AuthorConverter authorConverter;

    public AuthorImpl(AuthorRepository authorRepository, AuthorConverter authorConverter) {
        this.authorRepository = authorRepository;
        this.authorConverter = authorConverter;
    }

    @Override
    public ApiResponse totalAuthor() {
        return success("All Author Data ",authorRepository.findAll());
    }

    @Override
    public ApiResponse addAuthor(AuthorPojo authorPojo) {
        Author author = authorConverter.pojoToEntity(authorPojo);
        author=authorRepository.save(author);
        return success("Author is added",null);
    }
}
