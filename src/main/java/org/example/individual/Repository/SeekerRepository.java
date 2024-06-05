package org.example.individual.Repository;

import org.example.individual.Entity.Seeker;
import org.example.individual.Pojo.SeekerProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeekerRepository extends JpaRepository<Seeker, Integer> {

    @Query(nativeQuery = true, value = "select id, seeker_id as seekerID, name as name,email as email, address from seeker")
    List<SeekerProjection> findAllData();
}
