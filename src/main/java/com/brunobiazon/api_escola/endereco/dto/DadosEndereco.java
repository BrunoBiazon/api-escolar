package com.brunobiazon.api_escola.endereco.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DadosEndereco(

        @NotBlank(message = "O logradouro deve ser preenchido.") String logradouro,

        @NotBlank(message = "O bairro deve ser preenchido.") String bairro,

        @NotBlank(message = "O CEP deve ser preenchido.") @Pattern(regexp = "\\d{8}") String cep,

        @NotBlank(message = "A UF deve ser preenchida.") String uf,

        String complemento, // Opcional

        @NotBlank(message = "O número deve ser preenchido.") String numero,

        @NotBlank(message = "A cidade deve ser preenchida.") String cidade) {
}