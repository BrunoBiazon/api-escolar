package com.brunobiazon.api_escola.colaborador.dto;

import com.brunobiazon.api_escola.colaborador.domain.*;
import com.brunobiazon.api_escola.colaborador.dto.*;

import com.brunobiazon.api_escola.endereco.dto.DadosEndereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizarColaborador(
    @NotNull
    Long id,
    String nome,
    String email,
    String senha,
    String telefone,
    Cargo cargo,
    @Valid
    DadosEndereco endereco
) {
}