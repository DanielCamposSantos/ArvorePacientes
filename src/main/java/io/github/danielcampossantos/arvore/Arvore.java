package io.github.danielcampossantos.arvore;

import io.github.danielcampossantos.domain.Paciente;

public interface Arvore {
    void imprimirInOrdem();
    void imprimirPosOrdem();
    void imprimirPreOrdem();

    void adicionar(Paciente paciente);

    void remover(int numeroProntuario);

    Paciente buscar(int numeroProntuario);

}
