package com.atividade2.atividade2engsoft.service;

import com.atividade2.atividade2engsoft.model.Jogador;
import com.atividade2.atividade2engsoft.model.Time;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TimeServiceTest {
    private TimeService timeService;
    private Time time;

    @BeforeEach
    void setup() {
        time = new Time();
        time.setNome("Botafogo-PB");
        timeService = new TimeService(time);
    }


    //teste 3
    @Test
    void deveCalcularCorretamenteMediaDeAlturaDosJogadores() {
        Time time = new Time();

        Jogador j1 = new Jogador();
        j1.setAltura(1.80f);

        Jogador j2 = new Jogador();
        j2.setAltura(1.70f);

        Jogador j3 = new Jogador();
        j3.setAltura(1.90f);

        Set<Jogador> jogadores = new HashSet<>(Arrays.asList(j1, j2, j3));
        time.setJogadores(jogadores);

        Float mediaEsperada = (1.80f + 1.70f + 1.90f) / 3;
        Float mediaCalculada = timeService.calcularMediaDoTime(time);

        assertEquals(mediaEsperada, mediaCalculada, 0.0001f);
    }

    @Test
    void deveRetornarZeroSeNaoHaJogadores() {
        Time time = new Time();
        time.setJogadores(Set.of());

        Float mediaCalculada = timeService.calcularMediaDoTime(time);
        assertEquals(0f, mediaCalculada);
    }

    @Test
    void deveRetornarZeroSeTimeForNulo() {
        Float mediaCalculada = timeService.calcularMediaDoTime(null);
        assertEquals(0f, mediaCalculada);
    }


    //teste 9
    @Test
    void adicionaERemoveJogador() {
        Jogador jogador = new Jogador();
        jogador.setAltura(1.80f);
        jogador.setId(1);
        jogador.setNome("Alberto Junior");
        jogador.setNascimento(LocalDate.of(2000, 1, 1));

        timeService.adicionarJogador(jogador);
        Assertions.assertTrue(time.getJogadores().contains(jogador), "Jogador deve estar no time antes da remoção.");

        timeService.removerJogador(jogador);

        Assertions.assertFalse(time.getJogadores().contains(jogador), "Jogador deve ter sido removido do time.");
    }


    //11
    @Test
    void deveLancarExcecaoAoAdicionarJogadorQueJaTemOutroTime() {
        Time time1 = new Time();
        time1.setNome("Time 1");
        time1.setJogadores(new HashSet<>());

        Time time2 = new Time();
        time2.setNome("Time 2");
        time2.setJogadores(new HashSet<>());

        TimeService service1 = new TimeService(time1);
        TimeService service2 = new TimeService(time2);

        Jogador jogador = new Jogador();
        jogador.setId(12);
        jogador.setNome("Carlos");
        jogador.setAltura(1.80f);
        jogador.setNascimento(LocalDate.of(2000, 1, 1));

        service1.adicionarJogador(jogador);

        assertThrows(IllegalArgumentException.class, () -> {
            service2.adicionarJogador(jogador);
        });
    }
}