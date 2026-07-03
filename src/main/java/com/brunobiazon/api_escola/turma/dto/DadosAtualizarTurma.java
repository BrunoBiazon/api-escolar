package com.brunobiazon.api_escola.turma.dto;

import com.brunobiazon.api_escola.turma.domain.*;
import com.brunobiazon.api_escola.turma.dto.*;

import jakarta.validation.constraints.NotNull;
import java.util.List;

public record DadosAtualizarTurma(
        @NotNull
        Long id,

        Etapa_ensino etapaEnsino,

        List<Long> professoresIds
) {
}