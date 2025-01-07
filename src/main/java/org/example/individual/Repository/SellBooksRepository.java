package org.example.individual.Repository;

import org.example.individual.Entity.Sellbooks;
import org.example.individual.Pojo.SellBooksPojo;
import org.example.individual.Pojo.SellBooksProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SellBooksRepository extends JpaRepository<Sellbooks, Long> {

    // Custom query to fetch books for a specific user
    List<SellBooksPojo> findByUserId(Long userId);

    @Query(nativeQuery = true, value = "select sb.id as id,sb.bookcondition as bookCondition  from sellbook sb")
    List<SellBooksProjection> findAllData();

    List<Sellbooks> findBooksByUserId(Integer id);
}
