package io.github.danielcampossantos.data;

import io.github.danielcampossantos.arvore.Arvore;
import io.github.danielcampossantos.domain.Paciente;

import java.time.LocalDate;

public class PacienteData {
    public static void carregarPacientes(Arvore arvore) {

        arvore.adicionar(new Paciente(
                1050,
                "Lucas Mendes",
                34,
                "Cardiologia",
                LocalDate.of(2026, 7, 20)
        ));

        arvore.adicionar(new Paciente(
                1001,
                "Ana Souza",
                28,
                "Dermatologia",
                LocalDate.of(2026, 7, 15)
        ));

        arvore.adicionar(new Paciente(
                1080,
                "Beatriz Rocha",
                41,
                "Neurologia",
                LocalDate.of(2026, 7, 25)
        ));

        arvore.adicionar(new Paciente(
                1020,
                "Carlos Oliveira",
                45,
                "Ortopedia",
                LocalDate.of(2026, 7, 18)
        ));

        arvore.adicionar(new Paciente(
                99,
                "Fernanda Costa",
                37,
                "Pediatria",
                LocalDate.of(2026, 7, 10)
        ));

        arvore.adicionar(new Paciente(
                1060,
                "Marcelo Silva",
                29,
                "Clinico Geral",
                LocalDate.of(2026, 7, 22)
        ));

        arvore.adicionar(new Paciente(
                1010,
                "Juliana Lima",
                33,
                "Ginecologia",
                LocalDate.of(2026, 7, 17)
        ));

        arvore.adicionar(new Paciente(
                1040,
                "Roberto Santos",
                58,
                "Oftalmologia",
                LocalDate.of(2026, 7, 19)
        ));
    }
}