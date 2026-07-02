package com.brunobiazon.api_escola.controller;

import com.brunobiazon.api_escola.aluno.*;
import com.brunobiazon.api_escola.aluno.DadosCadastroAluno;
import com.brunobiazon.api_escola.professor.DadosListagemProfessor;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("alunos")
public class AlunoController {
    @Autowired
    private AlunoRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroAluno dados) {
        repository.save(new Aluno(dados));
    }

    @GetMapping
    public Page<DadosListagemAluno> listar(Pageable paginacao){
        return repository.findAll(paginacao).map(DadosListagemAluno::new);
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizarAluno dadosAtualizar) {
        var aluno = repository.getReferenceById(dadosAtualizar.id());
        aluno.atualizarDadosPorID(dadosAtualizar);
    }

    @DeleteMapping
    @Transactional
    public void deletar(@RequestParam @Valid Long id){
        repository.deleteById(id);
    }

}


