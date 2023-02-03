package br.com.mentorama.Mod04Atividade.controllers;

import br.com.mentorama.Mod04Atividade.exceptions.FilmeCampoNuloException;
import br.com.mentorama.Mod04Atividade.exceptions.FilmeDuplicadoException;
import br.com.mentorama.Mod04Atividade.exceptions.FilmeNaoEncontradoException;
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

    @ExceptionHandler ({FilmeNaoEncontradoException.class})
    public static ResponseEntity<String> handle(final FilmeNaoEncontradoException e) {
        String message = "Filme não encontrado.";
        return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler ({FilmeDuplicadoException.class})
    public static ResponseEntity<String> handle(final FilmeDuplicadoException e) {
        String message = "Filme não cadastrado/atualizado. Já existe na base de dados.";
        return new ResponseEntity<>(message, HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler ({FilmeCampoNuloException.class})
    public static ResponseEntity<String> handle(final FilmeCampoNuloException e) {
        String message = "Filme não cadastrado/atualizado. Nenhum campo pode ser nulo.";
        return new ResponseEntity<>(message, HttpStatus.NOT_ACCEPTABLE);
    }

}
