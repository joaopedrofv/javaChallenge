package com.example.demo.model;


import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;

@Entity
@Table(name = "CADASTRO")
@Data
public class Cadastro {
    @Id
    private long id;
    @Column(name = "nome")
    private String nome;
    @Column(name = "sobrenome")
    private String sobrenome;
    @Column(name = "email")
    private String email;
    @Column(name = "senha")
    private String senha;
    @Column(name = "data_nascimento")
    private Date dataNascimento;
    @Column(name = "sexo")
    @Enumerated(EnumType.STRING)
    private Sexo sexo;
    @Column(name = "tipo_plano")
    @Enumerated(EnumType.STRING)
    private TipoPlano tipoPlano;
    @Column(name = "cep")
    private String cep;
}
