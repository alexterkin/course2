package pro.skyjava.course2.examinerservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import pro.skyjava.course2.examinerservice.domain.Question;
import pro.skyjava.course2.examinerservice.service.ExaminerService;

import java.util.Collection;

public class ExamController {
    private final ExaminerService examinerService;

    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }

    @GetMapping("/java/get/{amount}")
    public Collection<Question> getQuestions(int amount) {
        return examinerService.getQuestions(amount);
    }
}
