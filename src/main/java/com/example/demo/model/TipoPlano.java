package com.example.demo.model;

public enum TipoPlano {
    INTEGRAL_MEI("Integral MEI"),
    INTEGRAL_PME("Integral PME"),
    MASTER_PME("Master PME");

    private final String descricao;

    TipoPlano(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
