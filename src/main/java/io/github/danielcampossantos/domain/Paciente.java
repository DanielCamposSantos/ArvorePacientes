package io.github.danielcampossantos.domain;

import java.time.LocalDate;

public class Paciente {
    private int numeroProntuario;
    private String nome;
    private int idade;
    private String especialidade;
    private LocalDate dataConsulta;

    public Paciente(int numeroProntuario, String nome, int idade, String especialidade, LocalDate dataConsulta) {
        this.numeroProntuario = numeroProntuario;
        this.nome = nome;
        this.idade = idade;
        this.especialidade = especialidade;
        this.dataConsulta = dataConsulta;
    }

    public int getNumeroProntuario() {
        return this.numeroProntuario;
    }

    public String getNome() {
        return this.nome;
    }

    public int getIdade() {
        return this.idade;
    }

    public String getEspecialidade() {
        return this.especialidade;
    }

    public LocalDate getDataConsulta() {
        return this.dataConsulta;
    }

    public void setNumeroProntuario(int numeroProntuario) {
        this.numeroProntuario = numeroProntuario;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public void setDataConsulta(LocalDate dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

    @Override
    public String toString() {
        return "Paciente {" +
                "\n  Prontuário: " + this.getNumeroProntuario() +
                "\n  Nome: " + this.getNome() +
                "\n  Idade: " + this.getIdade() +
                "\n  Especialidade: " + this.getEspecialidade() +
                "\n  Data da Consulta: " + this.getDataConsulta() +
                "\n}\n";
    }
}
