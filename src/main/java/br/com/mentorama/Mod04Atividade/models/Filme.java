package br.com.mentorama.Mod04Atividade.models;

public class Filme {

    private Integer id;
    private String nome;
    private String nomeDoDiretor;
    private Integer ano;
    private Integer nota;

    public Filme(final Integer id, final String nome, final String nomeDoDiretor, final Integer ano, final Integer nota) {
        this.id = id;
        this.nome = nome;
        this.nomeDoDiretor = nomeDoDiretor;
        this.ano = ano;
        this.nota = nota;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getNomeDoDiretor() {
        return nomeDoDiretor;
    }

    public Integer getAno() {
        return ano;
    }

    public Integer getNota() {
        return nota;
    }
}
