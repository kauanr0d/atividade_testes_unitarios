package com.atividade2.atividade2engsoft.service;

import com.atividade2.atividade2engsoft.model.Jogador;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;

@Service
public class JogadorService {

    private Jogador jogador;

    public Integer calcularIdade(Jogador jogador) {
        if (jogador.getNascimento() == null) {
            throw new IllegalArgumentException("Data de nascimento inválida");
        }
        return Period.between(jogador.getNascimento(), LocalDate.now()).getYears();
    }


}
