package com.brunobiazon.api_escola.turma.dto;

import com.brunobiazon.api_escola.turma.domain.Etapa_ensino;
import jakarta.validation.constraints.NotNull;
import java.util.List;

public record DadosAtualizarTurma(
                @NotNull Long id,

                Etapa_ensino etapaEnsino,

                List<Long> professoresIds) {
}