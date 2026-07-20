package com.brunobiazon.api_escola.turma.dto;

import com.brunobiazon.api_escola.turma.domain.*;
import com.brunobiazon.api_escola.turma.dto.*;

import jakarta.validation.constraints.NotNull;
import java.util.List;

public record DadosCadastroTurma(
        @NotNull
        Etapa_ensino etapaEnsino,

        List<Long> professoresIds
) {
}