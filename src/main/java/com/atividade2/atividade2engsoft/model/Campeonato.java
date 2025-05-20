package com.atividade2.atividade2engsoft.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Campeonato {

    private Integer id;
    private String nome;
    private Integer ano;

    private Set<Time> times = new HashSet<>();
    private List<Partida> partidas = new ArrayList<>();

    public Campeonato(Integer id, String nome, Integer ano, Set<Time> times, List<Partida> partidas) {
        this.id = id;
        this.nome = nome;
        this.ano = ano;
        this.times = times;
        this.partidas = partidas;
    }

    public Campeonato(String nome, Integer ano) {
        this.nome = nome;
        this.ano = ano;
    }

    public Campeonato(String nome, Integer ano, Set<Time> times, List<Partida> partidas) {
        this.nome = nome;
        this.ano = ano;
        this.times = times;
        this.partidas = partidas;
    }

    public void adicionarTime(Time time) {
        this.times.add(time);
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

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public Set<Time> getTimes() {
        return times;
    }

    public void setTimes(Set<Time> times) {
        this.times = times;
    }

    public List<Partida> getPartidas() {
        return partidas;
    }

    public void setPartidas(List<Partida> partidas) {
        this.partidas = partidas;
    }
}
