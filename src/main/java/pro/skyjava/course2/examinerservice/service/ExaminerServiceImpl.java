package pro.skyjava.course2.examinerservice.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import pro.skyjava.course2.examinerservice.domain.Question;
import pro.skyjava.course2.examinerservice.exceptions.NoEnoughQuestions;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Component
@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final JavaQuestionService service;

    public ExaminerServiceImpl(JavaQuestionService service) {
        this.service = service;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        QuestionServices services = service;
        Set<Question> questionsSelected = new HashSet<>();
        if (amount > services.getAll().size()) {
            throw new NoEnoughQuestions(HttpStatus.BAD_REQUEST, "Слишком много вопросов!");
        } else if (amount == services.getAll().size()) {
            return services.getAll().stream().toList();
        }
        questionsSelected.clear();
        while (questionsSelected.size() < amount) {
            questionsSelected.add(services.getRandomQuestion());
        }
        return questionsSelected.stream().toList();
    }

}
