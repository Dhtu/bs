package com.bs.springboot.service.impl;

import com.bs.springboot.mapper.TableDataMapper;
import com.bs.springboot.pojo.TableData;
import com.bs.springboot.service.TableDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TableDataImpl implements TableDataService {
    @Autowired
    TableDataMapper tableDataMapper;

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

}
