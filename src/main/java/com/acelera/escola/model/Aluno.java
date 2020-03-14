package com.acelera.escola.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cpf;
    @Column(name = "data_nascimento")
    private Date dataNascimento;
    private String telefone;

    @OneToMany(mappedBy = "aluno")
    private List<Matricula> matriculaList;

    public Aluno() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public List<Matricula> getMatriculaList() {
        return matriculaList;
    }

    public void setMatriculaList(List<Matricula> matriculaList) {
        this.matriculaList = matriculaList;
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "id=" + id +
                ", cpf='" + cpf + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", telefone='" + telefone + '\'' +
                '}';
    }
}
