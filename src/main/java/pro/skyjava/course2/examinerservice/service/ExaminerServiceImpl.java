package pro.skyjava.course2.examinerservice.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import pro.skyjava.course2.examinerservice.domain.Question;
import pro.skyjava.course2.examinerservice.exceptions.NoEnoughQuestionsException;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Component
@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final JavaQuestionService services;

    public ExaminerServiceImpl(JavaQuestionService service) {
        this.services = service;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        Set<Question> questionsSelected = new HashSet<>();
        if (amount > services.getAll().size()) {
            throw new NoEnoughQuestionsException();
        } else if (amount == services.getAll().size()) {
            return services.getAll().stream().toList();
        }
        while (questionsSelected.size() < amount) {
            questionsSelected.add(services.getRandomQuestion());
        }
        return questionsSelected;
    }

}
