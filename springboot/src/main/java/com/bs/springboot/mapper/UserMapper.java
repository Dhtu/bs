package com.bs.springboot.mapper;
import com.bs.springboot.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    public int add(User user);

    public void delete(int uid);

    public User get(int uid);

    public int update(User user);

    public List<User> list();
}
