package com.brunobiazon.api_escola.professor;

import com.brunobiazon.api_escola.endereco.DadosEndereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record DadosCadastroProfessor(

        @NotBlank
        String nome,

        @NotBlank
        @Email
        String email,

        @NotBlank
        String telefone,

        @NotBlank
        String formacao,

        @NotBlank
        Disciplina disciplina,

        @NotBlank @Valid DadosEndereco endereco) {
}

