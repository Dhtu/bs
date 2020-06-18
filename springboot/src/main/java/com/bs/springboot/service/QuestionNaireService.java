package com.bs.springboot.service;

import com.bs.springboot.pojo.QuestionNaire;

import java.util.List;

public interface QuestionNaireService {
    int add(QuestionNaire questionNaire);

    void delete(int qid);

    QuestionNaire get(int qid);

    int update(QuestionNaire questionNaire);

    List<QuestionNaire> list();

    List<QuestionNaire> SelectedList(int uid);
}
