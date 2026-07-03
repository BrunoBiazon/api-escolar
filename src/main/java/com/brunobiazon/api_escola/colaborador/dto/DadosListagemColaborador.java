package com.brunobiazon.api_escola.colaborador.dto;

import com.brunobiazon.api_escola.colaborador.domain.*;
import com.brunobiazon.api_escola.colaborador.dto.*;

import com.brunobiazon.api_escola.endereco.domain.Endereco;
import com.brunobiazon.api_escola.pessoa.domain.Role;

public record DadosListagemColaborador(
    Long id,
    String nome,
    String email,
    String cpf,
    String telefone,
    Role role,
    Cargo cargo,
    Endereco endereco
) {
    public DadosListagemColaborador(Colaborador colaborador) {
        this(
            colaborador.getId(),
            colaborador.getNome(),
            colaborador.getEmail(),
            colaborador.getCpf(),
            colaborador.getTelefone(),
            colaborador.getRole(),
            colaborador.getCargo(),
            colaborador.getEndereco()
        );
    }
}