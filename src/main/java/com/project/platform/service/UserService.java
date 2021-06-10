package com.project.platform.service;

import com.project.platform.model.User;
import com.project.platform.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User save(User user) {
        return userRepository.save(user);
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User getUser(Integer id) {
        return userRepository.findById(id).get();
    }

    public User updateUser(User user) {
        User userDB = userRepository.getById(user.getId());
        userDB.setUserName(user.getUserName());
        return userRepository.save(userDB);
    }

    public void deleteUser(Integer id) {
        userRepository.deleteAllById(Collections.singleton(id));
    }
}
