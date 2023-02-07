package br.com.mentorama.Mod04Atividade.services;

import br.com.mentorama.Mod04Atividade.models.Filme;

import java.util.List;
import java.util.UUID;

public interface IFilmesService {

    public List<Filme> findAll(String nome);

    public Filme findById(UUID id);

    public void add(Filme filme);

    public void update(Filme filme);

    public void delete(UUID id);

}
