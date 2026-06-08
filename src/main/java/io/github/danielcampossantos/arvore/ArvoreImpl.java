package io.github.danielcampossantos.arvore;

import io.github.danielcampossantos.domain.Paciente;
import lombok.Getter;
import lombok.Setter;

import java.util.function.Consumer;

@Getter
@Setter
public class ArvoreImpl implements Arvore {
    private No raiz;


    public void adicionar(Paciente paciente) {
        No novoValor = new No(paciente);
        percorrerAdicionar(raiz, raiz, novoValor);
    }

    private void percorrerAdicionar(No pai, No atual, No novoValor) {
        if (atual == null) {
            if (pai == null) {
                this.raiz = novoValor;
            } else {
                if (getNumeroProntuario(novoValor) <= getNumeroProntuario(pai)) {
                    pai.setEsquerda(novoValor);
                } else {
                    pai.setDireita(novoValor);
                }
            }
        } else {
            if (getNumeroProntuario(novoValor) <= getNumeroProntuario(atual)) {
                percorrerAdicionar(atual, atual.getEsquerda(), novoValor);
            } else {
                percorrerAdicionar(atual, atual.getDireita(), novoValor);
            }
        }
    }


    @Override
    public void imprimirInOrdem() {
        inOrdem(raiz);
    }

    @Override
    public void imprimirPreOrdem() {
        preOrdem(raiz);
    }

    @Override
    public void imprimirPosOrdem() {
        posOrdem(raiz);
    }


    private void inOrdem(No atual) {
        if (atual == null) return;
        inOrdem(atual.getEsquerda());
        System.out.println(atual.getValor());
        inOrdem(atual.getDireita());
    }

    private void preOrdem(No atual) {
        if (atual == null) return;
        System.out.println(atual.getValor());
        preOrdem(atual.getEsquerda());
        preOrdem(atual.getDireita());
    }

    private void posOrdem(No atual) {
        if (atual == null) return;
        posOrdem(atual.getEsquerda());
        posOrdem(atual.getDireita());
        System.out.println(atual.getValor());
    }


    private static int getNumeroProntuario(No no) {
        return no.getValor().getNumeroProntuario();
    }

}
