package com.bs.springboot.mapper;

import com.bs.springboot.pojo.QuestionNaire;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface QuestionNaireMapper {
    public int add(QuestionNaire questionNaire);

    public void delete(int qid);

    public QuestionNaire get(int qid);

    public int update(QuestionNaire questionNaire);

    public List<QuestionNaire> list();
}
