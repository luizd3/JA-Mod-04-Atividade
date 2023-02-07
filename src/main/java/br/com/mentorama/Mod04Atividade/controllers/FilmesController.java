package br.com.mentorama.Mod04Atividade.controllers;

import br.com.mentorama.Mod04Atividade.models.Filme;
import br.com.mentorama.Mod04Atividade.services.IFilmesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import static br.com.mentorama.Mod04Atividade.controllers.GenericControllerAdvice.LOGGER;

@RestController
@RequestMapping("/filmes")
public class FilmesController {

    @Autowired
    private IFilmesService filmesService;

    String message;

    @GetMapping
    public List<Filme> findAll(@RequestParam( required = false) String nome) {
        return filmesService.findAll(nome);
    }

    @GetMapping("/{id}")
    public Filme findById(@PathVariable("id") UUID id) {
        return filmesService.findById(id);
    }

    @PostMapping
    public ResponseEntity<String> add(@RequestBody Filme filme) {
        filmesService.add(filme);
        message = "Filme '" + filme.getNome() + "' adicionado.";
        LOGGER.info(message);
        return new ResponseEntity<>(message, HttpStatus.CREATED);
    }

    @PutMapping
    public String update(@RequestBody Filme filme) {
        filmesService.update(filme);
        message = "Filme atualizado.";
        LOGGER.info(message);
        return message;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") UUID id) {
        filmesService.delete(id);
        message = "Filme apagado.";
        LOGGER.info(message);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

}
