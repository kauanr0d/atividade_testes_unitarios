package com.atividade2.atividade2engsoft.service;

import com.atividade2.atividade2engsoft.model.Jogador;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class JogadorServiceTest {


    //teste 1
    @Test
    void calcularIdadeTest() {
        Jogador jogador = new Jogador();

        jogador.setNascimento(LocalDate.of(2000, 5, 14));

        Integer idadeCalculada = jogador.calcularIdade();

        int idadeEsperada = LocalDate.now().getYear() - 2000;
        if (LocalDate.now().getDayOfYear() < LocalDate.of(2000, 5, 14).getDayOfYear()) {
            idadeEsperada--;
        }

        assertEquals(idadeEsperada, idadeCalculada);
    }


    //questao 2
    @Test
    void deveLancarExcecaoParaNascimentoNoFuturo() {
        Jogador jogador = new Jogador();
        LocalDate dataFutura = LocalDate.now().plusDays(1);
        Exception excecao = assertThrows(IllegalArgumentException.class, () -> {
            jogador.setNascimento(dataFutura);
        });
        assertEquals("Data de nascimento não pode ser no futuro.", excecao.getMessage());
    }

    // teste/questao 2
    @Test
    void deveLancarExcecaoParaAlturaNegativa() {
        Jogador jogador = new Jogador();
        Exception excecao = assertThrows(IllegalArgumentException.class, () -> {
            jogador.setAltura(-1.75f);
        });
        assertEquals("Altura não pode ser negativa.", excecao.getMessage());
    }
}