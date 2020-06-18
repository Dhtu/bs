package com.bs.springboot.service.impl;

import com.bs.springboot.mapper.QuestionNaireMapper;
import com.bs.springboot.pojo.QuestionNaire;
import com.bs.springboot.service.QuestionNaireService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionNaireImpl implements QuestionNaireService {
    final
    QuestionNaireMapper questionNaireMapper;

    public QuestionNaireImpl(QuestionNaireMapper questionNaireMapper) {
        this.questionNaireMapper = questionNaireMapper;
    }

    @Override
    public int add(QuestionNaire questionNaire) {
        return questionNaireMapper.add(questionNaire);
    }

    @Override
    public void delete(int qid) {
        questionNaireMapper.delete(qid);
    }

    @Override
    public QuestionNaire get(int qid) {
        return questionNaireMapper.get(qid);
    }

    @Override
    public int update(QuestionNaire QuestionNaire) {
        return questionNaireMapper.update(QuestionNaire);
    }

    @Override
    public List<QuestionNaire> list() {
        return questionNaireMapper.list();
    }
}
