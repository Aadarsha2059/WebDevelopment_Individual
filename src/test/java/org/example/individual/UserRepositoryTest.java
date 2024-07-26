package org.example.individual;


import org.assertj.core.api.Assert;
import org.assertj.core.api.Assertions;
import org.example.individual.Entity.User;
import org.example.individual.Repository.UserRepository;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;
import java.util.Optional;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    @Rollback(value = false)
    @Order(1)
    public void saveUserTest(){
        User user = new User();
        user.setUserName("KP Oli");
        user.setEmail("kpoli@gmail.com");
        user.setPassword("123456");
        user.setAddress("Balkot");

        user=userRepository.save(user);

        Assertions.assertThat(user.getId()).isGreaterThan(0);


    }
    @Test
    @Order(2)
    public void findByIdTest(){



        User userGet = userRepository.findById(1).get();
        Assertions.assertThat(userGet.getId()).isEqualTo(1);
    }
    @Test
    @Order(3)
    public void findAllUserData(){
        List<User> users = userRepository.findAll();
        Assertions.assertThat(users.size()).isGreaterThan(0);

    }
    @Test
    @Order(4)
    public void updateUser(){
        User user=userRepository.findById(1).get();
        user.setUserName("Sherbahadur");

        User userUpdated=userRepository.save(user);
        Assertions.assertThat(userUpdated.getUserName()).isEqualTo("Sherbahadur");



    }
    @Test
    @Order(5)
    @Rollback(value = false)
    public void deleteUserTest(){
        User user=userRepository.findById(1).get();
        userRepository.delete(user);

        //userRepository.deleteById(1);

        User user1=null;

        Optional<User>optionalUser= Optional.ofNullable(userRepository.findByUsernameAndPassword("Ram", "1233"));
        if(optionalUser.isPresent()){
            user1=optionalUser.get();

        }
        Assertions.assertThat(user1).isNull();

    }
}

