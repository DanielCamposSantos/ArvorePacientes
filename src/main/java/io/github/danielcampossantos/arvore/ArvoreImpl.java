package io.github.danielcampossantos.arvore;

import io.github.danielcampossantos.domain.Paciente;
import lombok.Getter;
import lombok.Setter;

import java.util.function.BiPredicate;
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
    public void imprimir() {
        percorrer(raiz, Ordem.IN_ORDEM, no -> System.out.println(no.getValor()));
    }


    private void percorrer(No atual, Ordem ordem, Consumer<No> acao) {
        if (atual == null) return;
        switch (ordem) {
            case PRE_ORDEM -> {
                acao.accept(atual);
                percorrer(atual.getEsquerda(), ordem, acao);
                percorrer(atual.getDireita(), ordem, acao);
            }

            case IN_ORDEM -> {
                percorrer(atual.getEsquerda(), ordem, acao);
                acao.accept(atual);
                percorrer(atual.getDireita(), ordem, acao);
            }

            case POS_ORDEM -> {
                percorrer(atual.getEsquerda(), ordem, acao);
                percorrer(atual.getDireita(), ordem, acao);
                acao.accept(atual);
            }
        }
    }


    private static int getNumeroProntuario(No no) {
        return no.getValor().getNumeroProntuario();
    }

}
