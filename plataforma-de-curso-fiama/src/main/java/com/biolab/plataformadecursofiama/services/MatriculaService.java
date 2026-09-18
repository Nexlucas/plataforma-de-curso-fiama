package com.biolab.plataformadecursofiama.services;

import com.biolab.plataformadecursofiama.DTOs.MatriculaDTO;
import com.biolab.plataformadecursofiama.entities.Aluno;
import com.biolab.plataformadecursofiama.entities.Curso;
import com.biolab.plataformadecursofiama.entities.Matricula;
import com.biolab.plataformadecursofiama.repositories.AlunoRepository;
import com.biolab.plataformadecursofiama.repositories.CursoRepository;
import com.biolab.plataformadecursofiama.repositories.MatriculaRepository;
import org.springframework.stereotype.Service;

@Service
public class MatriculaService {
    private final MatriculaRepository matriculaRepository;
    private final AlunoRepository alunoRepository;
    private final CursoRepository cursoRepository;

    public MatriculaService(MatriculaRepository matriculaRepository, AlunoRepository alunoRepository, CursoRepository cursoRepository) {
        this.matriculaRepository = matriculaRepository;
        this.alunoRepository = alunoRepository;
        this.cursoRepository = cursoRepository;
    }

    public String matricula(long idALuno, long idCurso){
        Aluno aluno = alunoRepository.findById(idALuno).orElseThrow();
        Curso curso = cursoRepository.findById(idCurso).orElseThrow();
        Matricula matricula = new Matricula();
        matricula.setAluno(aluno);
        matricula.setCurso(curso);
        matriculaRepository.save(matricula);
        return "Matricula feita com sucesso";
    }
}
