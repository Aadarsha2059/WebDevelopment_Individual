package org.example.individual.Repository;

import org.example.individual.Entity.UserProfile;
import org.example.individual.Pojo.UserProfilePageProjection;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserProfilePage extends JpaRepository<UserProfile, Integer> {

    List<UserProfilePageProjection> findAllProjections();
}
