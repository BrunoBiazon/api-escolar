package com.brunobiazon.api_escola.endereco.dto;

import com.brunobiazon.api_escola.endereco.domain.*;
import com.brunobiazon.api_escola.endereco.dto.*;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DadosEndereco(

        @NotBlank
        String logradouro,

        @NotBlank
        String bairro,

        @NotBlank
        @Pattern(regexp = "\\d{8}")
        String cep,

        @NotBlank
        String uf,

        // Opcional o cadastro
        String complemento,

        @NotBlank
        String numero,

        @NotBlank
        String cidade) {
}