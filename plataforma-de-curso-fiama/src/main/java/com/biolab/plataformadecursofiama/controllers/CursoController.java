package com.biolab.plataformadecursofiama.controllers;

import com.biolab.plataformadecursofiama.DTOs.AlunoDTO;
import com.biolab.plataformadecursofiama.DTOs.CursoDTO;
import com.biolab.plataformadecursofiama.services.CursoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("curso")
@RestController
public class CursoController {
    private final CursoService cursoService;

    public CursoController(CursoService cursoService) {
        this.cursoService = cursoService;
    }
    @PostMapping
    public ResponseEntity<?> criarCurso(@RequestBody CursoDTO dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(cursoService.criarCurso(dto));
    }

    @GetMapping
    public ResponseEntity<?> listarCurso(){
        return ResponseEntity.status(HttpStatus.OK).body(cursoService.listarCurso());
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> alterarCurso(@PathVariable long id, @RequestBody CursoDTO dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(cursoService.alterarCurso(id,dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarCurso(@PathVariable long id){
        return ResponseEntity.status(HttpStatus.OK).body(cursoService.buscarCurso(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> excluirCurso(@PathVariable long id){
        return ResponseEntity.status(HttpStatus.OK).body(cursoService.excluirCurso(id));
    }
}
