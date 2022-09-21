package com.example.bookkeepingsys.repository;

import com.example.bookkeepingsys.model.BookTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookTransactionRepository extends JpaRepository<BookTransaction,Integer> {
}
