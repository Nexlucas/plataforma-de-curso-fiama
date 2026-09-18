package com.biolab.plataformadecursofiama.repositories;

import com.biolab.plataformadecursofiama.entities.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
}
