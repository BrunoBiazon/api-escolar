package com.brunobiazon.api_escola.controller;

import com.brunobiazon.api_escola.professor.DadosCadastroProfessor;
import com.brunobiazon.api_escola.professor.Professor;
import com.brunobiazon.api_escola.professor.ProfessorRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}