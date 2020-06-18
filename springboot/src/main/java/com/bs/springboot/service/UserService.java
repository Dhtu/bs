package com.bs.springboot.service;

import java.util.List;

import com.bs.springboot.pojo.User;

public interface UserService {
    int add(User user);

    void delete(int uid);

    User get(int uid);

    int update(User user);

    List<User> list();

    int login(User user);


}
