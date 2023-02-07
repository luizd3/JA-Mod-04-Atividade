package br.com.mentorama.Mod04Atividade.controllers;

import br.com.mentorama.Mod04Atividade.exceptions.FilmeCampoNuloException;
import br.com.mentorama.Mod04Atividade.exceptions.FilmeDuplicadoException;
import br.com.mentorama.Mod04Atividade.exceptions.FilmeNaoEncontradoException;
import br.com.mentorama.Mod04Atividade.exceptions.NotaInvalidaException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GenericControllerAdvice {

    final static Logger LOGGER = LoggerFactory.getLogger(GenericControllerAdvice.class);

    @ExceptionHandler ({NotaInvalidaException.class})
    public static ResponseEntity<String> handle(final NotaInvalidaException e) {
        final String message = "Filme não cadastrado/atualizado." +
                " Nota inválida. Nota deve ser um número inteiro entre 1 e 5.";
        LOGGER.warn(message);
        return new ResponseEntity<>(message, HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler ({FilmeNaoEncontradoException.class})
    public static ResponseEntity<String> handle(final FilmeNaoEncontradoException e) {
        final String message = "Filme não encontrado.";
        LOGGER.warn(message);
        return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler ({FilmeDuplicadoException.class})
    public static ResponseEntity<String> handle(final FilmeDuplicadoException e) {
        final String message = "Filme não cadastrado/atualizado. Já existe na base de dados.";
        LOGGER.warn(message);
        return new ResponseEntity<>(message, HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler ({FilmeCampoNuloException.class})
    public static ResponseEntity<String> handle(final FilmeCampoNuloException e) {
        final String message = "Filme não cadastrado/atualizado. Nenhum campo pode ser nulo ou vazio.";
        LOGGER.warn(message);
        return new ResponseEntity<>(message, HttpStatus.NOT_ACCEPTABLE);
    }

}
