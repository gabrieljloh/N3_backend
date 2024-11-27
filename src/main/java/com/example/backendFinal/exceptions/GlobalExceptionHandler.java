package com.example.backendFinal.exceptions;

import com.example.backendFinal.dtos.ErroDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

@ControllerAdvice
public class GlobalExceptionHandler {

    // Exceção de quando um recurso não é encontrado
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErroDTO> handleResourceNotFoundException(ResourceNotFoundException ex) {
        ErroDTO erroDTO = new ErroDTO(HttpStatus.NOT_FOUND, ex.getMessage());
        return new ResponseEntity<>(erroDTO, HttpStatus.NOT_FOUND);
    }

    // Exceção de quando a validação falha
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErroDTO> handleValidationExceptions(MethodArgumentNotValidException ex) {
        BindingResult bindingResult = ex.getBindingResult();
        StringBuilder errorMessage = new StringBuilder("Validation failed: ");

        for (FieldError error : bindingResult.getFieldErrors()) {
            errorMessage.append(error.getField())
                    .append(" - ")
                    .append(error.getDefaultMessage())
                    .append("; ");
        }

        ErroDTO erroDTO = new ErroDTO(HttpStatus.BAD_REQUEST, errorMessage.toString());
        return new ResponseEntity<>(erroDTO, HttpStatus.BAD_REQUEST);
    }

    // Exceção genérica
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErroDTO> handleGeneralException(Exception ex) {
        ErroDTO erroDTO = new ErroDTO(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
        return new ResponseEntity<>(erroDTO, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
