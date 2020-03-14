package com.acelera.escola.dto;

import java.util.List;

public class TurmaDTO {

    private Long id_curso;
    private String data_inicio;
    private String data_final;
    private List<Long> id_alunos;

    public TurmaDTO(Long id_curso, String data_inicio, String data_final, List<Long> id_alunos) {
        this.id_curso = id_curso;
        this.data_inicio = data_inicio;
        this.data_final = data_final;
        this.id_alunos = id_alunos;
    }

    public Long getId_curso() {
        return id_curso;
    }

    public void setId_curso(Long id_curso) {
        this.id_curso = id_curso;
    }

    public String getData_inicio() {
        return data_inicio;
    }

    public void setData_inicio(String data_inicio) {
        this.data_inicio = data_inicio;
    }

    public String getData_final() {
        return data_final;
    }

    public void setData_final(String data_final) {
        this.data_final = data_final;
    }

    public List<Long> getId_alunos() {
        return id_alunos;
    }

    public void setId_alunos(List<Long> id_alunos) {
        this.id_alunos = id_alunos;
    }
}
