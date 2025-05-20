package com.atividade2.atividade2engsoft.service;

import com.atividade2.atividade2engsoft.model.Estadio;
import com.atividade2.atividade2engsoft.model.Partida;
import com.atividade2.atividade2engsoft.model.Time;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PartidaServiceTest {

    private PartidaService service;
    private Time timeA;
    private Time timeB;
    private Time timeC;
    private Estadio estadioA;
    private Estadio estadioB;

    @BeforeEach
    void setup() {
        service = new PartidaService();

        estadioA = new Estadio();
        estadioA.setNome("Estádio A");

        estadioB = new Estadio();
        estadioB.setNome("Estádio B");

        timeA = new Time();
        timeA.setNome("Time A");
        timeA.setEstadio(estadioA);

        timeB = new Time();
        timeB.setNome("Time B");
        timeB.setEstadio(estadioB);

        timeC = new Time();
        timeC.setNome("Time C");

        service.criarPartida(LocalDate.of(2025, 5, 20), timeA, timeB); // estádio A
        service.criarPartida(LocalDate.of(2025, 5, 20), timeB, timeC); // estádio B
        service.criarPartida(LocalDate.of(2025, 5, 21), timeA, timeC); // estádio A
    }

    //teste 4
    @Test
    void deveCriarPartidaComEstadioDoMandante() {
        PartidaService service = new PartidaService();

        Time mandante = new Time();
        Estadio estadioMandante = new Estadio();
        mandante.setEstadio(estadioMandante);

        Time visitante = new Time();

        LocalDate data = LocalDate.now().plusDays(1);

        Partida partida = service.criarPartida(data, mandante, visitante);

        assertEquals(data, partida.getData());
        assertEquals(mandante, partida.getTimeMandante());
        assertEquals(visitante, partida.getTimeVisitante());
        assertEquals(estadioMandante, partida.getTimeMandante().getEstadio()); // Verifica se pegou do mandante
    }


    //teste 6
    @Test
    void deveFiltrarPartidasPorData() {
        List<Partida> resultado = service.filtrarPorData(LocalDate.of(2025, 5, 20));
        assertEquals(2, resultado.size());
    }
    //teste 6

    @Test
    void deveFiltrarPartidasPorMandante() {
        List<Partida> resultado = service.filtrarPorMandante(timeA);
        assertEquals(2, resultado.size());
        assertTrue(resultado.stream().allMatch(p -> p.getTimeMandante().equals(timeA)));
    }
    //teste 6

    @Test
    void deveFiltrarPartidasPorEstadio() {
        List<Partida> resultado = service.filtrarPorEstadio(estadioA);
        assertEquals(2, resultado.size());
        assertTrue(resultado.stream().allMatch(p -> p.getTimeMandante().getEstadio().equals(estadioA)));
    }

    //teste 7
    @Test
    void estadioDeveCorresponderAoEstadioDeMandanteOuVisitante() {
        PartidaService service = new PartidaService();

        Estadio estadioMandante = new Estadio();
        estadioMandante.setNome("Estádio do Mandante");

        Estadio estadioVisitante = new Estadio();
        estadioVisitante.setNome("Estádio do Visitante");

        Time mandante = new Time();
        mandante.setNome("Time A");
        mandante.setEstadio(estadioMandante);

        Time visitante = new Time();
        visitante.setNome("Time B");
        visitante.setEstadio(estadioVisitante);

        LocalDate data = LocalDate.now().plusDays(1);
        Partida partida = service.criarPartida(data, mandante, visitante);

        Estadio estadioDaPartida = partida.getTimeMandante().getEstadio();

        assertTrue(
                estadioDaPartida.equals(mandante.getEstadio()) ||
                        estadioDaPartida.equals(visitante.getEstadio()),
                "O estádio da partida deve ser o do mandante ou do visitante"
        );
    }


    //teste 10
    @Test
    void deveListarPartidasDeUmDeterminadoDia() {
        PartidaService service = new PartidaService();

        LocalDate hoje = LocalDate.now();
        LocalDate amanha = LocalDate.now().plusDays(1);

        Time mandante = new Time();
        mandante.setNome("Time A");
        Time visitante = new Time();
        visitante.setNome("Time B");

        Partida p1 = service.criarPartida(hoje, mandante, visitante);
        Partida p2 = service.criarPartida(hoje, visitante, mandante);
        Partida p3 = service.criarPartida(amanha, mandante, visitante);

        List<Partida> partidasHoje = service.filtrarPorData(hoje);

        assertEquals(2, partidasHoje.size(), "Devem haver 2 partidas hoje.");
        assertTrue(partidasHoje.contains(p1));
        assertTrue(partidasHoje.contains(p2));
        assertFalse(partidasHoje.contains(p3));
    }

}