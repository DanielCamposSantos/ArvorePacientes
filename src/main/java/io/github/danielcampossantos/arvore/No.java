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



}
