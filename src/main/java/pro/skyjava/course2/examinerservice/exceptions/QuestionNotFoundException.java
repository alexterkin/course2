package pro.skyjava.course2.examinerservice.exceptions;

public class QuestionNotFoundException extends RuntimeException {
    public QuestionNotFoundException() {
        super("Вопрос не найден");
    }
}
