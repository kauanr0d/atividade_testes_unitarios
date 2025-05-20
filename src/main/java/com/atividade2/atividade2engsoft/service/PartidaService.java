package com.atividade2.atividade2engsoft.service;

import com.atividade2.atividade2engsoft.model.Estadio;
import com.atividade2.atividade2engsoft.model.Partida;
import com.atividade2.atividade2engsoft.model.Time;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PartidaService {

    private final List<Partida> partidas = new ArrayList<>();

    public Partida criarPartida(LocalDate data, Time mandante, Time visitante) {
        if (data == null || data.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("Data inválida para a partida.");
        }

        if (mandante == null || visitante == null) {
            throw new IllegalArgumentException("Os times não podem ser nulos.");
        }

        if (mandante.equals(visitante)) {
            throw new IllegalArgumentException("Time mandante e visitante devem ser diferentes.");
        }

        Partida nova = new Partida(data, mandante, visitante);
        partidas.add(nova);
        return nova;
    }

    public List<Partida> filtrarPorData(LocalDate data) {
        List<Partida> resultado = new ArrayList<>();
        for (Partida p : partidas) {
            if (p.getData().equals(data)) {
                resultado.add(p);
            }
        }
        return resultado;
    }

    public List<Partida> filtrarPorEstadio(Estadio estadio) {
        List<Partida> resultado = new ArrayList<>();
        for (Partida p : partidas) {
            if (p.getTimeMandante().getEstadio() != null && (p.getTimeMandante().equals(estadio))) {
                resultado.add(p);
            }
        }
        return resultado;
    }

    public List<Partida> filtrarPorMandante(Time mandante) {
        List<Partida> resultado = new ArrayList<>();
        for (Partida p : partidas) {
            if (p.getTimeMandante().equals(mandante)) {
                resultado.add(p);
            }
        }
        return resultado;
    }

    public List<Partida> getPartidas() {
        return partidas;
    }


}

