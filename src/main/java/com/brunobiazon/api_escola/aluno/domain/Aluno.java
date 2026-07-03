package com.brunobiazon.api_escola.aluno.domain;

import com.brunobiazon.api_escola.aluno.domain.*;
import com.brunobiazon.api_escola.aluno.dto.*;

import com.brunobiazon.api_escola.pessoa.domain.Pessoa;
import com.brunobiazon.api_escola.pessoa.domain.Role;
import jakarta.persistence.*;
import com.brunobiazon.api_escola.endereco.domain.Endereco;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import com.brunobiazon.api_escola.turma.domain.Turma;

@Table(name= "Alunos")
@Entity(name= "Aluno")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Aluno extends Pessoa {

    private String matricula; // 6 dígitos
    private String nome_responsavel;

    @ManyToOne
    @JoinColumn(name = "turma_id")
    private Turma turma;

    public Aluno(DadosCadastroAluno dados) {
        this.setNome(dados.nome());
        this.setEmail(dados.email());
        this.setSenha(dados.senha());
        this.setCpf(dados.cpf());
        this.setTelefone(dados.telefone());
        this.setEndereco(new Endereco(dados.endereco()));

        this.setRole(Role.ROLE_ALUNO);

        this.matricula = dados.matricula();
        this.nome_responsavel = dados.nome_responsavel();
    }

    public void atualizarDadosPorID(@Valid DadosAtualizarAluno dadosAtualizar) {
        if(dadosAtualizar.nome() != null){
            this.setNome(dadosAtualizar.nome());
        }
        if(dadosAtualizar.email() != null){
            this.setEmail(dadosAtualizar.email());
        }
        if(dadosAtualizar.senha() != null){
            this.setSenha(dadosAtualizar.senha());
        }
        if(dadosAtualizar.telefone() != null){
            this.setTelefone(dadosAtualizar.telefone());
        }
        if(dadosAtualizar.endereco() != null){
            this.setEndereco(new Endereco(dadosAtualizar.endereco()));
        }

        if(dadosAtualizar.matricula() != null){
            this.matricula = dadosAtualizar.matricula();
        }
        if(dadosAtualizar.nome_responsavel() != null){
            this.nome_responsavel = dadosAtualizar.nome_responsavel();
        }
    }
}