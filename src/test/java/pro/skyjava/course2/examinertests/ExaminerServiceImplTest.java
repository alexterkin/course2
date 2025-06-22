package pro.skyjava.course2.examinertests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.skyjava.course2.examinerservice.domain.Question;
import pro.skyjava.course2.examinerservice.exceptions.NoEnoughQuestions;
import pro.skyjava.course2.examinerservice.service.ExaminerServiceImpl;
import pro.skyjava.course2.examinerservice.service.JavaQuestionService;

import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.lenient;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTest {

    @Mock
    private JavaQuestionService service;
    @InjectMocks
    private ExaminerServiceImpl examinerService;

    @Test
    public void givenQuestions_whenGetAllQuestions_thenCheckListSize() {
        lenient().when(service.getAll()).thenReturn(List.of(
                new Question("question1", "answer1"),
                new Question("question2", "answer2"),
                new Question("question3", "answer3"),
                new Question("question4", "answer4"),
                new Question("question5", "answer5")
        ));
        Collection<Question> list = examinerService.getQuestions(5);
        Assertions.assertEquals(5, list.size());
    }

    @Test
    public void givenAFewQuestions_whenGetMuchMoreQuestions_thenCheckException() {
        lenient().when(service.getAll()).thenReturn(List.of(
                new Question("question_0", "answer_0")
        ));
        assertThrows(NoEnoughQuestions.class, () -> {
            examinerService.getQuestions(10);});

    }




}
