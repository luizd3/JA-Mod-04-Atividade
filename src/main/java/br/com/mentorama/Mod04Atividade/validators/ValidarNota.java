package br.com.mentorama.Mod04Atividade.validators;

import br.com.mentorama.Mod04Atividade.exceptions.NotaInvalidaException;
import br.com.mentorama.Mod04Atividade.models.Filme;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class ValidarNota implements IValidadador {

    private final int[] NOTAS = {1,2,3,4,5};

    @Override
    public void valida(Filme filme) {
        int notaValidada = Arrays.binarySearch(NOTAS, filme.getNota());
        if (notaValidada < 0) {
            throw new NotaInvalidaException();
        }
    }

}
