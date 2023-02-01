package br.com.mentorama.Mod04Atividade.controllers;

import br.com.mentorama.Mod04Atividade.exceptions.NotaInvalidaException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GenericControllerAdvice {

    @ExceptionHandler ({NotaInvalidaException.class})
    public static ResponseEntity<String> handle(final NotaInvalidaException e) {
        String message = "Filme não cadastrado/atualizado." +
                " Nota inválida. Nota deve ser um número inteiro entre 1 e 5.";
        return new ResponseEntity<>(message, HttpStatus.NOT_ACCEPTABLE);
    }

}
