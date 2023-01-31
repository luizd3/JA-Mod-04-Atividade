package br.com.mentorama.Mod04Atividade;

import br.com.mentorama.Mod04Atividade.models.Filme;
import br.com.mentorama.Mod04Atividade.models.Nota;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/filmes")
public class FilmesController {

    private final Filme filme;

    public FilmesController() {
        this.filme = new Filme(1, "Dança com Lobos", "Kevin Costner", 1990, Nota.CINCO.getValorNota());
    }

    @GetMapping
    public Filme findAll() {
        return filme;
    }

}
