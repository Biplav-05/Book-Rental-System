package com.example.bookkeepingsys.converter;

import com.example.bookkeepingsys.model.Author;
import com.example.bookkeepingsys.pojo.AuthorPojo;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class AuthorConverter {
    //this is used to map the pojo and entity
    private ModelMapper modelMapper;

    public AuthorConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public AuthorPojo  entityToPojo(Author author)
    {
            AuthorPojo authorPojo = this.modelMapper.map(author,AuthorPojo.class);
            return authorPojo;
    }
    public List<AuthorPojo> entityToPojoOfList(List<Author> authors)
    {
        return authors.stream().map(author -> modelMapper.map(author,AuthorPojo.class)).collect(Collectors.toList());
    }

    public Author pojoToEntity(AuthorPojo authorPojo)
    {
        Author author = this.modelMapper.map(authorPojo,Author.class);
        return author;
    }
    public List<Author> pojoToEntityList(List<AuthorPojo> authorPojo)
    {
        return authorPojo.stream().map(authorPojo1 -> modelMapper.map(authorPojo1,Author.class)).collect(Collectors.toList());

    }
}
