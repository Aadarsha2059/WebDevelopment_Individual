package org.example.individual;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import lombok.extern.log4j.Log4j2;
import org.example.individual.Entity.User;
import org.example.individual.Repository.UserRepository;
import org.example.individual.Service.UserService;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@Log4j2
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)

public class UserStepDifinitions {
    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Given("find all list")
    public void findAllList() {
        List<User> allUser= userService.fetchAll();
        log.info(allUser);
        Assert.assertTrue(!allUser.isEmpty());
    }

    @Given("find user by id")
    public void findUserById() {
        userService.fetchById(1);
        System.out.println("User fetch successfully");
    }
    @Given("post data")
        public void post_data(){
        //logic to post
    }
    @Given("verify")
    public void verify(){

    }
    @Then("finally")
    public void finallyTest(){
        //find by email

    }




}
