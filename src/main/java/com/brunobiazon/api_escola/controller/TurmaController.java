package com.brunobiazon.api_escola.controller;

import com.brunobiazon.api_escola.professor.ProfessorRepository;
import com.brunobiazon.api_escola.turma.DadosCadastroTurma;
import com.brunobiazon.api_escola.turma.DadosAtualizarTurma;
import com.brunobiazon.api_escola.turma.DadosListagemTurma;
import com.brunobiazon.api_escola.turma.Turma;
import com.brunobiazon.api_escola.turma.TurmaRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("turmas")
public class TurmaController {

    @Autowired
    private TurmaRepository repository;

    @Autowired
    private ProfessorRepository professorRepository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroTurma dados) {
        var turma = new Turma();
        turma.setEtapaEnsino(dados.etapaEnsino());
        if (dados.professoresIds() != null && !dados.professoresIds().isEmpty()) {
            var professores = professorRepository.findAllById(dados.professoresIds());
            turma.setProfessores(professores);
        }
        repository.save(turma);
    }

    @GetMapping
    @Transactional(readOnly = true)
    public List<DadosListagemTurma> listar() {
        return repository.findAll().stream().map(DadosListagemTurma::new).toList();
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizarTurma dados) {
        var turma = repository.getReferenceById(dados.id());
        if (dados.etapaEnsino() != null) {
            turma.setEtapaEnsino(dados.etapaEnsino());
        }
        if (dados.professoresIds() != null) {
            var professores = professorRepository.findAllById(dados.professoresIds());
            turma.setProfessores(professores);
        }
    }
}
