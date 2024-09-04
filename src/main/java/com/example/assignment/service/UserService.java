package com.example.assignment.service;

import com.example.assignment.entity.User;

import java.util.List;

public interface UserService {
    boolean checkUser(String username, String password);
    List<User> findAll();
    void add(User user);
    void update(User user);
    User findByID(String id);
    void deleteByID(String id);
    boolean isExists(String id);
    boolean isExists2(String email);
}
