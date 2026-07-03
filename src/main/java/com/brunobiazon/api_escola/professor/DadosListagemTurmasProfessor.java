package com.brunobiazon.api_escola.professor;

import com.brunobiazon.api_escola.turma.Etapa_ensino;
import com.brunobiazon.api_escola.turma.Turma;

public record DadosListagemTurmasProfessor(
        Long id,
        Etapa_ensino etapaEnsino
) {
    public DadosListagemTurmasProfessor(Turma turma) {
        this(turma.getId(), turma.getEtapaEnsino());
    }
}
