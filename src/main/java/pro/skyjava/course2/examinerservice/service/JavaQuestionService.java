package pro.skyjava.course2.examinerservice.service;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import pro.skyjava.course2.examinerservice.domain.Question;

import java.util.*;

@Repository
@Service
public class JavaQuestionService implements QuestionServices {
    private final Set<Question> questions;
    private final Random random = new Random();

    public JavaQuestionService() {
        this.questions = new HashSet<>();
    }

    @Override
    public Question add(String question, String answer) {
        Question q = new Question(question, answer);
        this.questions.add(q);
        return q;
    }

    @Override
    public Question add(Question question) {
        this.questions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        boolean result = this.questions.remove(question);
        return result ? question : null;
    }

    @Override
    public Collection<Question> getAll() {
        return this.questions
                .stream().toList();
    }

    @Override
    public Question getRandomQuestion() {
        List<Question> questionList = this.questions
                .stream().toList();
        if (questionList.isEmpty()) {
            return null;
        }

        int randomIndex = random.nextInt(questionList.size());
        return questionList.get(randomIndex);
    }

    @Override
    public List<Question> find(String findField) {
        return this.questions
                .stream().toList();
    }
}
