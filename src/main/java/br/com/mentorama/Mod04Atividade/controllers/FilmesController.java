package br.com.mentorama.Mod04Atividade.controllers;

import br.com.mentorama.Mod04Atividade.models.Filme;
import br.com.mentorama.Mod04Atividade.services.FilmesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/filmes")
public class FilmesController {

    @Autowired
    private FilmesService filmesService;

    @GetMapping
    public List<Filme> findAll() {
        return filmesService.findAll();
    }

    @GetMapping("/{id}")
    public Filme findById(@PathVariable("id") UUID id) {
        return filmesService.findById(id);
    }

    @PostMapping
    public ResponseEntity<String> add(@RequestBody Filme filme) {
        filmesService.add(filme);
        return new ResponseEntity<>("Filme '" + filme.getNome() + "' adicionado.", HttpStatus.CREATED);
    }

    @PutMapping
    public String update(@RequestBody Filme filme) {
        filmesService.update(filme);
        return "Filme atualizado.";
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") UUID id) {
        filmesService.delete(id);
        return new ResponseEntity<>("Filme apagado.", HttpStatus.OK);
    }

}
