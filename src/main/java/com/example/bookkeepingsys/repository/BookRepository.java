package com.example.bookkeepingsys.repository;

import com.example.bookkeepingsys.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Integer> {
}
