package com.brunobiazon.api_escola.controller;

import com.brunobiazon.api_escola.professor.DadosCadastroProfessor;
import com.brunobiazon.api_escola.professor.DadosListagemProfessor;
import com.brunobiazon.api_escola.professor.Professor;
import com.brunobiazon.api_escola.professor.ProfessorRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("professores")
public class ProfessorController {

    @Autowired
    private ProfessorRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroProfessor dados) {
        repository.save(new Professor(dados));
    }

    @GetMapping
    public List<DadosListagemProfessor> listar() {
        return repository.findAll().stream().map(DadosListagemProfessor::new).toList();
    }
}
