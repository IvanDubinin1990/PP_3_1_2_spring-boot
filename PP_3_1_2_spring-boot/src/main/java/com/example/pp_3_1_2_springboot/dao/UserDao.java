package com.example.pp_3_1_2_springboot.dao;


import com.example.pp_3_1_2_springboot.model.User;

import java.util.List;

public interface UserDao {
    List<User> getAllUsers();
    void saveUser(User user);
    User findUserId (int id);
    void updateUser(User user);
    void deleteUser(int id);
}
