package br.com.mentorama.Mod04Atividade.validators;

import br.com.mentorama.Mod04Atividade.exceptions.FilmeCampoNuloException;
import br.com.mentorama.Mod04Atividade.models.Filme;
import org.springframework.stereotype.Component;

@Component
public class ValidarCampoNulo implements IValidadador {

    @Override
    public void valida(Filme filme) {
        if (filme.getNome() == null || filme.getNome() == "" ||
                filme.getNomeDoDiretor() == null || filme.getNomeDoDiretor() == "" ||
                filme.getAno() == null || filme.getAno() == 0) {
            throw new FilmeCampoNuloException();
        }
    }

}
