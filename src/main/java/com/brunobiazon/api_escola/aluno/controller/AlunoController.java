package com.brunobiazon.api_escola.aluno.controller;

import com.brunobiazon.api_escola.aluno.domain.*;
import com.brunobiazon.api_escola.aluno.dto.*;
import com.brunobiazon.api_escola.turma.domain.TurmaRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("alunos")
public class AlunoController {
    @Autowired
    private AlunoRepository repository;

    @Autowired
    private TurmaRepository turmaRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<DadosListagemAluno> cadastrar(@RequestBody @Valid DadosCadastroAluno dados,
            UriComponentsBuilder uriBuilder) {
        var aluno = new Aluno(dados);
        if (dados.turmaId() != null) {
            var turma = turmaRepository.getReferenceById(dados.turmaId());
            aluno.setTurma(turma);
        }
        repository.save(aluno);

        var uri = uriBuilder.path("/alunos/{id}").buildAndExpand(aluno.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosListagemAluno(aluno));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemAluno>> listar(Pageable paginacao) {
        var page = repository.findAll(paginacao).map(DadosListagemAluno::new);

        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<DadosListagemAluno> atualizar(@RequestBody @Valid DadosAtualizarAluno dadosAtualizar) {
        var aluno = repository.getReferenceById(dadosAtualizar.id());
        aluno.atualizarDadosPorID(dadosAtualizar);
        if (dadosAtualizar.turmaId() != null) {
            var turma = turmaRepository.getReferenceById(dadosAtualizar.turmaId());
            aluno.setTurma(turma);
        }
        return ResponseEntity.ok(new DadosListagemAluno(aluno));
    }

    @DeleteMapping
    @Transactional
    public ResponseEntity<Void> deletar(@RequestParam @Valid Long id) {
        repository.deleteById(id);

        return ResponseEntity.noContent().build();
    }

}
