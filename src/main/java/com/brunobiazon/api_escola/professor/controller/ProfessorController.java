package com.brunobiazon.api_escola.professor.controller;

import com.brunobiazon.api_escola.professor.domain.Professor;
import com.brunobiazon.api_escola.professor.domain.ProfessorRepository;
import com.brunobiazon.api_escola.professor.dto.DadoAtualizarProfessor;
import com.brunobiazon.api_escola.professor.dto.DadosCadastroProfessor;
import com.brunobiazon.api_escola.professor.dto.DadosListagemProfessor;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("professores")
public class ProfessorController {

    @Autowired
    private ProfessorRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity<DadosListagemProfessor> cadastrar(@RequestBody @Valid DadosCadastroProfessor dados, UriComponentsBuilder uriBuilder) {
        var professor = new Professor(dados);
        repository.save(professor);

        var uri = uriBuilder.path("/professores/{id}").buildAndExpand(professor.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosListagemProfessor(professor));
    }

    @GetMapping
    @Transactional(readOnly = true)
    public ResponseEntity<Page<DadosListagemProfessor>> listar(Pageable paginacao) {
        var page = repository.findAll(paginacao).map(DadosListagemProfessor::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<DadosListagemProfessor> atualizar(@RequestBody @Valid DadoAtualizarProfessor dadosAtualizar) {
        var professor = repository.getReferenceById(dadosAtualizar.id());
        professor.atualizarDadosPorID(dadosAtualizar);

        return ResponseEntity.ok(new DadosListagemProfessor(professor));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> excluir(@PathVariable Long id){
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosListagemProfessor> detalhar(@PathVariable Long id) {
        var professor = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosListagemProfessor(professor));
    }
}
