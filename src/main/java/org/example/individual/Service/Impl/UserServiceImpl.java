package org.example.individual.Service.Impl;

import lombok.RequiredArgsConstructor;
import org.example.individual.Entity.User;
import org.example.individual.Pojo.AuthPojo;
import org.example.individual.Pojo.UserPojo;
import org.example.individual.Repository.UserRepository;
import org.example.individual.Service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public Integer save(UserPojo userPojo) {
        User user = new User();

        user.setId(userPojo.getId());
        user.setUserName(userPojo.getUserName());
        user.setEmail(userPojo.getEmail());
        user.setAddress(userPojo.getAddress());

        user = userRepository.save(user);
        return user.getId();
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Integer id) {
        userRepository.deleteById(id);
    }

    @Override
    public Integer getUserIdByUserNameAndPword(AuthPojo authPojo) {
        return userRepository.findByUsernameAndPassword(authPojo.getUsername(), authPojo.getPassword()).getId();
    }


}
