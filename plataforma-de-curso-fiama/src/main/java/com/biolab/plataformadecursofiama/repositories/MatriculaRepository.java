package com.biolab.plataformadecursofiama.repositories;

import com.biolab.plataformadecursofiama.entities.Aluno;
import com.biolab.plataformadecursofiama.entities.Curso;
import com.biolab.plataformadecursofiama.entities.Matricula;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatriculaRepository extends JpaRepository<Matricula, Long> {
    boolean existsByAlunoIdAndCursoId(long alunoId, long cursoId);
}
