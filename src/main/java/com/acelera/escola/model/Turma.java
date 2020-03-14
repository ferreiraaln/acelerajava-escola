package com.acelera.escola.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Turma {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;
    private Date dataInicio;
    private Date dataFinal;

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

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(Date dataFinal) {
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
