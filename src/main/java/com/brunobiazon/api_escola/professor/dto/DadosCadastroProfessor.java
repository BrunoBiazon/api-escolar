package com.brunobiazon.api_escola.professor.dto;

import com.brunobiazon.api_escola.professor.domain.*;
import com.brunobiazon.api_escola.professor.dto.*;

import com.brunobiazon.api_escola.endereco.dto.DadosEndereco;
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
