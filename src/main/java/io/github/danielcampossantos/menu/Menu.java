package io.github.danielcampossantos.menu;

import io.github.danielcampossantos.arvore.Arvore;
import io.github.danielcampossantos.arvore.ArvoreImpl;
import io.github.danielcampossantos.data.PacienteData;
import io.github.danielcampossantos.domain.Paciente;

import java.time.LocalDate;
import java.util.Scanner;

public class Menu {
    private static final Scanner sc = new Scanner(System.in);
    private static final Arvore arvore = new ArvoreImpl();

    public static void iniciar() {
        PacienteData.carregarPacientes(arvore);
        boolean rodar = true;
        while (rodar) {
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
            rodar = escolhasMenu();
        }
        sc.close();
    }

    private static boolean escolhasMenu() {
        int op = sc.nextInt();
        sc.nextLine();

        switch (op) {
            case 1 -> imprimir();
            case 2 -> adicionar();
            case 3 -> remover();
            case 4 -> buscar();
            case 5 -> informacoesArvore();
            case 0 -> {
                System.out.println("Encerrando o sistema...");
                return false;
            }
            default -> System.err.println("""
                    ==============================
                            OPÇÃO INVÁLIDA
                    ==============================
                    """);
        }
        return true;
    }

    private static void imprimir() {
        boolean voltar = true;
        while (voltar) {
            System.out.println("""
                    ========================
                            IMPRIMIR
                    ========================
                    1 - Ordem crescente
                    2 - Pré-ordem
                    3 - Pós-ordem
                    0 - Voltar
                    """);
            voltar = escolhasImprimir();
        }
    }

    private static boolean escolhasImprimir() {
        int op = sc.nextInt();
        sc.nextLine();

        switch (op) {
            case 1 -> {
                System.out.println("\n=== IMPRESSÃO EM ORDEM CRESCENTE ===");
                arvore.imprimirInOrdem();
                System.out.println();
            }
            case 2 -> {
                System.out.println("\n=== IMPRESSÃO EM PRÉ-ORDEM ===");
                arvore.imprimirPreOrdem();
                System.out.println();
            }
            case 3 -> {
                System.out.println("\n=== IMPRESSÃO EM PÓS-ORDEM ===");
                arvore.imprimirPosOrdem();
                System.out.println();
            }
            case 0 -> {
                return false;
            }
            default -> System.err.println("""
                    ==============================
                            OPÇÃO INVÁLIDA
                    ==============================
                    """);
        }
        return true;
    }

    private static void adicionar() {
        System.out.println("\n=== ADICIONAR PACIENTE ===");

        try {
            System.out.print("Número do Prontuário: ");
            int numeroProntuario = sc.nextInt();
            sc.nextLine(); 

            System.out.print("Nome Completo: ");
            String nome = sc.nextLine();

            System.out.print("Idade: ");
            int idade = sc.nextInt();
            sc.nextLine(); 

            System.out.print("Especialidade: ");
            String especialidade = sc.nextLine();

            System.out.print("Data da Consulta (AAAA-MM-DD): ");
            String dataString = sc.nextLine();
            LocalDate dataConsulta = LocalDate.parse(dataString);

            Paciente novoPaciente = new Paciente(
                    numeroProntuario,
                    nome,
                    idade,
                    especialidade,
                    dataConsulta
            );

            arvore.adicionar(novoPaciente);

            System.out.println("\n Paciente adicionado com sucesso!");
            System.out.println(" Detalhes do paciente:");
            System.out.println(novoPaciente);
            System.out.println();

        } catch (Exception e) {
            System.err.println("\n Erro ao adicionar paciente!");
            System.err.println("Verifique se os dados estão corretos.\n");
            sc.nextLine(); 
        }
    }

    private static void remover() {
        System.out.println("\n=== REMOVER PACIENTE ===");

        try {
            System.out.println("\nLista de Pacientes:");
            arvore.imprimirInOrdem();

            System.out.print("Digite o número do prontuário que deseja remover: ");
            int numeroProntuario = sc.nextInt();
            sc.nextLine();

            Paciente paciente = arvore.buscar(numeroProntuario);

            if (paciente == null) {
                System.out.println("\nPaciente com prontuário " + numeroProntuario + " não encontrado.\n");
                return;
            }

            arvore.remover(numeroProntuario);

            System.out.println("\nPaciente com prontuário " + numeroProntuario +" removido!");

            System.out.println("\nLista de Pacientes Atualizada:");
            arvore.imprimirInOrdem();

            System.out.println();

        } catch (Exception e) {
            System.err.println("\nErro ao remover paciente!");
            System.err.println("Digite um número de prontuário válido.\n");
            sc.nextLine();
        }
    }

    private static void buscar() {
        System.out.println("\n=== BUSCAR PACIENTE ===");

        try {
            System.out.print("Digite o número do prontuário: ");
            int numeroProntuario = sc.nextInt();
            sc.nextLine();

            Paciente paciente = arvore.buscar(numeroProntuario);

            if (paciente == null) {
                System.out.println("\nPaciente com prontuário " + numeroProntuario + " não encontrado.\n");
            } else {
                System.out.println("\nPaciente encontrado:");
                System.out.println(paciente);
            }

        } catch (Exception e) {
            System.err.println("\nErro ao buscar paciente!");
            System.err.println("Digite um número de prontuário válido.\n");
            sc.nextLine();
        }
    }

    private static void informacoesArvore() {
        System.out.println("\n=== INFORMAÇÕES DA ÁRVORE ===");
        // TODO: Implementar lógica de informações
        System.out.println("Funcionalidade em desenvolvimento...\n");
    }
}