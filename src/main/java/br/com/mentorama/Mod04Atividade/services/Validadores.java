package br.com.mentorama.Mod04Atividade.services;

import br.com.mentorama.Mod04Atividade.exceptions.FilmeCampoNuloException;
import br.com.mentorama.Mod04Atividade.exceptions.FilmeDuplicadoException;
import br.com.mentorama.Mod04Atividade.exceptions.NotaInvalidaException;
import br.com.mentorama.Mod04Atividade.models.Filme;
import br.com.mentorama.Mod04Atividade.repositories.FilmesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class Validadores {

    private final int[] NOTAS = {1,2,3,4,5};

    @Autowired
    private FilmesRepository filmesRepository;

    public void validaNota(int notaNova) {
        int notaValidada = Arrays.binarySearch(NOTAS, notaNova);
        if (notaValidada < 0) {
            throw new NotaInvalidaException();
        }
    }

    public void validaFilmeDuplicado(Filme novoFilme) {
        filmesRepository.findAll().stream().forEach(film -> {
                    if (film.getNome().equalsIgnoreCase(novoFilme.getNome())) {
                        if (film.getNomeDoDiretor().equalsIgnoreCase(novoFilme.getNomeDoDiretor())) {
                            if (film.getAno().equals(novoFilme.getAno())) {
                                throw new FilmeDuplicadoException();
                            }
                        }
                    }
                }
        );
    }

    public void validaCampoNulo(Filme filme) {
        if (filme.getNome() == null || filme.getNome() == "" ||
                filme.getNomeDoDiretor() == null || filme.getNomeDoDiretor() == "" ||
                filme.getAno() == null || filme.getAno() == 0) {
            throw new FilmeCampoNuloException();
        }
    }

}
