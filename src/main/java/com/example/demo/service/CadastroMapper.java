package com.example.demo.service;

import com.example.demo.dto.CadastroRequestDTO;
import com.example.demo.dto.CadastroResponseDTO;
import com.example.demo.model.Cadastro;
import org.springframework.hateoas.Link;
import org.springframework.stereotype.Service;

@Service
public class CadastroMapper {

    // livroRequestDTO (Record) para Cadastro
    public Cadastro requestRecordToCadastro(CadastroRequestDTO cadastroRequestDTO) {
        Cadastro cadastro = new Cadastro();
        cadastro.setId(cadastroRequestDTO.id());
        cadastro.setNome(cadastroRequestDTO.nome());
        cadastro.setSobrenome(cadastroRequestDTO.sobrenome());
        cadastro.setEmail(cadastroRequestDTO.email());
        cadastro.setSenha(cadastroRequestDTO.senha());
        cadastro.setDataNascimento(cadastroRequestDTO.dataNascimento());
        cadastro.setSexo(cadastroRequestDTO.sexo());
        cadastro.setTipoPlano(cadastroRequestDTO.tipoPlano());
        cadastro.setCep(cadastroRequestDTO.cep());
        return cadastro;
    }

    // cadastro para cadastroResponseDTO (Record)
    public CadastroResponseDTO cadastroResponseDTO(Cadastro cadastro) {
        return new CadastroResponseDTO(
                cadastro.getId(),
                cadastro.getNome(),
                cadastro.getSobrenome(),
                cadastro.getEmail(),
                cadastro.getSenha(),
                cadastro.getDataNascimento(),
                cadastro.getSexo(),
                cadastro.getTipoPlano(),
                cadastro.getCep()
        );
    }
}
