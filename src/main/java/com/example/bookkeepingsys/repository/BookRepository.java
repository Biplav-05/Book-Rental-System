package com.example.bookkeepingsys.repository;

import com.example.bookkeepingsys.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book,Integer> {
    @Query(value = "select * from tbl_book where id=?1",nativeQuery = true)
    Optional<Book> findSpecificBook(Integer bookId);
@Query(value = "select * from tbl_book where id=?1",nativeQuery = true)
    Optional<Book> getBook(Integer bookId);

@Query(value = "select * from tbl_book where id=?1",nativeQuery = true)
    List<Book> findBook(List<Integer> bookId);
}
