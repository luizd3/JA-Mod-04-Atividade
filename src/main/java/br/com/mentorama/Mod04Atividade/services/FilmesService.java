package br.com.mentorama.Mod04Atividade.services;

import br.com.mentorama.Mod04Atividade.models.Filme;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class FilmesService {

    private final List<Filme> filmes;
    private UUID id;

    public FilmesService() {
        this.filmes = new ArrayList<>();
    }

    public List<Filme> findAll() {
        return filmes;
    }

    public String add(Filme filme) {
        filme.setId(UUID.randomUUID());
        this.filmes.add(filme);
        return filme.getNome();
    }

}
