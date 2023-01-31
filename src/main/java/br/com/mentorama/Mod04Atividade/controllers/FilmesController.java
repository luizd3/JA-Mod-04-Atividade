package br.com.mentorama.Mod04Atividade.controllers;

import br.com.mentorama.Mod04Atividade.models.Filme;
import br.com.mentorama.Mod04Atividade.services.FilmesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/filmes")
public class FilmesController {

    @Autowired
    private FilmesService filmesService;

    @GetMapping
    public List<Filme> findAll() {
        return filmesService.findAll();
    }

    @PostMapping
    public String add(@RequestBody Filme filme) {
        return filmesService.add(filme);
    }

}
