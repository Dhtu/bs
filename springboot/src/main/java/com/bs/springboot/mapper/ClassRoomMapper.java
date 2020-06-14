package com.bs.springboot.mapper;

import java.util.List;

import com.bs.springboot.pojo.ClassRoom;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ClassRoomMapper {
    public int add(ClassRoom classRoom);

    public void delete(String id);

    public ClassRoom get(String id);

    public int update(ClassRoom classRoom);

    public List<ClassRoom> list();
}