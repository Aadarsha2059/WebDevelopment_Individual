package org.example.individual.Repository;

import org.example.individual.Entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BooksRepository extends JpaRepository<Book,Integer>{
    @Query(nativeQuery = true, value = "select id, books_id as bookID, name as name,genres from books")
    List<BooksProjection> findAllData();


}
