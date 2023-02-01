package br.com.mentorama.Mod04Atividade.services;

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
        int notaValidada = validaNota(filme.getNota());

        if(notaValidada >= 0){
            filme.setId(UUID.randomUUID());
            this.filmes.add(filme);
        } else {
            throw new NotaInvalidaException();
        }

    }

    public void update(Filme filme) {
        int notaValidada = validaNota(filme.getNota());

        if (notaValidada >= 0) {
            Filme filmeParaAlterar = filmes.stream()
                    .filter(film -> film.getId().equals(filme.getId()))
                    .findFirst()
                    .get();
            filmeParaAlterar.setNome(filme.getNome());
            filmeParaAlterar.setNomeDoDiretor(filme.getNomeDoDiretor());
            filmeParaAlterar.setAno(filme.getAno());
        } else {
            throw new NotaInvalidaException();
        }

    }

    private int validaNota(int notaNova) {
        return Arrays.binarySearch(notas, notaNova);
    }

}
