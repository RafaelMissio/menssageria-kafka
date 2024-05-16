package br.com.missio.apipagamento.controller.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(AplicationException.class)
    public ResponseEntity<Object> aplicationException(AplicationException ex, WebRequest request) {
        var response = ErrorResponse.builder()
                .error(ex.getMessage())
                .codigo(HttpStatus.BAD_REQUEST.value())
                .path(request.getDescription(false))
                .timestamp(new Date())
                .build();

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> methodArgumentNotValidException(MethodArgumentNotValidException e, WebRequest request) {
        var erros = e.getFieldErrors().stream().map(item -> item.getField() + "" + item.getDefaultMessage()).collect(Collectors.joining());
        var response = ErrorResponse.builder()
                .error(erros)
                .codigo(HttpStatus.BAD_REQUEST.value())
                .path(request.getDescription(false))
                .timestamp(new Date())
                .build();

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
