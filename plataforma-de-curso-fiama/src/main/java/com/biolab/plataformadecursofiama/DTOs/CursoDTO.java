package com.biolab.plataformadecursofiama.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CursoDTO {
    private long Id;
    private String nome;
    private int cargahoraria;

    public CursoDTO(String nome, int cargahoraria) {
        this.nome = nome;
        this.cargahoraria = cargahoraria;
    }
}
