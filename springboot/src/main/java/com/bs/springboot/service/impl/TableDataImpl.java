package com.bs.springboot.service.impl;

import com.bs.springboot.mapper.TableDataMapper;
import com.bs.springboot.pojo.TableData;
import com.bs.springboot.service.TableDataService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TableDataImpl implements TableDataService {
    final
    TableDataMapper tableDataMapper;

    public TableDataImpl(TableDataMapper tableDataMapper) {
        this.tableDataMapper = tableDataMapper;
    }

    @Override
    public int add(TableData TableData) {
        return tableDataMapper.add(TableData);
    }

    @Override
    public void delete(int did) {
        tableDataMapper.delete(did);
    }

    @Override
    public TableData get(int did) {
        return tableDataMapper.get(did);
    }

    @Override
    public int update(TableData TableData) {
        return tableDataMapper.update(TableData);
    }

    @Override
    public List<TableData> list() {
        return tableDataMapper.list();
    }

    @Override
    public List<TableData> listSelected(int uid) {
        return tableDataMapper.SelectedList(uid);
    }

    @Override
    public List<TableData> listSelectedQid(int uid, int qid) {
        TableData td = new TableData();
        td.setUid(uid);
        td.setQid(qid);
        return tableDataMapper.SelectedListQid(td);
    }


}
