package com.acelera.escola.service;

import com.acelera.escola.model.Aluno;
import com.acelera.escola.model.Matricula;
import com.acelera.escola.model.Turma;
import com.acelera.escola.repository.MatriculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MatriculaService {

    @Autowired
    private MatriculaRepository matriculaRepository;

    public List<Matricula> save(Turma turma, List<Long> idAlunos) {
        AlunoService alunoService = new AlunoService();
        List<Matricula> matriculas = new ArrayList<>();

        for (Aluno aluno : alunoService.getByIds(idAlunos)) {

            Matricula matricula = new Matricula();
            matricula.setAluno(aluno);
            matricula.setTurma(turma);
            matriculas.add(matriculaRepository.save(matricula));
        }

        return matriculas;
    }
}
