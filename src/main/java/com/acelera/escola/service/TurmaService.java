package com.acelera.escola.service;

import com.acelera.escola.converter.TurmaConverter;
import com.acelera.escola.dto.TurmaDTO;
import com.acelera.escola.model.Aluno;
import com.acelera.escola.model.Curso;
import com.acelera.escola.model.Turma;
import com.acelera.escola.repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TurmaService {

    @Autowired
    private TurmaConverter turmaConverter;
    private TurmaRepository turmaRepository;

    public TurmaService(TurmaRepository turmaRepository) {
        this.turmaRepository = turmaRepository;
    }

    public Turma salvar(Turma turma) {
        return this.turmaRepository.save(turma);
    }

    public Boolean salvar(TurmaDTO turmaDTO) {
        Curso curso;
        try {
            CursoService cursoService = new CursoService();
            curso = cursoService.getById(turmaDTO.getId_curso());
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        Turma turma = turmaConverter.turmadtoToTurma(turmaDTO);
        turma.setCurso(curso);
        this.salvar(turma);

        MatriculaService matriculaService = new MatriculaService();
        matriculaService.save(turma,turmaDTO.getId_alunos());

        return true;
    }
}
