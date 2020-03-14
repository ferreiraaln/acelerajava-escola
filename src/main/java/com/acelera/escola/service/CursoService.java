package com.acelera.escola.service;

import com.acelera.escola.model.Curso;
import com.acelera.escola.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    public Curso salvar(Curso curso) {
        return cursoRepository.save(curso);
    }

    public Curso getById(Long idCurso) throws Exception {
       Optional<Curso> cursoOpt = cursoRepository.findById(idCurso);

       if(cursoOpt.isPresent()){
            return cursoOpt.get();
       }else{
           throw new Exception("Não Encontrado");
       }
    }
}
