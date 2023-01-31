package br.com.mentorama.Mod04Atividade;

import br.com.mentorama.Mod04Atividade.models.Filme;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/filmes")
public class FilmesController {

    private final Filme filme;

    public FilmesController() {
        this.filme = new Filme(1, "Nome", "Luiz", 1985, 2);
    }

    @GetMapping
    public Filme findAll() {
        return filme;
    }

}
