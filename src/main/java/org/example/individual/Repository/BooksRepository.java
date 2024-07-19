package org.example.individual.Repository;

import org.example.individual.Entity.Book;
import org.example.individual.Pojo.BooksProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BooksRepository extends JpaRepository<Book, Integer> {
    @Query(nativeQuery = true, value = "select b.id,s.id as seekerId, b.book_name as name,b.genres as genre,b.image as image,s.user_id as userId from book b left join seeker s on s.book_id=b.id")
    List<BooksProjection> findAllData();

    List<Book> findBooksByUserId(Integer userId);

}
