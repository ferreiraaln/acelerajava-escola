package com.acelera.escola.controller;

import com.acelera.escola.dto.TurmaDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class TurmaControllerTest {

    @Autowired
    private MockMvc mvc;
    // Usado para conversão em JSON
    private ObjectMapper mapper = new ObjectMapper();


    void salvarTurma() throws Exception{

        List<Long> ids = new ArrayList<Long>();
        ids.add(1L);
        ids.add(2L);
        ids.add(3L);

        TurmaDTO turmaDTO = new TurmaDTO(1L, "2020-03-14", "2020-05-27", ids);
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
