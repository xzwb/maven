package com.xzwb123.question.service.impl;

import com.xzwb123.question.dao.Impl.QuestionDaoImpl;
import com.xzwb123.question.dao.QuestionDao;
import com.xzwb123.question.service.QuestionService;

import java.util.Map;

public class QuestionServiceImpl implements QuestionService {
    QuestionDao questionDao = new QuestionDaoImpl();
    @Override
    public boolean questionService(Map<String, String> qAndA) {
        for (String value : qAndA.values()) {
            if (value == "") {
                return false;
            }
        }
        questionDao.questionDao(qAndA);
        return true;
    }
}
