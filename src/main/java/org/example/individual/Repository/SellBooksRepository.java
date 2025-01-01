package org.example.individual.Repository;

import org.example.individual.Entity.Sellbooks;
import org.example.individual.Pojo.SellBooksPojo;
import org.example.individual.Pojo.SellBooksProjection;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SellBooksRepository extends JpaRepository<Sellbooks, Long> {

    // Custom query to fetch books for a specific user
    List<SellBooksPojo> findByUserId(Long userId);

    List<SellBooksProjection> findAllData();

    List<Sellbooks> findBooksByUserId(Integer id);
}
