package com.acelera.escola.repository;

import com.acelera.escola.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoRepository  extends JpaRepository<Aluno,Long> {


}
