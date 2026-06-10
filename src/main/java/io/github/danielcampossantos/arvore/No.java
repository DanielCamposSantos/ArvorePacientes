package io.github.danielcampossantos.arvore;

import io.github.danielcampossantos.domain.Paciente;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class No {
    private Paciente valor;
    private No esquerda;
    private No direita;

    public No(Paciente valor) {
        this.valor = valor;
    }

public int calcularAltura() {
    int alturaEsquerda = 0;
    int alturaDireita = 0;

    if (this.esquerda != null) {
        alturaEsquerda = this.esquerda.calcularAltura();
    }

    if (this.direita != null) {
        alturaDireita = this.direita.calcularAltura();
    }

    if (alturaEsquerda > alturaDireita) {
        return alturaEsquerda + 1;
    } else {
        return alturaDireita + 1;
    }
}

}
