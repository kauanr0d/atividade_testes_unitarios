package com.atividade2.atividade2engsoft.model;

import java.util.*;

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

    public Map<Integer, Time> getClassificacao() {
        Map<Time, Integer> pontos = new HashMap<>();

        // Inicializa pontuação
        for (Time time : times) {
            pontos.put(time, 0);
        }

        // Soma pontos com base no resultado das partidas
        for (Partida partida : partidas) {
            Resultado r = partida.getResultado();
            if (r == null) continue;

            Time mandante = partida.getTimeMandante();
            Time visitante = partida.getTimeVisitante();
            int golsMandante = r.getNumGolsMandante();
            int golsVisitante = r.getNumGolsVisitante();

            if (golsMandante > golsVisitante) {
                pontos.put(mandante, pontos.get(mandante) + 3);
            } else if (golsMandante < golsVisitante) {
                pontos.put(visitante, pontos.get(visitante) + 3);
            } else {
                pontos.put(mandante, pontos.get(mandante) + 1);
                pontos.put(visitante, pontos.get(visitante) + 1);
            }
        }

        // Ordena os times por pontos
        List<Time> ordenados = new ArrayList<>(times);
        ordenados.sort((t1, t2) -> pontos.get(t2) - pontos.get(t1));

        // Cria map de classificação
        Map<Integer, Time> classificacao = new LinkedHashMap<>();
        for (int i = 0; i < ordenados.size(); i++) {
            classificacao.put(i + 1, ordenados.get(i));
        }

        return classificacao;
    }

}
