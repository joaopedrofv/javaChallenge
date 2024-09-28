package com.example.demo.dto;

import io.swagger.v3.oas.annotations.links.Link;

import java.util.Date;

public record CadastroResponseDTO(
        Long id,
        String nome,
        String sobrenome,
        String email,
        String senha,
        Date dataNascimento,
        String sexo,
        String tipoPlano,
        int cep
) {
}
