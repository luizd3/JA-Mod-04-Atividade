package br.com.mentorama.Mod04Atividade.services;

import br.com.mentorama.Mod04Atividade.models.Filme;
import br.com.mentorama.Mod04Atividade.repositories.FilmesRepository;
import br.com.mentorama.Mod04Atividade.validators.IValidadador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class FilmesService implements IFilmesService{

    @Autowired
    private FilmesRepository filmesRepository;

    @Autowired
    private List<IValidadador> validadores;

    public List<Filme> findAll(String nome) {
        if (nome != null) {
            return filmesRepository.findAll(nome);
        }
        return filmesRepository.findAll();
    }

    public Filme findById(UUID id) {
        return filmesRepository.findById(id);
    }

    public void add(Filme filme) {
        validadores.forEach(validadador -> validadador.valida(filme));
        this.filmesRepository.add(filme);
    }

    public void update(Filme filme) {
        validadores.forEach(validadador -> validadador.valida(filme));
        filmesRepository.update(filme);
    }

    public void delete(UUID id) {
        filmesRepository.delete(id);
    }

}
