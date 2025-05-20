package com.atividade2.atividade2engsoft.service;

import com.atividade2.atividade2engsoft.model.Resultado;

public class ResultadoService {

    private final Resultado resultado;

    public ResultadoService(Resultado resultado) {
        this.resultado = resultado;
    }

    public Resultado criarResultado(int golsMandante, int golsVisitante) {
        Resultado resultado = new Resultado();

        if (golsMandante < 0 || golsVisitante < 0) {
            throw new IllegalArgumentException("Valores de gol são negativos!");
        }

        resultado.setNumGolsMandante(golsMandante);
        resultado.setNumGolsVisitante(golsVisitante);
        return resultado;
    }

    public boolean jogoEmpatado(Resultado resultado) {
        return resultado.getNumGolsMandante().equals(resultado.getNumGolsVisitante());
    }

    public String vencedor(Resultado resultado) {
        int mandante = resultado.getNumGolsMandante();
        int visitante = resultado.getNumGolsVisitante();

        if (mandante > visitante) {
            return "Mandante";
        } else if (visitante > mandante) {
            return "Visitante";
        } else {
            return "Empate";
        }
    }
}
