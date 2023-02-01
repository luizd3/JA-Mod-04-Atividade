package br.com.mentorama.Mod04Atividade.services;

import br.com.mentorama.Mod04Atividade.exceptions.NotaInvalidaException;
import br.com.mentorama.Mod04Atividade.models.Filme;
import br.com.mentorama.Mod04Atividade.repositories.FilmesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
public class FilmesService {

    private int[] notas = {1,2,3,4,5};

    @Autowired
    private FilmesRepository filmesRepository;

    public List<Filme> findAll() {
        return filmesRepository.findAll();
    }

    public void add(Filme filme) {
        validaNota(filme.getNota());
        this.filmesRepository.add(filme);
    }

    public void update(Filme filme) {
        validaNota(filme.getNota());
        filmesRepository.update(filme);
    }

    public void delete(UUID id) {
        filmesRepository.delete(id);
    }

    private void validaNota(int notaNova) {
        int notaValidada = Arrays.binarySearch(notas, notaNova);
        if (notaValidada < 0) {
            throw new NotaInvalidaException();
        }
    }
}
