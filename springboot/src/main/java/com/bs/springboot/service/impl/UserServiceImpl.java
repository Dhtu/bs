package com.bs.springboot.service.impl;

import com.bs.springboot.mapper.UserMapper;
import com.bs.springboot.pojo.User;
import com.bs.springboot.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    final
    UserMapper userMapper;

    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public int add(User user) {
        return userMapper.add(user);
    }

    @Override
    public void delete(int id) {
        userMapper.delete(id);
    }

    @Override
    public User get(int id) {
        return userMapper.get(id);
    }


    @Override
    public int update(User user) {
        return userMapper.update(user);
    }

    @Override
    public List<User> list() {
        return userMapper.list();
    }

    @Override
    public int login(User user) {
        int uid = user.getUid();
        String userName = user.getUname();
        String userPassword = user.getPassword();
        System.out.println(userName + userPassword);

        int result = -1;


        //用户不存在
        if (userMapper.get(uid) == null) {
//            return "用户不存在";
            result = 0;
            return result;
            //用户存在，但密码输入错误
        } else if (!userMapper.get(uid).getPassword().equals(userPassword)) {
            result = 1;
            return result;
//            return "账号或密码输入错误";
        } else if (userMapper.get(uid).getPassword().equals(userPassword)) {
            result = 2;
//            return "成功登录";
            return result;
        }
        return result;
    }
}
