package br.com.mentorama.Mod04Atividade.models;

public class Filme {

    private int id;
    private String nome;
    private String nomeDoDiretor;
    private int ano;
    private int nota;

    public Filme(final int id, final String nome, final String nomeDoDiretor, final int ano, final int nota) {
        this.id = id;
        this.nome = nome;
        this.nomeDoDiretor = nomeDoDiretor;
        this.ano = ano;
        this.nota = nota;
    }

    public Filme() {

    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getNomeDoDiretor() {
        return nomeDoDiretor;
    }

    public int getAno() {
        return ano;
    }

    public int getNota() {
        return nota;
    }
}
