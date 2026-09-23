package com.biolab.plataformadecursofiama.services;

import com.biolab.plataformadecursofiama.DTOs.MatriculaDTO;
import com.biolab.plataformadecursofiama.entities.Aluno;
import com.biolab.plataformadecursofiama.entities.Curso;
import com.biolab.plataformadecursofiama.entities.Matricula;
import com.biolab.plataformadecursofiama.repositories.AlunoRepository;
import com.biolab.plataformadecursofiama.repositories.CursoRepository;
import com.biolab.plataformadecursofiama.repositories.MatriculaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public String matricula(long idAluno, long idCurso){
        Aluno aluno = alunoRepository.findById(idAluno).orElseThrow();
        Curso curso = cursoRepository.findById(idCurso).orElseThrow();
        if (matriculaRepository.existsByAlunoIdAndCursoId(idAluno, idCurso)) {
            return "Matricula ja cadrastada";
        }else {
            Matricula matricula = new Matricula();
            matricula.setAluno(aluno);
            matricula.setCurso(curso);
            matriculaRepository.save(matricula);
            return "Matricula feita com sucesso";
        }

    }

    public String alterarMatricula(long idMatricula, long idAluno, long idCurso){
        Aluno aluno = alunoRepository.findById(idAluno).orElseThrow();
        Curso curso = cursoRepository.findById(idCurso).orElseThrow();
        Matricula matricula = matriculaRepository.findById(idMatricula).orElseThrow();
        matricula.setAluno(aluno);
        matricula.setCurso(curso);
        matriculaRepository.save(matricula);
        return "Matricula alterada com sucesso";
    }

    public String deletarMatricula(long id){
        Matricula matricula = matriculaRepository.findById(id).orElseThrow();
        matriculaRepository.deleteById(id);
        return "Matricula deletada com sucesso";
    }

    public List<Matricula> listarMatriculas(){
        List<Matricula> matriculas = matriculaRepository.findAll();
        return matriculas;
    }
}
