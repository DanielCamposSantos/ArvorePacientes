package io.github.danielcampossantos.menu;

import java.util.Scanner;

public class Menu {
    private static final Scanner sc = new Scanner(System.in);

    public static void menuInicial() {
        while (true) {
            System.out.println("""
                    ====================================
                            SISTEMA DE PACIENTES
                    ====================================
                    1 - Imprimir
                    2 - Adicionar
                    3 - Remover
                    4 - Buscar
                    5 - Informações da Árvore
                    0 - Sair
                    """);
            int op = sc.nextInt();

            switch (op) {
                case 1 -> imprimir();
                case 2 -> imprimir();
                case 3 -> imprimir();
                case 4 -> imprimir();
                case 5 -> imprimir();
                case 0 -> imprimir();
                default -> System.out.println("Invalido!");
            }
        }
    }

    private static void imprimir() {

    }
}
