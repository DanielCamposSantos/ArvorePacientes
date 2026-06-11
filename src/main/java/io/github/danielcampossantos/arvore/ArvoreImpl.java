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
    public void remover(int numeroProntuario) {
        this.raiz = remover(this.raiz, numeroProntuario);
    }

    private No remover(No atual, int numeroProntuario) {
        if (atual == null) {
            return null;
        }

        int prontuarioAtual = atual.getValor().getNumeroProntuario();

        if (numeroProntuario < prontuarioAtual) {
            atual.setEsquerda(remover(atual.getEsquerda(), numeroProntuario));
        } else if (numeroProntuario > prontuarioAtual) {
            atual.setDireita(remover(atual.getDireita(), numeroProntuario));
        } else {

            if (atual.getEsquerda() == null && atual.getDireita() == null) {
                return null;
            }

            if (atual.getEsquerda() == null) {
                return atual.getDireita();
            }

            if (atual.getDireita() == null) {
                return atual.getEsquerda();
            }

            No sucessor = encontrarMenor(atual.getDireita());
            atual.setValor(sucessor.getValor());

            atual.setDireita(
                    remover(atual.getDireita(), sucessor.getValor().getNumeroProntuario())
            );
        }

        return atual;
    }

    private No encontrarMenor(No no) {
        while (no.getEsquerda() != null) {
            no = no.getEsquerda();
        }
        return no;
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
