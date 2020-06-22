package com.bs.springboot.service;

import com.bs.springboot.pojo.TableData;

import java.util.List;

public interface TableDataService {
    int add(TableData tableData);

    void delete(int did);

    TableData get(int did);

    int update(TableData tableData);

    List<TableData> list();

    List<TableData> listSelected(int uid);

    List<TableData> listSelectedQid(int uid, int qid);
}
