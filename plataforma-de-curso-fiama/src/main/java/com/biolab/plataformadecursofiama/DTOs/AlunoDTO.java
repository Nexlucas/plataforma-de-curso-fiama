package com.biolab.plataformadecursofiama.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlunoDTO {
    private long id;
    private String nome;
    private String email;

    public AlunoDTO(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }
}
