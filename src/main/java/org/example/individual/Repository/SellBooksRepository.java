package org.example.individual.Repository;


import jakarta.persistence.criteria.CriteriaBuilder;
import org.example.individual.Entity.Sellbooks;
import org.example.individual.Pojo.SellBooksProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface SellBooksRepository extends JpaRepository<Sellbooks, Integer>{

    @Query(nativeQuery = true, value = "select b.id,s.id as seekerId, b.bookname as name,b.genre as genre,b.image as image,b.bookprice as price, b.bookcondition as book condition, s.user_id as userId from sellbook b left join seeker s on s.book_id=b.id")


    List<Sellbooks> findBooksByUserId(Integer userId);

    List<SellBooksProjection> findAllData();
}
