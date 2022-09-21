package com.example.bookkeepingsys.converter;

import com.example.bookkeepingsys.model.BookTransaction;
import com.example.bookkeepingsys.pojo.BookTransactionPojo;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.persistence.Converter;

@Service
public class BookTransactionConverter {
    private final ModelMapper modelMapper;

    public BookTransactionConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public BookTransaction pojoToEntity(BookTransactionPojo bookTransactionPojo)
    {
        return this.modelMapper.map(bookTransactionPojo, BookTransaction.class);
    }
}
