package org.example.individual.Controller;


import lombok.RequiredArgsConstructor;
import org.example.individual.Entity.User;
import org.example.individual.Pojo.AuthPojo;
import org.example.individual.Pojo.GlobalAPIResponse;
import org.example.individual.Pojo.UserPojo;
import org.example.individual.Service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping
    public List<User> findAll() {
        return this.userService.findAll();
    }

    @PostMapping
    public GlobalAPIResponse<Integer> save(@RequestBody UserPojo userPojo) {
        GlobalAPIResponse<Integer> globalAPIResponse = new GlobalAPIResponse<>();
        Integer userId = userService.save(userPojo);
        globalAPIResponse.setData(userId);
        globalAPIResponse.setData(200);
        globalAPIResponse.setMessage("data saved successfully");
        return globalAPIResponse;

    }

    @PutMapping
    public void update(@RequestBody UserPojo userPojo) {
        userService.save(userPojo);

    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id) {
        userService.deleteById(id);


    }

    @GetMapping("{id}")
    public User findById(@PathVariable Integer id) {
        return this.userService.findById(id);
    }

    @PostMapping("/login")
    public Integer getUserIdByUserNameAndPword(@RequestBody AuthPojo authPojo) {
        return userService.getUserIdByUserNameAndPword(authPojo);
    }

}
