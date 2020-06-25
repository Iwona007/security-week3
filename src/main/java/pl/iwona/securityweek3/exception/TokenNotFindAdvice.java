package pl.iwona.securityweek3.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class TokenNotFindAdvice {

    @ResponseBody
    @ExceptionHandler(TokenNotFind.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String TokenNotFindHandler(TokenNotFind ex) {
        return ex.getMessage();
    }
}
