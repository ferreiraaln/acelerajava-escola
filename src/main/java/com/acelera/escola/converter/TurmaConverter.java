package com.acelera.escola.converter;

import com.acelera.escola.dto.TurmaDTO;
import com.acelera.escola.model.Turma;
import org.springframework.stereotype.Component;

@Component
public class TurmaConverter {

    public Turma turmadtoToTurma(TurmaDTO turmaDTO){

        Turma turma = new Turma();
        turma.setDataInicio(turmaDTO.getData_inicio());
        turma.setDataFinal(turmaDTO.getData_final());

        return turma;
    }
}
