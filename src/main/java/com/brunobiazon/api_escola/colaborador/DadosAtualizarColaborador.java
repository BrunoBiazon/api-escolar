package com.brunobiazon.api_escola.colaborador;

import com.brunobiazon.api_escola.endereco.DadosEndereco;
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
