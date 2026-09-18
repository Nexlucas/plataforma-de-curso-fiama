package com.biolab.plataformadecursofiama.controllers;

import com.biolab.plataformadecursofiama.DTOs.AlunoDTO;
import com.biolab.plataformadecursofiama.entities.Aluno;
import com.biolab.plataformadecursofiama.services.AlunoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("aluno")
public class AlunoController {
    private final AlunoService alunoService;

    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    @PostMapping
    public ResponseEntity<?> cadrastarAluno  (@RequestBody AlunoDTO dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(alunoService.cadrastarAluno(dto));
    }

    @GetMapping
    public List<Aluno> ListarAlunos(){
        return alunoService.ListarAlunos();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> alterarAluno(@PathVariable long id,@RequestBody AlunoDTO dto){
        return ResponseEntity.status(HttpStatus.OK).body(alunoService.alterarAluno(id,dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> busrcarAluno(@PathVariable long id){
        return ResponseEntity.status(HttpStatus.OK).body(alunoService.alunoID(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarAluno(@PathVariable long id){
        return ResponseEntity.status(HttpStatus.OK).body(alunoService.excluirAluno(id));
    }
}
