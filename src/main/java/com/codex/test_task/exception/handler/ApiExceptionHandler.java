package com.codex.test_task.exception.handler;

import com.codex.test_task.exception.DBNotFoundException;
import com.codex.test_task.exception.ExceptionDto;
import com.codex.test_task.exception.ItemExistsInCartException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(value={DBNotFoundException.class})
    public ResponseEntity<Object> handleDBNotFoundException(DBNotFoundException e) {
        ExceptionDto exceptionDto = new ExceptionDto(
                e.getMessage(),
                e, HttpStatus.NOT_FOUND,
                LocalDateTime.now()
        );
        return new ResponseEntity<>(exceptionDto, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value={ItemExistsInCartException.class})
    public ResponseEntity<Object> handleItemExistsInCartException(ItemExistsInCartException e) {
        ExceptionDto exceptionDto = new ExceptionDto(
                e.getMessage(),
                e, HttpStatus.BAD_REQUEST,
                LocalDateTime.now()
        );
        return new ResponseEntity<>(exceptionDto, HttpStatus.BAD_REQUEST);
    }
}
