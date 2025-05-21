package com.atividade2.atividade2engsoft.model;

import java.time.LocalDate;
import java.time.Period;


public class Jogador {

    private Integer id;
    private String nome;

    private LocalDate nascimento;
    private String genero;

    private Time timeEmQueJoga;
    private Float altura;

    public Float getAltura() {
        return altura;
    }

    public void setAltura(Float altura) {
        if (altura != null && altura < 0) {
            throw new IllegalArgumentException("Altura não pode ser negativa.");
        }
        this.altura = altura;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public void setNascimento(LocalDate nascimento) {
        if (nascimento != null && nascimento.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Data de nascimento não pode ser no futuro.");
        }
        this.nascimento = nascimento;
    }

    public Time getTimeEmQueJoga() {
        return timeEmQueJoga;
    }

    public void setTimeEmQueJoga(Time timeEmQueJoga) {
        this.timeEmQueJoga = timeEmQueJoga;
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

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Integer calcularIdade() {
        if (nascimento == null) return null;
        return Period.between(nascimento, LocalDate.now()).getYears();
    }

    public void sairDoTime() {
        this.timeEmQueJoga = new Time();
    }


}
