package com.brunobiazon.api_escola.colaborador;

import com.brunobiazon.api_escola.endereco.Endereco;
import com.brunobiazon.api_escola.pessoa.Pessoa;

import com.brunobiazon.api_escola.pessoa.Role;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Table(name = "Colaboradores")
@Entity(name = "Colaborador")
@Getter
@Setter

public class Colaborador extends Pessoa{

    private String setor;
    private String cargo;

    public Colaborador(DadosCadastroColaborador dados) {
        this.setNome(dados.nome());
        this.setEmail(dados.email());
        this.setCargo(dados.cargo());
        this.setCpf(dados.cpf());
        this.setTelefone(dados.telefone());
        this.setEndereco(new Endereco(dados.endereco()));
        this.setRole(Role.ROLE_COLABORADOR);

        this.setor = dados.setor();
        this.cargo = dados.cargo();
    }
}
