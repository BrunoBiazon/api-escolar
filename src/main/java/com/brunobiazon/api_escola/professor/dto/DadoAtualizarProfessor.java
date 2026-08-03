package com.brunobiazon.api_escola.professor.dto;

import com.brunobiazon.api_escola.endereco.dto.DadosEndereco;
import com.brunobiazon.api_escola.professor.domain.Disciplina;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record DadoAtualizarProfessor(

                @NotNull Long id,

                String nome,

                String senha,

                @Email(message = "O email deve ser válido.") String email,

                String telefone,

                String formacao,

                Disciplina disciplina,

                @Valid DadosEndereco endereco) {

}