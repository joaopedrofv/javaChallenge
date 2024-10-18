package com.example.demo.dto;

import org.springframework.hateoas.Link;

import java.sql.Date;

public record CadastroResponseDTO(
        Long id,
        String nome,
        String sobrenome,
        String email,
        String senha,
        Date dataNascimento,
        String sexo,
        String tipoPlano,
        String cep,
        Link link
) {
}
