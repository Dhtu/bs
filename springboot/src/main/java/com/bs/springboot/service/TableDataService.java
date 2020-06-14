package com.bs.springboot.service;

import com.bs.springboot.pojo.TableData;

import java.util.List;

public interface TableDataService {
    public int add(TableData tableData);

    public void delete(int did);

    public TableData get(int did);

    public int update(TableData tableData);

    public List<TableData> list();
}
