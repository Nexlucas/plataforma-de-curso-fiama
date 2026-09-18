package com.biolab.plataformadecursofiama.services;

import com.biolab.plataformadecursofiama.DTOs.AlunoDTO;
import com.biolab.plataformadecursofiama.entities.Aluno;
import com.biolab.plataformadecursofiama.repositories.AlunoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {
    private final AlunoRepository alunoRepository;

    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    public String cadrastarAluno (AlunoDTO dto){
        Aluno a = new Aluno();
        a.setNome(dto.getNome());
        a.setEmail(dto.getEmail());
        alunoRepository.save(a);
        return "Aluno cadastrado com sucesso!";
    }

    public List<Aluno> ListarAlunos(){
        List<Aluno> alunos = alunoRepository.findAll();
        return alunos;
    }

    public String alterarAluno (long id, AlunoDTO dto){
        Aluno a = alunoRepository.findById(id).orElseThrow();
        a.setNome(dto.getNome());
        a.setEmail(dto.getEmail());
        alunoRepository.save(a);
        return "Aluno alterado com sucesso!";
    }

    public Aluno alunoID (long id){
        Aluno a = alunoRepository.findById(id).orElseThrow();
        return a;
    }

    public String excluirAluno(long id){
        Aluno a = alunoRepository.findById(id).orElseThrow();
        alunoRepository.delete(a);
        return "Aluno excluido com sucesso!";
    }
}
