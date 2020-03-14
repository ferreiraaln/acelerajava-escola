package com.acelera.escola.service;

import com.acelera.escola.model.Aluno;
import com.acelera.escola.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    public Aluno salvar(Aluno aluno) {

        if(aluno.getNome() == null){
            throw new IllegalArgumentException("Nome não pode ser null");
        }

        return alunoRepository.save(aluno);
    }

    public List<Aluno> getByIds(List<Long> ids){

        List<Aluno> alunos = new ArrayList<Aluno>();
        alunoRepository.findAll(ids);

        return null;
    }

}
