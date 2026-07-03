package com.brunobiazon.api_escola.professor.controller;

import com.brunobiazon.api_escola.endereco.dto.DadosEndereco;
import com.brunobiazon.api_escola.professor.domain.*;
import com.brunobiazon.api_escola.professor.dto.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

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
    @Transactional(readOnly = true)
    public Page<DadosListagemProfessor> listar(Pageable paginacao) {           // Se enviar requisição por padrão o Spring retorna a listagem total, para utilizar a paginção é necessário -> GET | http://localhost:8080/professores?size=1&page=2
        return repository.findAll(paginacao).map(DadosListagemProfessor::new); // Pageable já faz o .stream e .toList()
        // Para ordenação, basta acrescentar ?sort=variavel | http://localhost:8080/professores?sort=nome
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadoAtualizarProfessor dadosAtualizar) {
        var professor = repository.getReferenceById(dadosAtualizar.id());
        professor.atualizarDadosPorID(dadosAtualizar);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id){
        repository.deleteById(id);
    }
}
