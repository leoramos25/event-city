package com.devsuperior.bds02.controllers.exceptions.handlers;

import com.devsuperior.bds02.controllers.exceptions.StandardError;
import com.devsuperior.bds02.services.exceptions.ControllerNotFoundException;
import com.devsuperior.bds02.services.exceptions.DatabaseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@RestControllerAdvice
public class ControllerExceptionHandler {
    
    @ExceptionHandler(ControllerNotFoundException.class)
    public ResponseEntity<StandardError> entityNotFound(ControllerNotFoundException exception, HttpServletRequest request) {
        var status = HttpStatus.NOT_FOUND;
        var error = new StandardError();
        
        error.setTimestamp(Instant.now());
        error.setStatus(status.value());
        error.setError("Controller not found");
        error.setMessage(exception.getMessage());
        error.setPath(request.getRequestURI());
        
        return ResponseEntity.status(status).body(error);
    }
    
    @ExceptionHandler(DatabaseException.class)
    public ResponseEntity<StandardError> databaseIntegrityViolation(DatabaseException exception, HttpServletRequest request) {
        var status = HttpStatus.BAD_REQUEST;
        var error = new StandardError();
        
        error.setTimestamp(Instant.now());
        error.setStatus(status.value());
        error.setError("Database violation");
        error.setMessage(exception.getMessage());
        error.setPath(request.getRequestURI());
        
        return ResponseEntity.status(status).body(error);
    }
    
}
