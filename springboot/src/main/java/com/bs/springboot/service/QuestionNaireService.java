package com.bs.springboot.service;

import com.bs.springboot.pojo.QuestionNaire;

import java.util.List;

public interface QuestionNaireService {
    public int add(QuestionNaire questionNaire);

    public void delete(int qid);

    public QuestionNaire get(int qid);

    public int update(QuestionNaire questionNaire);

    public List<QuestionNaire> list();
}
