package com.brunobiazon.api_escola.turma.dto;

import com.brunobiazon.api_escola.turma.domain.*;
import com.brunobiazon.api_escola.turma.dto.*;

import com.brunobiazon.api_escola.aluno.dto.DadosListagemAluno;
import com.brunobiazon.api_escola.professor.dto.DadosListagemProfessor;

import java.util.List;

public record DadosListagemTurma(
        Long id,
        Etapa_ensino etapaEnsino,
        List<DadosListagemProfessor> professores,
        List<DadosListagemAluno> alunos
) {
    public DadosListagemTurma(Turma turma) {
        this(
                turma.getId(),
                turma.getEtapaEnsino(),
                turma.getProfessores() != null ? turma.getProfessores().stream().map(DadosListagemProfessor::new).toList() : List.of(),
                turma.getAlunos() != null ? turma.getAlunos().stream().map(DadosListagemAluno::new).toList() : List.of()
        );
    }
}