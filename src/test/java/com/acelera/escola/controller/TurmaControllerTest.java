package com.acelera.escola.controller;

import com.acelera.escola.dto.TurmaDTO;
import com.acelera.escola.model.Aluno;
import com.acelera.escola.model.Curso;
import com.acelera.escola.model.Matricula;
import com.acelera.escola.model.Turma;
import com.acelera.escola.repository.CursoRepository;
import com.acelera.escola.service.AlunoService;
import com.acelera.escola.service.CursoService;
import com.acelera.escola.service.MatriculaService;
import com.acelera.escola.service.TurmaService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class TurmaControllerTest {

    @Autowired
    private MockMvc mvc;

    // Usado para conversão em JSON
    private ObjectMapper mapper = new ObjectMapper();

    @MockBean
    private CursoService cursoService;

    @MockBean
    private TurmaService turmaService;

    @MockBean
    private MatriculaService matriculaService;

    private List<Matricula> getList(Turma turma, List<Long> idAlunos) {
        AlunoService alunoService = new AlunoService();
        List<Matricula> matriculas = new ArrayList<>();

        for (Long id : idAlunos) {
            Aluno aluno = new Aluno();
            aluno.setId(id);

            Matricula matricula = new Matricula();
            matricula.setAluno(aluno);
            matricula.setTurma(turma);
        }

        return matriculas;
    }

    @Test
    void salvarTurma() throws Exception {

        TurmaDTO turmaDTO = new TurmaDTO(1L, "2020-03-14", "2020-05-27", Arrays.asList(1L,2L,3L,4L));
        Turma turma = new Turma();
        Curso curso = new Curso();

        Mockito.when(cursoService.getById(turmaDTO.getId_curso())).thenReturn(curso);



        Mockito.when(matriculaService.save(turma,turmaDTO.getId_alunos())).thenReturn(getList(turma,Arrays.asList(1L,2L,3L,4L)));
        Mockito.when(turmaService.salvar(turma)).thenReturn(turma);













        byte[] turmaJson = toJson(turmaDTO);

        mvc.perform(
                post("/turmas")
                        .content(turmaJson)
                        .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isCreated());

    }





    // Para converte um objeto em byte.
    private byte[] toJson(Object object) throws Exception {
        return this.mapper.writeValueAsString(object).getBytes();
    }
}
