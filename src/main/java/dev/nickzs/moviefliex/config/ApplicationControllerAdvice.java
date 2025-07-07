package dev.nickzs.moviefliex.config;
import dev.nickzs.moviefliex.exception.UserNameOrPasswordInvalidException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApplicationControllerAdvice {

    @ExceptionHandler(UserNameOrPasswordInvalidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleNotFound(UserNameOrPasswordInvalidException exception){
        return exception.getMessage();
    }
}
