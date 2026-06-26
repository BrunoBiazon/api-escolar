package com.brunobiazon.api_escola.colaborador;

import com.brunobiazon.api_escola.endereco.DadosEndereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosCadastroColaborador(
    @NotBlank
    String nome,

    @NotBlank
    @Email
    String email,

    @NotBlank
    String senha,

    @NotBlank
    String cpf,

    @NotBlank
    String telefone,

    @NotBlank
    String setor,

    @NotBlank
    String cargo,

    @NotNull
    @Valid
    DadosEndereco endereco) {
    }