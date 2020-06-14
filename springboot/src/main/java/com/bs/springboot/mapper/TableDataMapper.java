package com.bs.springboot.mapper;
import com.bs.springboot.pojo.TableData;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TableDataMapper {
    public int add(TableData tableData);

    public void delete(int did);

    public TableData get(int did);

    public int update(TableData tableData);

    public List<TableData> list();
}
