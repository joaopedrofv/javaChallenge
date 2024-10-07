package com.example.demo.controller;


import com.example.demo.dto.CadastroRequestDTO;
import com.example.demo.dto.CadastroResponseDTO;
import com.example.demo.model.Cadastro;
import com.example.demo.repository.CadastroRepository;
import com.example.demo.service.CadastroMapper;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
// localhost:8080/cadastros
@RequestMapping(value = "/cadastros", produces = {"application/json"})
@Tag(name = "api-cadastros")
public class CadastroController {
    @Autowired
    private CadastroRepository cadastroRepository;
    @Autowired
    private CadastroMapper cadastroMapper;

    Pageable paginacao = PageRequest.of(0, 2, Sort.by("nome").descending());


    @PostMapping
    public ResponseEntity<CadastroResponseDTO> createCadastro(@Valid @RequestBody CadastroRequestDTO cadastroRequest) {
        if (cadastroRepository.existsById(cadastroRequest.id())) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Cadastro cadastroConvertido = cadastroMapper.requestRecordToCadastro(cadastroRequest);
        Cadastro cadastroCriado = cadastroRepository.save(cadastroConvertido);
        CadastroResponseDTO cadastroResponse = cadastroMapper.cadastroResponseDTO(cadastroCriado);
        return new ResponseEntity<>(cadastroResponse, HttpStatus.CREATED);
    }


    @GetMapping
    public ResponseEntity<List<CadastroResponseDTO>> readCadastros() {
        Page<Cadastro> listaCadastros = cadastroRepository.findAll(paginacao);
        if (listaCadastros.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        List<CadastroResponseDTO> listaCadastrosResponse = new ArrayList<>();
        for (Cadastro cadastro : listaCadastros) {
            CadastroResponseDTO cadastroResponseDTO = cadastroMapper.cadastroResponseDTO(cadastro);
            listaCadastrosResponse.add(cadastroResponseDTO);
        }
        return new ResponseEntity<>(listaCadastrosResponse, HttpStatus.OK);
    }

    @GetMapping("/{id}")
        public ResponseEntity<CadastroResponseDTO> readCadastro(@PathVariable Long id) {
        Optional<Cadastro> cadastroSalvo = cadastroRepository.findById(id);
        if (cadastroSalvo.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        CadastroResponseDTO cadastroResponseDTO = cadastroMapper.cadastroResponseDTO(cadastroSalvo.get());
        return new ResponseEntity<>(cadastroResponseDTO, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CadastroResponseDTO> update(@PathVariable Long id, @Valid @RequestBody
    CadastroRequestDTO cadastroRequestDTO) {
        Optional<Cadastro> cadastroSalvo = cadastroRepository.findById(id);
        if (cadastroSalvo.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Cadastro cadastro = cadastroMapper.requestRecordToCadastro(cadastroRequestDTO);
        cadastro.setId(id);
        Cadastro cadastroAtualizo = cadastroRepository.save(cadastro);

        CadastroResponseDTO cadastroResponseDTO = cadastroMapper.cadastroResponseDTO(cadastroAtualizo);
        return new ResponseEntity<>(cadastroResponseDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        Optional<Cadastro> cadastroSalvo = cadastroRepository.findById(id);
        if (cadastroSalvo.isEmpty()) {
            return new ResponseEntity<>
                    (HttpStatus.BAD_REQUEST);    }    cadastroRepository.delete(cadastroSalvo.get());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
