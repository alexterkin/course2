package pro.skyjava.course2.examinertests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.skyjava.course2.examinerservice.domain.Question;
import pro.skyjava.course2.examinerservice.service.JavaQuestionService;

import java.util.Collection;
import java.util.Random;
import java.util.Set;

@ExtendWith(MockitoExtension.class)
public class JavaQuestionServiceTest {

    @Mock
    private Set<Question> questions;
    @Mock
    private Random random;
    @InjectMocks
    private JavaQuestionService service;

    @Test
    public void givenQuestion_whenRemoveQuestion_thenCheckQuestionWasRemoved() {
        String questionField = "question1";
        String answerField = "answer1";
        Question question = new Question(questionField, answerField);
        service.add(question);
        Question result = service.remove(question);
        Assertions.assertEquals(question, result);
    }

    @Test
    public void givenQuestionAndAnswer_whenFindQuestion_thenCheckQuestionExists() {
        String questionField = "question2";
        String answerField = "answer2";
        Question question = new Question(questionField, answerField);
        service.add(question);
        Collection<Question> result = service.find("question");
        Assertions.assertTrue(result.contains(question));

    }

    @Test
    public void givenQuestionAndAnswer_whenGetAllQuestions_thenCheckQuestionExists() {
        String questionField = "question3";
        String answerField = "answer3";
        Question question = new Question(questionField, answerField);
        service.add(question);
        Collection<Question> result = service.getAll();
        Assertions.assertTrue(result.contains(question));
    }
}
