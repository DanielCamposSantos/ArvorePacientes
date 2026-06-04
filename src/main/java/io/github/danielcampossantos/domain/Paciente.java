package io.github.danielcampossantos.domain;

import lombok.*;

import java.time.LocalDate;

@ToString
@Builder
@Getter
@Setter
@AllArgsConstructor
public class Paciente {
    private int numeroProntuario;
    private String nome;
    private int idade;
    private String especialidade;
    private LocalDate dataConsulta;

}
