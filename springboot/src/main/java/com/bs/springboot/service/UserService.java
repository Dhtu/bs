package com.bs.springboot.service;

import java.util.List;

import com.bs.springboot.pojo.User;

public interface UserService {
    public int add(User user);

    public void delete(int uid);

    public User get(int uid);

    public int update(User user);

    public List<User> list();
}
