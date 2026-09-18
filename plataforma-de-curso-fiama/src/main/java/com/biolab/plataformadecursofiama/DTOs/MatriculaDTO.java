package com.biolab.plataformadecursofiama.DTOs;

import com.biolab.plataformadecursofiama.entities.Aluno;
import com.biolab.plataformadecursofiama.entities.Curso;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MatriculaDTO {
    private long id;
    private Aluno aluno;
    private Curso curso;

    public MatriculaDTO(Aluno aluno, Curso curso) {
        this.aluno = aluno;
        this.curso = curso;
    }
}
