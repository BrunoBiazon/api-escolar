package com.brunobiazon.api_escola.professor;

import com.brunobiazon.api_escola.endereco.DadosEndereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroProfessor(

        @NotBlank
        String nome,

        @NotBlank
        @Email
        String email,

        @NotBlank
        String cpf,

        @NotBlank
        String senha,

        @NotBlank
        String telefone,

        @NotBlank
        String formacao,

        @NotNull
        Disciplina disciplina,

        @NotNull @Valid DadosEndereco endereco) {
}

