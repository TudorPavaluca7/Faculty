package com.example.EjbJpaLab.Interfaces;

import com.example.EjbJpaLab.Models.User;

import java.util.List;

public interface UserService {

    public void addUser (String username, String password);
    public List<User> findAll();
    public User find(Long id);
    public Long validate(String username, String password);
    public Long containsBook(Long userId, String title, String author);


}
