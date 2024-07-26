package org.example.individual.Service;

import org.example.individual.Entity.User;
import org.example.individual.Pojo.AuthPojo;
import org.example.individual.Pojo.UserPojo;

import java.util.List;

public interface UserService {

    Integer save(UserPojo userPojo);

    List<User> findAll();

    User findById(Integer id);

    void deleteById(Integer id);

    Integer getUserIdByUserNameAndPword(AuthPojo authPojo);



}
