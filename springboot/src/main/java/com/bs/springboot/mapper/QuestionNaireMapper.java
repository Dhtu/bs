package com.bs.springboot.mapper;

import com.bs.springboot.pojo.QuestionNaire;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface QuestionNaireMapper {
    int add(QuestionNaire questionNaire);

    void delete(int qid);

    QuestionNaire get(int qid);

    int update(QuestionNaire questionNaire);

    List<QuestionNaire> list();

    List<QuestionNaire> SelectedList(int uid);
}
