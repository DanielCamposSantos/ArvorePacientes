package io.github.danielcampossantos.arvore;

import io.github.danielcampossantos.domain.Paciente;

public class No {
    private Paciente valor;
    private No esquerda;
    private No direita;

    public No(Paciente valor) {
        this.valor = valor;
    }


    public Paciente getValor() {
        return this.valor;
    }

    public No getEsquerda() {
        return this.esquerda;
    }

    public No getDireita() {
        return this.direita;
    }

    public void setValor(Paciente valor) {
        this.valor = valor;
    }

    public void setEsquerda(No esquerda) {
        this.esquerda = esquerda;
    }

    public void setDireita(No direita) {
        this.direita = direita;
    }
}
