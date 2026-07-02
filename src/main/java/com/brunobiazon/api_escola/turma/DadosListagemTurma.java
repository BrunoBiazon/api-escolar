package com.brunobiazon.api_escola.turma;

import com.brunobiazon.api_escola.aluno.DadosListagemAluno;
import com.brunobiazon.api_escola.professor.DadosListagemProfessor;

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
