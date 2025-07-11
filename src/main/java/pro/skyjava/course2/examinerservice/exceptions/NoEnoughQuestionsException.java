package pro.skyjava.course2.examinerservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class NoEnoughQuestionsException extends RuntimeException {

    public NoEnoughQuestionsException() {
        super("Недостаточно вопросов");
    }
}
