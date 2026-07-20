package com.brunobiazon.api_escola.professor.dto;

import com.brunobiazon.api_escola.professor.domain.*;
import com.brunobiazon.api_escola.professor.dto.*;

import com.brunobiazon.api_escola.turma.domain.Etapa_ensino;
import com.brunobiazon.api_escola.turma.domain.Turma;

public record DadosListagemTurmasProfessor(
        Long id,
        Etapa_ensino etapaEnsino
) {
    public DadosListagemTurmasProfessor(Turma turma) {
        this(turma.getId(), turma.getEtapaEnsino());
    }
}