package br.com.mentorama.Mod04Atividade.models;

public enum Nota {
    UM(1),
    DOIS(2),
    TRES(3),
    QUATRO(4),
    CINCO(5);

    private final int nota;

    Nota(final int novaNota) {
        this.nota = novaNota;
    }

    public int getValorNota() {
        return nota;
    }
}
