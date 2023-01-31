package br.com.mentorama.Mod04Atividade;

import br.com.mentorama.Mod04Atividade.models.Filme;
import br.com.mentorama.Mod04Atividade.models.Nota;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/filmes")
public class FilmesController {

    private Filme filme;

//    public FilmesController() {
//        this.filme = new Filme();
//    }

    @GetMapping
    public Filme findAll() {
        return filme;
    }

    @PostMapping
    public int add(@RequestBody Filme filme) {
        this.filme = filme;
        return filme.getId();
    }

}
