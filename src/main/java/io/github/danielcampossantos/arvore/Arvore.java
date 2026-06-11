package io.github.danielcampossantos.arvore;

import io.github.danielcampossantos.domain.Paciente;

public interface Arvore {
    void imprimirInOrdem();
    void imprimirPosOrdem();
    void imprimirPreOrdem();

    void adicionar(Paciente paciente);

    // Funcionalidades 7 e 8

    Paciente maiorProntuario();

    Paciente menorProntuario();

}


