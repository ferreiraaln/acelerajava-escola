package com.acelera.escola.model;

import javax.persistence.*;

@Entity
public class Matricula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_turma",referencedColumnName = "id")
    private  Turma turma;

    @ManyToOne
    @JoinColumn(name = "id_aluno",referencedColumnName = "id")
    private Aluno aluno;

    public Matricula() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    @Override
    public String toString() {
        return "Matricula{" +
                "id=" + id +
                ", turma=" + turma +
                ", aluno=" + aluno +
                '}';
    }
}
