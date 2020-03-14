package com.acelera.escola.controller;

import com.acelera.escola.dto.TurmaDTO;
import com.acelera.escola.service.TurmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/turmas")
public class TurmaController {

    @Autowired
    private TurmaService turmaService;

    @PostMapping
    public ResponseEntity salvarTurma(@RequestBody TurmaDTO turmaDTO){
        if(turmaService.salvar(turmaDTO)){
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }


}
