package br.com.mentorama.Mod04Atividade.validators;

import br.com.mentorama.Mod04Atividade.exceptions.FilmeDuplicadoException;
import br.com.mentorama.Mod04Atividade.models.Filme;
import br.com.mentorama.Mod04Atividade.repositories.FilmesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidarFilmeDuplicado implements IValidadador {

    @Autowired
    private FilmesRepository filmesRepository;

    @Override
    public void valida(Filme filme) {
        filmesRepository.findAll().stream().forEach(film -> {
                    if (film.getNome().equalsIgnoreCase(filme.getNome())) {
                        if (film.getNomeDoDiretor().equalsIgnoreCase(filme.getNomeDoDiretor())) {
                            if (film.getAno().equals(filme.getAno())) {
                                throw new FilmeDuplicadoException();
                            }
                        }
                    }
                }
        );
    }

}
