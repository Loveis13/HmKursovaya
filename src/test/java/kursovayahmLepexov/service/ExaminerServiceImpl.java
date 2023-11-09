package kursovayahmLepexov.service;

import kursovayahmLepexov.dto.Question;
import kursovayahmLepexov.exception.NotEnoughQuestionException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final Random random = new Random();
    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestion(int amount) {
        if (questionService.getAll().size()<amount){
            throw new NotEnoughQuestionException();
        }

        Set<Question>resultQuestionSet = new HashSet<>();

        while (resultQuestionSet.size()< amount){
            resultQuestionSet.add(questionService.getRandomQuestion());

        }

        return resultQuestionSet;
    }
}
