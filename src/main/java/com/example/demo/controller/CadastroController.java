package com.example.demo.controller;


import com.example.demo.dto.CadastroRequestDTO;
import com.example.demo.dto.CadastroResponseDTO;
import com.example.demo.model.Cadastro;
import com.example.demo.repository.CadastroRepository;
import com.example.demo.service.CadastroMapper;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
// localhost:8080/cadastros
@RequestMapping(value = "/livros", produces = {"application/json"})
@Tag(name = "api-cadastros")
public class CadastroController {
    @Autowired
    private CadastroRepository cadastroRepository;
    @Autowired
    private CadastroMapper cadastroMapper;

    @PostMapping
    public ResponseEntity<CadastroResponseDTO> createCadastro(@Valid @RequestBody CadastroRequestDTO cadastroRequest) {
        Cadastro cadastroConvertido = cadastroMapper.requestRecordToCadastro(cadastroRequest);
        Cadastro cadastroCriado = cadastroRepository.save(cadastroConvertido);
        CadastroResponseDTO cadastroResponse = cadastroMapper.cadastroResponseDTO(cadastroCriado);
        return new ResponseEntity<>(cadastroResponse, HttpStatus.CREATED);
    }
}
