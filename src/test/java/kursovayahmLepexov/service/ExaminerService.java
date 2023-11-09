package kursovayahmLepexov.service;

import kursovayahmLepexov.dto.Question;

import java.util.Collection;
import java.util.Collections;

public interface ExaminerService {
    Collection<Question>getQuestion(int amount);
}
