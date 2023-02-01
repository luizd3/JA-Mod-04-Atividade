package br.com.mentorama.Mod04Atividade.services;

import br.com.mentorama.Mod04Atividade.exceptions.FilmeNaoEncontradoException;
import br.com.mentorama.Mod04Atividade.exceptions.NotaInvalidaException;
import br.com.mentorama.Mod04Atividade.models.Filme;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
public class FilmesService {

    private final List<Filme> filmes;
    private UUID id;
    private int[] notas = {1,2,3,4,5};

    public FilmesService() {
        this.filmes = new ArrayList<>();
    }

    public List<Filme> findAll() {
        return filmes;
    }

    public void add(Filme filme) {
        validaNota(filme.getNota());
        filme.setId(UUID.randomUUID());
        this.filmes.add(filme);
    }

    public void update(Filme filme) {
        validaNota(filme.getNota());
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

    private void validaNota(int notaNova) {
        int notaValidada = Arrays.binarySearch(notas, notaNova);
        if (notaValidada < 0) {
            throw new NotaInvalidaException();
        }
    }
}
