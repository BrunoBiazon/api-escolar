package com.brunobiazon.api_escola.aluno.dto;

import com.brunobiazon.api_escola.aluno.domain.*;
import com.brunobiazon.api_escola.aluno.dto.*;

import com.brunobiazon.api_escola.endereco.dto.DadosEndereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosCadastroAluno(

    @NotBlank
    String nome,
//
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

    @NotNull @Valid DadosEndereco endereco,

    Long turmaId) {
    }