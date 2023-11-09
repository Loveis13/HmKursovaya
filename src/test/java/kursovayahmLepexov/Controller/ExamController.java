package kursovayahmLepexov.Controller;

import kursovayahmLepexov.dto.Question;
import kursovayahmLepexov.service.ExaminerService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Queue;

@RestController

public class ExamController {
    private ExaminerService examinerService;

    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }

    @GetMapping("/get/{amount}")
    public Collection<Question> getQuestions(@PathVariable int amount) {
        return examinerService.getQuestion(amount);
    }
}
