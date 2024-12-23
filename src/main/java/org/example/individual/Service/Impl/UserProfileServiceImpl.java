package org.example.individual.Service.Impl;

import lombok.RequiredArgsConstructor;
import org.example.individual.Entity.UserProfile;
import org.example.individual.Pojo.UserProfilePagePojo;
import org.example.individual.Pojo.UserProfilePageProjection;
import org.example.individual.Repository.UserProfilePage;
import org.example.individual.Service.UserProfileService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public  class UserProfileServiceImpl implements UserProfileService {
    private final UserProfilePage userProfilePage; // Repository

    @Override
    public Integer save(UserProfilePagePojo userProfilePagePojo) {
        UserProfile userProfile = new UserProfile();

        // Mapping POJO to Entity
        userProfile.setId(userProfilePagePojo.getId());
        userProfile.setFullName(userProfilePagePojo.getFullname());
        userProfile.setAge(userProfilePagePojo.getAge());
        userProfile.setGender(userProfilePagePojo.getGender());
        userProfile.setLocation(userProfilePagePojo.getLocation());
        userProfile.setContact(userProfilePagePojo.getContact());
        userProfile.setUpdatePassword(userProfilePagePojo.getUpdatePassword());
        userProfile.setConfirmPassword(userProfilePagePojo.getConfirmPassword());
        userProfile.setUpdateEmail(userProfilePagePojo.getUpdateEmail());

        // Save and return generated ID
        userProfilePage.save(userProfile);
        return userProfile.getId();
    }

    @Override
    public List<UserProfilePageProjection> findAllProj() {
        return userProfilePage.findAllProjections();
    }

    @Override
    public List<UserProfile> findAll() {
        return userProfilePage.findAll();
    }

    @Override
    public Integer save(UserProfile userProfilePage) {
        return 0;
    }

    @Override
    public UserProfile findById(Integer id) {
        return userProfilePage.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Integer id) {
        userProfilePage.deleteById(id);
    }
}
