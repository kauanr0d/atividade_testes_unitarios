package com.atividade2.atividade2engsoft.service;

import com.atividade2.atividade2engsoft.model.Campeonato;
import com.atividade2.atividade2engsoft.model.Time;

public class CampeonatoService {

    private final Campeonato campeonato;

    public CampeonatoService(Campeonato campeonato) {
        this.campeonato = campeonato;
    }

    public void adicionarTime(Time time) {
        if (campeonato.getTimes().contains(time)) {
            throw new IllegalArgumentException("Time já está participando deste campeonato");
        }
        campeonato.getTimes().add(time);
    }
}

