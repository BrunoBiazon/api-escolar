package com.brunobiazon.api_escola.aluno;

import com.brunobiazon.api_escola.endereco.DadosEndereco;
import com.brunobiazon.api_escola.endereco.Endereco;
import com.brunobiazon.api_escola.professor.DadoAtualizarProfessor;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DadosAtualizarAluno(
        String nome,

        @Email
        String email,

        String senha,

        String cpf,

        String telefone,

        @Pattern(regexp = "\\d{6}")
        String matricula,

        String nome_responsavel,

        @Valid DadosEndereco endereco) {

}