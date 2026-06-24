package com.brunobiazon.api_escola.controller;

import com.brunobiazon.api_escola.professor.DadosCadastroProfessor;
import com.brunobiazon.api_escola.professor.DadosListagemProfessor;
import com.brunobiazon.api_escola.professor.Professor;
import com.brunobiazon.api_escola.professor.ProfessorRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    public Page<DadosListagemProfessor> listar(Pageable paginacao) {           // Se enviar requisição por padrão o Spring retorna a listagem total, para utilizar a paginção é necessário -> GET | http://localhost:8080/professores?size=1&page=2
        return repository.findAll(paginacao).map(DadosListagemProfessor::new); // Pageable já faz o .stream e .toList()
    }
}
