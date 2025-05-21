package com.atividade2.atividade2engsoft.service;

import com.atividade2.atividade2engsoft.model.Campeonato;
import com.atividade2.atividade2engsoft.model.Partida;
import com.atividade2.atividade2engsoft.model.Resultado;
import com.atividade2.atividade2engsoft.model.Time;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class CampeonatoServiceTest {

    private Campeonato campeonato;
    private CampeonatoService campeonatoService;
    private Time timeA;
    private Time timeB;

    //teste da questao 5
    @BeforeEach
    void setup() {
        campeonato = new Campeonato("Brasileirão Série C", 2025);
        campeonato.setTimes(new HashSet<>());
        campeonatoService = new CampeonatoService(campeonato);
        campeonato = new Campeonato("Campeonato Teste", 2024);

        timeA = new Time("Time A");
        timeB = new Time("Time B");

        campeonatoService.adicionarTime(timeA);
        campeonatoService.adicionarTime(timeB);
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

    // teste 12
    @Test
    void testClassificacaoComVitoria() {
        Partida partida = new Partida(LocalDate.now(), timeA, timeB);
        Resultado resultado = new Resultado();
        resultado.setNumGolsMandante(2);
        resultado.setNumGolsVisitante(0);
        partida.setResultado(resultado);

        campeonato.getPartidas().add(partida);

        Map<Integer, Time> classificacao = campeonatoService.retornaClassificacao();

        assertEquals(timeA, classificacao.get(1)); // Time A venceu → 3 pontos
        assertEquals(timeB, classificacao.get(2)); // Time B perdeu → 0 pontos
    }

    //teste 13
    @Test
    void testClassificacaoComEmpate() {
        Partida partida = new Partida(LocalDate.now(), timeA, timeB);
        Resultado resultado = new Resultado();
        resultado.setNumGolsMandante(0);
        resultado.setNumGolsVisitante(0);
        partida.setResultado(resultado);

        campeonato.getPartidas().add(partida);

        Map<Integer, Time> classificacao = campeonatoService.retornaClassificacao();

        // Ambos os times empataram → 1 ponto cada
        assertTrue(classificacao.containsValue(timeA));
        assertTrue(classificacao.containsValue(timeB));
    }


}