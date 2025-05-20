package com.atividade2.atividade2engsoft.service;

import com.atividade2.atividade2engsoft.model.Campeonato;
import com.atividade2.atividade2engsoft.model.Time;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

class CampeonatoServiceTest {

    private Campeonato campeonato;
    private CampeonatoService campeonatoService;

    //teste da questao 5
    @BeforeEach
    void setup() {
        campeonato = new Campeonato("Brasileirão Série C", 2025);
        campeonato.setTimes(new HashSet<>());
        campeonatoService = new CampeonatoService(campeonato);
    }
    //teste da questao 5

    @Test
    void adicionarTimeSucesso() {
        Time time = new Time();
        time.setNome("Botafogo-PB");

        assertDoesNotThrow(() -> campeonatoService.adicionarTime(time));
        assertTrue(campeonato.getTimes().contains(time));
    }
    //teste da questao 5

    @Test
    void adicionarTimeDuplicadoLancaExcecao() {
        Time time = new Time();
        time.setNome("Botafogo-PB");

        campeonatoService.adicionarTime(time);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            campeonatoService.adicionarTime(time);
        });

        assertEquals("Time já está no campeonato", exception.getMessage());
    }
}