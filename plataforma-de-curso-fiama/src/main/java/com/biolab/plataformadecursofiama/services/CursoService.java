package com.biolab.plataformadecursofiama.services;

import com.biolab.plataformadecursofiama.DTOs.CursoDTO;
import com.biolab.plataformadecursofiama.entities.Curso;
import com.biolab.plataformadecursofiama.repositories.CursoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoService {
    private final CursoRepository cursoRepository;

    public CursoService(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    public String criarCurso(CursoDTO dto){
        Curso c = new Curso();
        c.setNome(dto.getNome());
        c.setCargahoraria(dto.getCargahoraria());
        cursoRepository.save(c);
        return "Curso criado com sucesso!";
    }

    public List<Curso> listarCurso(){
        List<Curso> c = cursoRepository.findAll();
        return c;
    }

    public String alterarCurso(long id, CursoDTO dto){
        Curso c = cursoRepository.findById(id).orElseThrow();
        c.setNome(dto.getNome());
        c.setCargahoraria(dto.getCargahoraria());
        cursoRepository.save(c);
        return "Curso alterado com sucesso!";
    }

    public Curso buscarCurso(long id){
        Curso c = cursoRepository.findById(id).orElseThrow();
        return c;
    }

    public String excluirCurso(long id){
        Curso c = cursoRepository.findById(id).orElseThrow();
        cursoRepository.delete(c);
        return "Curso excluido com sucesso!";
    }
}
