package com.brunobiazon.api_escola.controller;

import com.brunobiazon.api_escola.colaborador.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("colaboradores")
public class ColaboradorController {

    @Autowired
    private ColaboradorRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroColaborador dados) {
        repository.save(new Colaborador(dados));
    }

    @GetMapping
    public Page<DadosListagemColaborador> listar(Pageable paginacao) {
        return repository.findAll(paginacao).map(DadosListagemColaborador::new);
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizarColaborador dadosAtualizar) {
        var colaborador = repository.getReferenceById(dadosAtualizar.id());
        colaborador.atualizarDadosPorID(dadosAtualizar);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
