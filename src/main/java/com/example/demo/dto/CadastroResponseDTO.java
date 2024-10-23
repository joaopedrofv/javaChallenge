package com.example.demo.dto;

import com.example.demo.model.Sexo;
import com.example.demo.model.TipoPlano;
import org.springframework.hateoas.Link;

import java.sql.Date;

public record CadastroResponseDTO(
        Long id,
        String nome,
        String sobrenome,
        String email,
        String senha,
        Date dataNascimento,
        Sexo sexo,
        TipoPlano tipoPlano,
        String cep,
        Link link
) {
}
