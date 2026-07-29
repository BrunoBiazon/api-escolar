package com.brunobiazon.api_escola.aluno.dto;

import com.brunobiazon.api_escola.endereco.dto.DadosEndereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosAtualizarAluno(
                @NotNull Long id,

                String nome,

                @Email String email,

                String senha,

                String telefone,

                @Pattern(regexp = "\\d{6}") String matricula,

                String nome_responsavel,

                @Valid DadosEndereco endereco,

                Long turmaId) {

}