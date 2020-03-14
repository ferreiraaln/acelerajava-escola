package com.acelera.escola.service;

import com.acelera.escola.converter.TurmaConverter;
import com.acelera.escola.dto.TurmaDTO;
import com.acelera.escola.model.Turma;
import com.acelera.escola.repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

        Turma turma = turmaConverter.turmadtoToTurma(turmaDTO);
        CursoService cursoService = new CursoService();
        try {
            turma.setCurso( cursoService.getById(turmaDTO.getId_curso()));
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    //bloquinho de aluno
        AlunoService alunoService = new AlunoService();
        alunoService.getByIds(turmaDTO.getId_alunos());

        return true;
    }
}
