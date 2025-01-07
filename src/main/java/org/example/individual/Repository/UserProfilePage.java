package org.example.individual.Repository;

import org.example.individual.Entity.UserProfile;
import org.example.individual.Pojo.UserProfilePageProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserProfilePage extends JpaRepository<UserProfile, Integer> {

    @Query(nativeQuery = true, value = "select up.id as id  from userprofile up")
    List<UserProfilePageProjection> findAllProjections();
}
