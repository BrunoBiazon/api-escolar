package com.brunobiazon.api_escola.controller;

import com.brunobiazon.api_escola.turma.DadosListagemTurma;
import com.brunobiazon.api_escola.turma.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("turmas")
public class TurmaController {

    @Autowired
    private TurmaRepository repository;

    @GetMapping
    @Transactional(readOnly = true)
    public List<DadosListagemTurma> listar() {
        return repository.findAll().stream().map(DadosListagemTurma::new).toList();
    }
}
