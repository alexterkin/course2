package pro.skyjava.course2.examinertests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.skyjava.course2.examinerservice.domain.Question;
import pro.skyjava.course2.examinerservice.exceptions.QuestionNotFoundException;
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
    public void givenQuestionAndAnswer_whenGetQuestion_thenCheckQuestionExists() {
        String questionField = "question3";
        String answerField = "answer3";
        Question question = new Question(questionField, answerField);
        service.add(question);
        Collection<Question> result = service.getAll();
        Assertions.assertTrue(result.contains(question));
    }

    @Test
    public void givenQuestion_whenRemoveQuestion_thenQuestionNotFoundException() {
        String questionField = "question3";
        String answerField = "answer3";
        Question question = new Question(questionField, answerField);
        Assertions.assertThrows(QuestionNotFoundException.class, () -> service.remove(question));
    }

    @Test
    public void givenQuestionAndAnswer_whenGetAllQuestions_thenCheckQuestionsExist() {
        String questionField1 = "question1";
        String questionField2 = "question2";
        String questionField3 = "question3";
        String answerField1 = "answer1";
        String answerField2 = "answer1";
        String answerField3 = "answer1";
        Question question1 = new Question(questionField1, answerField1);
        Question question2 = new Question(questionField2, answerField2);
        Question question3 = new Question(questionField3, answerField3);
        service.add(question1);
        service.add(question2);
        service.add(question3);
        Collection<Question> result = service.getAll();
        Assertions.assertTrue(result.contains(question1));
        Assertions.assertTrue(result.contains(question2));
        Assertions.assertTrue(result.contains(question3));
    }
}
