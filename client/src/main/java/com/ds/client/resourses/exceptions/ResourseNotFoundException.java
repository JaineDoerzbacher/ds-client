package com.ds.client.resourses.exceptions;

import com.ds.client.services.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@ControllerAdvice
public class ResourseNotFoundException {


    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardError> entityNotFound(ResourceNotFoundException e, HttpServletRequest request) { // Para interceptar a exceção
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError err = new StandardError();
        err.setTimestamp(Instant.now()); // Para pegar o instante atual
        err.setStatus(status.value()); // Para pegar o status
        err.setError("Resourse not found"); // Para pegar o erro
        err.setMessage(e.getMessage()); // Para pegar a mensagem
        err.setPath(request.getRequestURI()); // Para pegar o caminho da requisição
        return ResponseEntity.status(status).body(err);  // Para retornar a resposta com o status de erro do HTTP
    }

}
