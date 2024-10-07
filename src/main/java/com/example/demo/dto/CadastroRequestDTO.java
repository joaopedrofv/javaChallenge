package com.example.demo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.sql.Date;

public record CadastroRequestDTO(
        Long id,
        @NotBlank(message = "O nome da pessoa é obrigatório")
        String nome,
        @NotBlank(message = "O sobrenome da pessoa é obrigatório")
        String sobrenome,
        @NotBlank(message = "O e-mail da pessoa é obrigatório")
        String email,
        @NotBlank(message = "A senha da pessoa é obrigatória")
        String senha,
        @NotNull(message = "A data de nascimento é obrigatória")
        Date dataNascimento,
        @NotBlank(message = "O sexo da pessoa é obrigatório")
        String sexo,
        @NotBlank(message = "O tipo de plano da pessoa é obrigatório")
        String tipoPlano,
        @NotBlank(message = "O CEP é obrigatório")
        @Pattern(regexp = "\\d{5}-\\d{3}", message = "O CEP deve estar no formato 00000-000.")
        String cep
) {
}
