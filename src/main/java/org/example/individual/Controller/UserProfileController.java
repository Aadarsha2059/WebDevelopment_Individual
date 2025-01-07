package org.example.individual.Controller;


import lombok.RequiredArgsConstructor;
import org.example.individual.Entity.UserProfile;
import org.example.individual.Pojo.GlobalAPIResponse;
import org.example.individual.Pojo.UserProfilePagePojo;
import org.example.individual.Service.UserProfileService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("userprofile")
@RequiredArgsConstructor

public class UserProfileController {
    public final UserProfileService userProfileService;

    @GetMapping
    public List<UserProfile> findAll() {
        return this.userProfileService.findAll();
    }

    @PostMapping
    public UserProfile save(@RequestBody UserProfile userProfilePage) {
        GlobalAPIResponse<Integer> globalAPIResponse =new GlobalAPIResponse<>();
        Integer Id= userProfileService.save(userProfilePage);
        globalAPIResponse.setData(Id);
        globalAPIResponse.setData(200);
        globalAPIResponse.setMessage("data saved successfully");
        return globalAPIResponse;

    }
    @PutMapping
    public void update(@RequestBody UserProfilePagePojo userProfilePagePojo) {
        userProfileService.save(userProfilePagePojo);
    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id) {
        userProfileService.deleteById(id);
    }
    @GetMapping("{id}")
    public UserProfile findById(@PathVariable Integer id) {
        return this.userProfileService.findById(id);
    }



}
