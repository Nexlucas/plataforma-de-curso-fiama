package com.biolab.plataformadecursofiama.controllers;

import com.biolab.plataformadecursofiama.DTOs.MatriculaDTO;
import com.biolab.plataformadecursofiama.services.MatriculaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
