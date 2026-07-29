package com.brunobiazon.api_escola.colaborador.controller;

import com.brunobiazon.api_escola.colaborador.domain.Colaborador;
import com.brunobiazon.api_escola.colaborador.domain.ColaboradorRepository;
import com.brunobiazon.api_escola.colaborador.dto.DadosAtualizarColaborador;
import com.brunobiazon.api_escola.colaborador.dto.DadosCadastroColaborador;
import com.brunobiazon.api_escola.colaborador.dto.DadosListagemColaborador;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("colaboradores")
public class ColaboradorController {

    @Autowired
    private ColaboradorRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity<DadosListagemColaborador> cadastrar(@RequestBody @Valid DadosCadastroColaborador dados,
            UriComponentsBuilder uriBuilder) {
        var colaborador = new Colaborador(dados);
        repository.save(colaborador);

        var uri = uriBuilder.path("/colaboradores/{id}").buildAndExpand(colaborador.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosListagemColaborador(colaborador));
    }

    @GetMapping
    @Transactional(readOnly = true)
    public ResponseEntity<Page<DadosListagemColaborador>> listar(Pageable paginacao) {

        var page = repository.findAll(paginacao).map(DadosListagemColaborador::new);

        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<DadosListagemColaborador> atualizar(
            @RequestBody @Valid DadosAtualizarColaborador dadosAtualizar) {
        var colaborador = repository.getReferenceById(dadosAtualizar.id());
        colaborador.atualizarDadosPorID(dadosAtualizar);

        return ResponseEntity.ok(new DadosListagemColaborador(colaborador));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
