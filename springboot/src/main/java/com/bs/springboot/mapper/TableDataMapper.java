package com.bs.springboot.mapper;
import com.bs.springboot.pojo.TableData;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TableDataMapper {
    int add(TableData tableData);

    void delete(int did);

    TableData get(int did);

    int update(TableData tableData);

    List<TableData> list();

    List<TableData> SelectedList(int uid);

    List<TableData> SelectedListQid(TableData tableData);
}
