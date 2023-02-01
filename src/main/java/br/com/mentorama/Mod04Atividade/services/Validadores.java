package br.com.mentorama.Mod04Atividade.services;

import br.com.mentorama.Mod04Atividade.exceptions.NotaInvalidaException;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class Validadores {

    private final int[] NOTAS = {1,2,3,4,5};

    public void validaNota(int notaNova) {
        int notaValidada = Arrays.binarySearch(NOTAS, notaNova);
        if (notaValidada < 0) {
            throw new NotaInvalidaException();
        }
    }

}
