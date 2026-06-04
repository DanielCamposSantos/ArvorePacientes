package io.github.danielcampossantos;

import io.github.danielcampossantos.arvore.Arvore;
import io.github.danielcampossantos.domain.Paciente;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Arvore arvore = new Arvore();

        arvore.adicionar(Paciente.builder()
                .numeroProntuario(1001)
                .nome("Ana Souza")
                .idade(28)
                .especialidade("Cardiologia")
                .dataConsulta(LocalDate.of(2026, 6, 15))
                .build()
        );

        arvore.adicionar(Paciente.builder()
                .numeroProntuario(1002)
                .nome("Carlos Oliveira")
                .idade(45)
                .especialidade("Ortopedia")
                .dataConsulta(LocalDate.of(2026, 6, 16))
                .build()
        );

        arvore.adicionar(Paciente.builder()
                .numeroProntuario(1003)
                .nome("Mariana Santos")
                .idade(32)
                .especialidade("Dermatologia")
                .dataConsulta(LocalDate.of(2026, 6, 17))
                .build()
        );

        arvore.adicionar(Paciente.builder()
                .numeroProntuario(1004)
                .nome("Roberto Lima")
                .idade(52)
                .especialidade("Neurologia")
                .dataConsulta(LocalDate.of(2026, 6, 18))
                .build()
        );

        arvore.adicionar(Paciente.builder()
                .numeroProntuario(100)
                .nome("Fernanda Costa")
                .idade(37)
                .especialidade("Pediatria")
                .dataConsulta(LocalDate.of(2026, 6, 19))
                .build()
        );

    }
}
