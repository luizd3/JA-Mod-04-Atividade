package br.com.mentorama.Mod04Atividade;

import br.com.mentorama.Mod04Atividade.models.Filme;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/filmes")
public class FilmesController {

    private final List<Filme> filmes;
    private UUID id;

    public FilmesController() {
        this.filmes = new ArrayList<>();
    }

    @GetMapping
    public List<Filme> findAll() {
        return filmes;
    }

    @PostMapping
    public String add(@RequestBody Filme filme) {
        this.id = UUID.randomUUID();
        filme.setId(id);
        this.filmes.add(filme);
        return filme.getNome();
    }

}
