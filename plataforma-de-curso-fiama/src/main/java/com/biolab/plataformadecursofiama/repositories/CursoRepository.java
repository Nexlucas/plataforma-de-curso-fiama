package com.biolab.plataformadecursofiama.repositories;

import com.biolab.plataformadecursofiama.entities.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Long> {
}
