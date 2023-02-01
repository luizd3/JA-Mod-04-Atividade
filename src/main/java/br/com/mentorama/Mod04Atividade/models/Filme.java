package br.com.mentorama.Mod04Atividade.models;

import java.util.UUID;

public class Filme {

    private UUID id;
    private String nome;
    private String nomeDoDiretor;
    private int ano;
    private int nota;

    public Filme(final UUID id, final String nome, final String nomeDoDiretor, final int ano, final int nota) {
        this.id = id;
        this.nome = nome;
        this.nomeDoDiretor = nomeDoDiretor;
        this.ano = ano;
        this.nota = nota;
    }

    public UUID getId() {
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

    public void setId(UUID id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setNomeDoDiretor(String nomeDoDiretor) {
        this.nomeDoDiretor = nomeDoDiretor;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }
}
