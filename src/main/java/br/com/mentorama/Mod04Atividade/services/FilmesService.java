package br.com.mentorama.Mod04Atividade.services;

import br.com.mentorama.Mod04Atividade.models.Filme;
import br.com.mentorama.Mod04Atividade.repositories.FilmesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class FilmesService {

    @Autowired
    private FilmesRepository filmesRepository;

    @Autowired
    private Validadores validadores;

    public List<Filme> findAll() {
        return filmesRepository.findAll();
    }

    public Filme findById(UUID id) {
        return filmesRepository.findById(id);
    }

    public void add(Filme filme) {
        validadores.validaCampoNulo(filme);
        validadores.validaFilmeDuplicado(filme);
        validadores.validaNota(filme.getNota());
        this.filmesRepository.add(filme);
    }

    public void update(Filme filme) {
        validadores.validaCampoNulo(filme);
        validadores.validaFilmeDuplicado(filme);
        validadores.validaNota(filme.getNota());
        filmesRepository.update(filme);
    }

    public void delete(UUID id) {
        filmesRepository.delete(id);
    }

}
