package com.example.assignment.service.impl;

import com.example.assignment.entity.User;
import com.example.assignment.service.UserService;

import java.util.List;

public class UserServiceMockImpl implements UserService {
    @Override
    public boolean checkUser(String username, String password) {
        return "poly".equals(username) && "123".equals(password);
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public void add(User user) {

    }

    @Override
    public void update(User user) {

    }

    @Override
    public User findByID(String id) {
        return null;
    }

    @Override
    public void deleteByID(String id) {

    }

    @Override
    public boolean isExists(String id) {
        return false;
    }

    @Override
    public boolean isExists2(String email) {
        return false;
    }

}
