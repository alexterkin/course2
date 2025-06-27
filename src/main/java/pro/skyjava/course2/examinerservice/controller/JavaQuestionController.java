package pro.skyjava.course2.examinerservice.controller;

import org.springframework.web.bind.annotation.*;
import pro.skyjava.course2.examinerservice.domain.Question;
import pro.skyjava.course2.examinerservice.service.JavaQuestionService;

import java.util.Collection;

@RestController
@RequestMapping("/exam/java")
public class JavaQuestionController {
    private final JavaQuestionService service;

    public JavaQuestionController(JavaQuestionService service) {
        this.service = service;
    }

    @GetMapping("/add")
    public Question addQuestion(String question, String answer) {
        return service.add(question, answer);
    }

    @GetMapping("/remove")
    public Question removeQuestion(String question, String answer) {
        return service.remove(new Question(question, answer));
    }

    @GetMapping
    public Collection<Question> getQuestions() {
        return service.getAll();
    }
}
