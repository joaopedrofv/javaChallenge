package com.example.demo.dto;

import com.example.demo.model.Sexo;
import com.example.demo.model.TipoPlano;
import jakarta.validation.constraints.*;

import java.sql.Date;

public record CadastroRequestDTO(
        Long id,
        @NotBlank(message = "O nome da pessoa é obrigatório")
        String nome,
        @NotBlank(message = "O sobrenome da pessoa é obrigatório")
        String sobrenome,
        @NotBlank(message = "O e-mail da pessoa é obrigatório")
        @Email(message = "O e-mail deve ser válido")
        String email,
        @NotBlank(message = "A senha da pessoa é obrigatória")
        @Size(min = 8, message = "A senha deve ter pelo menos 8 caracteres")
        @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).+$", message = "A senha deve conter pelo menos uma letra maiúscula, uma letra minúscula e um número.")
        String senha,
        @NotNull(message = "A data de nascimento é obrigatória")
        @Past(message = "A data de nascimento deve ser no passado")
        Date dataNascimento,
        @NotBlank(message = "O sexo da pessoa é obrigatório")
        Sexo sexo,
        @NotBlank(message = "O tipo de plano da pessoa é obrigatório")
        TipoPlano tipoPlano,
        @NotBlank(message = "O CEP é obrigatório")
        @Pattern(regexp = "\\d{5}-\\d{3}", message = "O CEP deve estar no formato 00000-000.")
        String cep
) {
}
