package com.brunobiazon.api_escola.colaborador.domain;

import com.brunobiazon.api_escola.colaborador.dto.DadosAtualizarColaborador;
import com.brunobiazon.api_escola.colaborador.dto.DadosCadastroColaborador;
import com.brunobiazon.api_escola.endereco.domain.Endereco;
import com.brunobiazon.api_escola.pessoa.domain.Pessoa;
import com.brunobiazon.api_escola.pessoa.domain.Role;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "Colaboradores")
@Entity(name = "Colaborador")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Colaborador extends Pessoa {

    @Enumerated(EnumType.STRING)
    private Cargo cargo;

    public Colaborador(DadosCadastroColaborador dados) {
        this.setNome(dados.nome());
        this.setEmail(dados.email());
        this.setSenha(dados.senha());
        this.setCpf(dados.cpf());
        this.setTelefone(dados.telefone());
        this.setEndereco(new Endereco(dados.endereco()));
        this.setRole(Role.ROLE_COLABORADOR);
        try {
            this.cargo = Cargo.valueOf(dados.cargo().toUpperCase());
        } catch (Exception e) {
            this.cargo = Cargo.ADMINISTRATIVO;
        }
    }

    public void atualizarDadosPorID(@Valid DadosAtualizarColaborador dadosAtualizar) {
        if (dadosAtualizar.nome() != null) {
            this.setNome(dadosAtualizar.nome());
        }
        if (dadosAtualizar.email() != null) {
            this.setEmail(dadosAtualizar.email());
        }
        if (dadosAtualizar.senha() != null) {
            this.setSenha(dadosAtualizar.senha());
        }
        if (dadosAtualizar.telefone() != null) {
            this.setTelefone(dadosAtualizar.telefone());
        }
        if (dadosAtualizar.cargo() != null) {
            this.cargo = dadosAtualizar.cargo();
        }
        if (dadosAtualizar.endereco() != null) {
            this.setEndereco(new Endereco(dadosAtualizar.endereco()));
        }
    }
}