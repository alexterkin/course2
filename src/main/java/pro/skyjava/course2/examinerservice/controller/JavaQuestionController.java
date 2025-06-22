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
    public String removeQuestion(String question, String answer) {
        Question q = service.remove(new Question(question, answer));
        if (q == null) {
            return "Question not found";
        } else {
            return q.toString() + " was deleted";
        }
    }

    @GetMapping("")
    public Collection<Question> getQuestions() {
        return service.getAll();
    }

    @GetMapping("/find/{findField}")
    public Collection<Question> find(String findField) {
        return service.find(findField);
    }
}
