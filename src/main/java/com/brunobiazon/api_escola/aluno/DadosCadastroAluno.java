package com.brunobiazon.api_escola.aluno;

import com.brunobiazon.api_escola.endereco.DadosEndereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosCadastroAluno(

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
    @Pattern(regexp = "\\d{6}")
    String matricula,

    @NotBlank
    String nome_responsavel,

    @NotNull @Valid DadosEndereco endereco) {
    }