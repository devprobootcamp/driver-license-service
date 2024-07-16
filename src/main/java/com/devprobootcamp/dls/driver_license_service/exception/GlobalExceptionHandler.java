package com.devprobootcamp.dls.driver_license_service.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.hibernate.id.IdentifierGenerationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorMessage> handleHttpMessageNotReadableException(HttpMessageNotReadableException ex, HttpServletRequest request) {
        return new ResponseEntity<>(createErrorMessage(ex.getMessage(), request.getServletPath()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(IdentifierGenerationException.class)
    public ResponseEntity<ErrorMessage> handleIdentifierGenerationException(IdentifierGenerationException ex, HttpServletRequest request) {
        return new ResponseEntity<>(createErrorMessage(ex.getMessage(), request.getServletPath()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorMessage> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex, HttpServletRequest request) {
        return new ResponseEntity<>(createErrorMessage(ex.getFieldError().getDefaultMessage(), request.getServletPath()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorMessage> handleResourceNotFoundException(ResourceNotFoundException ex, HttpServletRequest request) {
        return new ResponseEntity<>(createErrorMessage(ex.getMessage(), request.getServletPath()), HttpStatus.NOT_FOUND);
    }

    private ErrorMessage createErrorMessage(String error, String path) {
        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setError(error);
        errorMessage.setPath(path);
        errorMessage.setTimestamp(LocalDateTime.now());
        return errorMessage;
    }

}
