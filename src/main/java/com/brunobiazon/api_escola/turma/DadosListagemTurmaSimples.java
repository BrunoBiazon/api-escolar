package com.brunobiazon.api_escola.turma;

public record DadosListagemTurmaSimples(
        Long id,
        Etapa_ensino etapaEnsino
) {
    public DadosListagemTurmaSimples(Turma turma) {
        this(turma.getId(), turma.getEtapaEnsino());
    }
}
