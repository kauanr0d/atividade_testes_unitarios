package com.atividade2.atividade2engsoft.model;


public class Resultado {

    private Integer numGolsMandante;
    private Integer numGolsVisitante;

    public Integer getNumGolsMandante() {
        return numGolsMandante;
    }

    public void setNumGolsMandante(Integer numGolsMandante) {
        this.numGolsMandante = numGolsMandante;
    }

    public Integer getNumGolsVisitante() {
        return numGolsVisitante;
    }

    public void setNumGolsVisitante(Integer numGolsVisitante) {
        this.numGolsVisitante = numGolsVisitante;
    }

    public Boolean jogoSaiuEmpatado() {
        return numGolsMandante == numGolsVisitante;
    }



}
