package com.atividade2.atividade2engsoft.model;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Time {

    private final List<Partida> partidas = new ArrayList<>();
    private Integer id;
    private String nome;
    private Set<Jogador> jogadores = new HashSet<>();
    private Estadio estadio;

    public Time(Integer id, String nome, Set<Jogador> jogadores, Estadio estadio) {
        this.id = id;
        this.nome = nome;
        this.jogadores = jogadores;
        this.estadio = estadio;
    }

    public Time() {

    }

    public Time(String nome) {
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<Jogador> getJogadores() {
        return jogadores;
    }

    public void setJogadores(Set<Jogador> jogadores) {
        this.jogadores = jogadores;
    }

    public Estadio getEstadio() {
        return estadio;
    }

    public void setEstadio(Estadio estadio) {
        this.estadio = estadio;
    }

    public void adicionarJogador(Jogador jogador) {
        this.jogadores.add(jogador);
    }

    public void removerJogador(Jogador jogador) {
        this.jogadores.remove(jogador);
    }
}
