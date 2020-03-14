package com.acelera.escola.service;

import com.acelera.escola.model.Curso;
import com.acelera.escola.model.Turma;
import com.acelera.escola.repository.TurmaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TurmaServiceTest {

    private TurmaRepository turmaRepository;

    private  Curso cursoPadrao;
    @BeforeEach
    public void setUp() {
        this.turmaRepository = Mockito.mock(TurmaRepository.class);

        this.cursoPadrao = new Curso();
        this.cursoPadrao.setId(1L);
        this.cursoPadrao.setDescricao("curso java");
        this.cursoPadrao.setModalidade("tec");
    }

    @Test
    void salvarTurmaComSucesso() {

        //entradas
        Turma turmaEsperado = new Turma();
        turmaEsperado.setId(1L);
        turmaEsperado.setDataInicio("2020-03-14");
        turmaEsperado.setDataFinal("2020-05-27");
        turmaEsperado.setCurso(this.cursoPadrao);


        Mockito.when(turmaRepository.save(turmaEsperado)).thenReturn(turmaEsperado);

        //execução
        TurmaService turmaService = new TurmaService(turmaRepository);
        Turma esperado = turmaService.salvar(turmaEsperado);

        //validação
        assertEquals(esperado, turmaEsperado);
        Mockito.verify(turmaRepository, Mockito.times(1)).save(esperado);
    }

}
