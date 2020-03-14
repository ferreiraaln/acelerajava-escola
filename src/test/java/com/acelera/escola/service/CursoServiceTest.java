package com.acelera.escola.service;

import com.acelera.escola.model.Curso;
import com.acelera.escola.repository.CursoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CursoServiceTest {

    @Autowired
    private CursoService cursoService;

    private CursoRepository cursoRepository;

    @BeforeEach
    public void setUp() {
        this.cursoRepository = Mockito.mock(CursoRepository.class);
    }

    @Test
    void salvarCursoComSucesso() {

        //entradas
        Curso cursoEsperado = new Curso();
        cursoEsperado.setId(1L);
        cursoEsperado.setDescricao("curso java");
        cursoEsperado.setModalidade("tec");


        Mockito.when(cursoRepository.save(cursoEsperado)).thenReturn(cursoEsperado);

        //execução
        Curso esperado = cursoService.salvar(cursoEsperado);

        //validação
        assertEquals(esperado, cursoEsperado);
        Mockito.verify(cursoRepository, Mockito.times(1)).save(esperado);
    }

}
