package com.example.bookkeepingsys.repository;

import com.example.bookkeepingsys.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<Author,Integer> {
    @Query(value = "select * from tbl_author where id=?1",nativeQuery = true)
    Optional<Author> findSpecificAuthor(Integer authorId);
@Query(value = "select * from tbl_author where id=?1",nativeQuery = true)
    Optional<Author> getAuthor(Integer authorId);

@Query(value = "select * from tbl_author where id=?1",nativeQuery = true)
    Optional<Author> findAuthor(List<Integer> authorId);

@Query(value = "select * from tbl_author where id=?1",nativeQuery = true)
List<Author> findAuthorOnly(List<Integer> authorId);
}
