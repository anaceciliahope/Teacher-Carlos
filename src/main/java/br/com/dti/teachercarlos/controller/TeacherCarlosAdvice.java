package br.com.dti.teachercarlos.controller;

import br.com.dti.teachercarlos.exception.AlunoException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


import java.util.HashMap;
import java.util.Map;


@ControllerAdvice
public class TeacherCarlosAdvice {

    private ObjectMapper mapper;

    public TeacherCarlosAdvice() {
        this.mapper = new ObjectMapper();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> erros = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error ->
                erros.put(error.getField(), error.getDefaultMessage())
        );
        return new ResponseEntity<>(erros, HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(AlunoException.class)
    public ResponseEntity<Map<String, String>> handleAppException(AlunoException ex) {
        Map<String, String> erros = new HashMap<>();
        erros.put("erro", ex.getMessage());
        return new ResponseEntity<>(erros, HttpStatus.UNPROCESSABLE_ENTITY);
    }


}