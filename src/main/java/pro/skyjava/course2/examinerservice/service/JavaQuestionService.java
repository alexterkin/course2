package pro.skyjava.course2.examinerservice.service;

import org.springframework.stereotype.Service;
import pro.skyjava.course2.examinerservice.domain.Question;
import pro.skyjava.course2.examinerservice.exceptions.NoEnoughQuestionsException;
import pro.skyjava.course2.examinerservice.exceptions.QuestionNotFoundException;

import java.util.*;

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
        if (!result) {
            throw new QuestionNotFoundException();
        } return question;
    }

    @Override
    public Collection<Question> getAll() {
        return Collections.unmodifiableSet(questions);
    }

    @Override
    public Question getRandomQuestion() {
        List<Question> questionList = this.questions
                .stream().toList();
        if (questionList.isEmpty()) {
            throw new NoEnoughQuestionsException();
        }

        int randomIndex = random.nextInt(questionList.size());
        return questionList.get(randomIndex);
    }
}
