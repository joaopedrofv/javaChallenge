package com.example.demo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.Date;

public record CadastroRequestDTO(
        @NotBlank(message = "O nome da pessoa é obrigatório")
        String nome,
        @NotBlank(message = "O sobrenome da pessoa é obrigatório")
        String sobrenome,
        @NotBlank(message = "O e-mail da pessoa é obrigatório")
        String email,
        @NotBlank(message = "A senha da pessoa é obrigatória")
        String senha,
        @NotBlank(message = "A data de nascimento é obrigatória")
        Date dataNascimento,
        @NotBlank(message = "O sexo da pessoa é obrigatório")
        String sexo,
        @NotBlank(message = "O tipo de plano da pessoa é obrigatório")
        String tipoPlano,
        @NotBlank(message = "O CEP é obrigatório")
        @Size(min = 8, max = 8, message = "O CEP deve ter exatamente 8 número")
        int cep
) {
}
