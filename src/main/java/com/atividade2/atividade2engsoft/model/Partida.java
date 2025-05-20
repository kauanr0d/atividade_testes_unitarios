package com.atividade2.atividade2engsoft.model;

import java.time.LocalDate;

public class Partida {

    private Integer id;
    private LocalDate data;

    private Time timeMandante;
    private Time timeVisitante;

    private Resultado resultado;

    public Partida(LocalDate data, Time timeMandante, Time timeVisitante) {
        this.data = data;
        this.timeMandante = timeMandante;
        this.timeVisitante = timeVisitante;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Time getTimeMandante() {
        return timeMandante;
    }

    public void setTimeMandante(Time timeMandante) {
        this.timeMandante = timeMandante;
    }

    public Time getTimeVisitante() {
        return timeVisitante;
    }

    public void setTimeVisitante(Time timeVisitante) {
        this.timeVisitante = timeVisitante;
    }


}
