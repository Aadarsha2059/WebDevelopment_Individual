package org.example.individual.Service;

import org.example.individual.Entity.UserProfile;
import org.example.individual.Pojo.UserProfilePagePojo;
import org.example.individual.Pojo.UserProfilePageProjection;

import java.util.List;

public interface UserProfileService {
    List<UserProfilePageProjection> findAllProj();

    List<UserProfile> findAll();

    Integer save(UserProfile userProfilePage);

    Integer save(UserProfilePagePojo userProfilePagePojo);

    void deleteById(Integer id);

    UserProfile findById(Integer id);
}
