package com.brunobiazon.api_escola.colaborador.dto;

import com.brunobiazon.api_escola.endereco.dto.DadosEndereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroColaborador(
        @NotBlank(message = "O nome deve ser preenchido.") String nome,

        @NotBlank(message = "O email deve ser preenchido.") @Email(message = "O email deve ser válido.") String email,

        @NotBlank(message = "A senha deve ser preenchida.") String senha,

        @NotBlank(message = "O CPF deve ser preenchido.") String cpf,

        @NotBlank(message = "O telefone deve ser preenchido.") String telefone,

        @NotBlank(message = "O setor deve ser preenchido.") String setor,

        @NotBlank(message = "O cargo deve ser preenchido.") String cargo,

        @NotNull(message = "O endereço deve ser preenchido.") @Valid DadosEndereco endereco) {
}