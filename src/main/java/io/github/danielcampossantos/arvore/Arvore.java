package io.github.danielcampossantos.arvore;

import io.github.danielcampossantos.domain.Paciente;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Arvore {
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


    private void imprimirCrescente(No atual) {
        if (atual != null) {
            imprimirCrescente(atual.getEsquerda());
            System.out.println(atual.getValor());
            imprimirCrescente(atual.getDireita());
        }
    }

    private void imprimirPreOrdem(No atual) {
        if (atual != null) {
            System.out.println(atual.getValor());
            imprimirPreOrdem(atual.getEsquerda());
            imprimirPreOrdem(atual.getDireita());
        }
    }

    private void imprimirPosOrdem(No atual) {
        if (atual != null) {
            imprimirPosOrdem(atual.getEsquerda());
            imprimirPosOrdem(atual.getDireita());
            System.out.println(atual.getValor());
        }
    }


    private static int getNumeroProntuario(No no) {
        return no.getValor().getNumeroProntuario();
    }

}
