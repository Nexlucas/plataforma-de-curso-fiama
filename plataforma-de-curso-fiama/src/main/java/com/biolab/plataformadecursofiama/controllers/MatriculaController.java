package com.biolab.plataformadecursofiama.controllers;

import com.biolab.plataformadecursofiama.DTOs.MatriculaDTO;
import com.biolab.plataformadecursofiama.services.MatriculaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("matricula")
@RestController
public class MatriculaController {
    private final MatriculaService matriculaService;

    public MatriculaController(MatriculaService matriculaService) {
        this.matriculaService = matriculaService;
    }

    @PostMapping("/{idAluno}/{idCurso}")
    public ResponseEntity<?> fazerMatricula(@PathVariable long idAluno,@PathVariable long idCurso) {
        return ResponseEntity.status(HttpStatus.OK).body(matriculaService.matricula(idAluno, idCurso));
    }

    @PutMapping("/{idMatricula}/{idAluno}/{idCurso}")
    public ResponseEntity<?> alterarMat(@PathVariable long idMatricula,@PathVariable long idAluno,@PathVariable long idCurso){
        return ResponseEntity.status(HttpStatus.OK).body(matriculaService.alterarMatricula(idMatricula, idAluno, idCurso));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarMat(@PathVariable long id){
        return ResponseEntity.status(HttpStatus.OK).body(matriculaService.deletarMatricula(id));
    }

    @GetMapping
    public ResponseEntity<?> listarMat(){
        return ResponseEntity.status(HttpStatus.OK).body(matriculaService.listarMatriculas());
    }
}
