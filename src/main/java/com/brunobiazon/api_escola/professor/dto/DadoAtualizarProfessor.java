package com.brunobiazon.api_escola.professor.dto;

import com.brunobiazon.api_escola.professor.domain.*;
import com.brunobiazon.api_escola.professor.dto.*;

import com.brunobiazon.api_escola.endereco.dto.DadosEndereco;
import jakarta.persistence.Id;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadoAtualizarProfessor(

        @NotNull
        Long id,

        String nome,

        String senha,

        @Email
        String email,

        String telefone,

        String formacao,

        Disciplina disciplina,

        @Valid DadosEndereco endereco){

}