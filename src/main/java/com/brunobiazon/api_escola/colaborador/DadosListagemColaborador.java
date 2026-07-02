package com.brunobiazon.api_escola.colaborador;

import com.brunobiazon.api_escola.endereco.Endereco;
import com.brunobiazon.api_escola.pessoa.Role;

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
