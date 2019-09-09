/*
 * Created by Ada.Sarca
 * Date: 9/9/2019
 */
package com.example.spring.rest.advice;

import com.example.spring.model.exception.DatabaseException;
import com.example.spring.model.response.ErrorResponse;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class RestControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(DatabaseException.class)
    public final ResponseEntity<ErrorResponse> handleDatabaseException(Exception exception) {
        System.out.println("Identified database exception: " + exception);
        ErrorResponse errorResponse = new ErrorResponse(500, "Internal server error");
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
