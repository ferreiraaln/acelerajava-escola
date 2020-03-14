package com.acelera.escola.service;

import com.acelera.escola.model.Aluno;
import com.acelera.escola.repository.AlunoRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AlunoServiceTest {

    @Autowired
    private AlunoService alunoService;

    private AlunoRepository alunoRepository;

    @BeforeEach
    public void setUp() {
        this.alunoRepository = Mockito.mock(AlunoRepository.class);
    }

    @Test
    void salvarAlunoComSucesso() {

        //entradas
        Aluno alunoEsperado = new Aluno();
        alunoEsperado.setId(1L);
        alunoEsperado.setNome("João das cove");
        alunoEsperado.setCpf("02797700066");
        alunoEsperado.setDataNascimento("2000-01-01 01:0");
        alunoEsperado.setTelefone("5132547841");

        Mockito.when(alunoRepository.save(alunoEsperado)).thenReturn(alunoEsperado);

        //execução
        Aluno esperado = alunoService.salvar(alunoEsperado);

        //validação
        assertEquals(esperado,alunoEsperado);
        Mockito.verify(alunoRepository, Mockito.times(1)).save(esperado);
    }

    @Test()
    void falhaAoSalvarAlunoSemNome() {
        // entradas / inputs
        Aluno alunoEsperado = new Aluno();
        alunoEsperado.setId(1L);
        alunoEsperado.setNome(null);
        alunoEsperado.setCpf("02797700066");
        alunoEsperado.setDataNascimento("2000-01-01 01:0");
        alunoEsperado.setTelefone("5132547841");

        // execução

        // verificação / validação
        Assertions.assertThatThrownBy(() -> {

            alunoService.salvar(alunoEsperado);

        }).isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("Nome não pode ser null");

        Mockito.verifyNoInteractions(alunoRepository);
    }
}
