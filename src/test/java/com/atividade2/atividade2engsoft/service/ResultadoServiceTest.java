package com.atividade2.atividade2engsoft.service;

import com.atividade2.atividade2engsoft.model.Resultado;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class ResultadoServiceTest {

    private ResultadoService resultadoService;
    private Resultado resultado;

    @BeforeEach
    void setup() {
        resultadoService = new ResultadoService(resultado);
    }

    //teste 8
    @Test
    void criarResultadoComGolsInvalido() {
        Resultado resultado = new Resultado();

        assertThrows(IllegalArgumentException.class, () -> {
            resultadoService.criarResultado(-1, -3);
        });


    }


}