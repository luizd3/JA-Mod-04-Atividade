package br.com.mentorama.Mod04Atividade.repositories;

import br.com.mentorama.Mod04Atividade.exceptions.FilmeNaoEncontradoException;
import br.com.mentorama.Mod04Atividade.models.Filme;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
public class FilmesRepository {

    private final List<Filme> filmes;

    public FilmesRepository() {
        this.filmes = new ArrayList<>();
    }

    public List<Filme> findAll() {
        return filmes;
    }

    public Filme findById(UUID id) {
        return filmes.stream()
                .filter(film -> film.getId().equals(id))
                .findFirst()
                .orElseThrow(FilmeNaoEncontradoException::new);
    }

    public void add(Filme filme) {
        filme.setId(UUID.randomUUID());
        this.filmes.add(filme);
    }

    public void update(Filme filme) {
        Filme filmeParaAlterar = filmes.stream()
                .filter(film -> film.getId().equals(filme.getId()))
                .findFirst()
                .orElseThrow(FilmeNaoEncontradoException::new);
        filmeParaAlterar.setNome(filme.getNome());
        filmeParaAlterar.setNomeDoDiretor(filme.getNomeDoDiretor());
        filmeParaAlterar.setAno(filme.getAno());
        filmeParaAlterar.setNota(filme.getNota());
    }

    public void delete(UUID id) {
        boolean remove = filmes.removeIf(film -> film.getId().equals(id));
        if (!remove) {
            throw new FilmeNaoEncontradoException();
        }
    }

}
