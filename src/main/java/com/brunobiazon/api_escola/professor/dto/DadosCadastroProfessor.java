package com.brunobiazon.api_escola.professor.dto;

import com.brunobiazon.api_escola.endereco.dto.DadosEndereco;
import com.brunobiazon.api_escola.professor.domain.Disciplina;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroProfessor(

                @NotBlank(message = "O nome deve ser preenchido.") String nome,

                @NotBlank(message = "O email deve ser preenchido.") @Email(message = "O email deve ser válido.") String email,

                @NotBlank(message = "O CPF deve ser preenchido.") String cpf,

                @NotBlank(message = "A senha deve ser preenchida.") String senha,

                @NotBlank(message = "O telefone deve ser preenchido.") String telefone,

                @NotBlank(message = "A formação deve ser preenchida.") String formacao,

                @NotNull(message = "A disciplina deve ser preenchida.") Disciplina disciplina,

                @NotNull(message = "O endereço deve ser preenchido") @Valid DadosEndereco endereco) {
}
