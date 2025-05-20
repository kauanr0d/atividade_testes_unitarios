package com.atividade2.atividade2engsoft.service;


import com.atividade2.atividade2engsoft.model.Jogador;
import com.atividade2.atividade2engsoft.model.Time;

public class TimeService {

    private final Time time;

    public TimeService(Time time) {
        this.time = time;
    }

    public Float calcularMediaDoTime(Time time) {
        Float media = 0.0f;
        if (time != null && time.getJogadores().size() > 0) {
            media = time.getJogadores()
                    .stream()
                    .map(Jogador::getAltura)
                    .reduce(Float::sum)
                    .get() / time.getJogadores().size();
        }
        return media;
    }

    public void adicionarJogador(Jogador jogador) {
        if (jogador.getTimeEmQueJoga() == null) {
            time.adicionarJogador(jogador);
            jogador.setTimeEmQueJoga(time);
        } else if (!jogador.getTimeEmQueJoga().equals(time)) {
            throw new IllegalArgumentException("Jogador já pertence a outro time!");
        }
    }


    public void removerJogador(Jogador jogador) {
        Jogador removido = time.getJogadores()
                .stream()
                .filter(j -> j.getId().equals(jogador.getId())).findFirst().orElse(null);
        removido.sairDoTime();
        time.getJogadores().remove(removido);
    }


}
