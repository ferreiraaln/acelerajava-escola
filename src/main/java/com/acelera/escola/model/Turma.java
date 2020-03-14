package com.acelera.escola.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Turma {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;
    private String dataInicio;
    private String dataFinal;

    @ManyToOne
    @JoinColumn(name = "id_curso",referencedColumnName = "id")
    private Curso curso;

    @OneToMany(mappedBy = "turma")
    private List<Matricula> matriculaList;

    public Turma() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(String dataFinal) {
        this.dataFinal = dataFinal;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public List<Matricula> getMatriculaList() {
        return matriculaList;
    }

    public void setMatriculaList(List<Matricula> matriculaList) {
        this.matriculaList = matriculaList;
    }

    @Override
    public String toString() {
        return "Turma{" +
                "id=" + id +
                ", dataInicio=" + dataInicio +
                ", dataFinal=" + dataFinal +
                ", curso=" + curso +
                '}';
    }
}
