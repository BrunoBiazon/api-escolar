package com.brunobiazon.api_escola.professor;

import com.brunobiazon.api_escola.colaborador.Cargo;
import com.brunobiazon.api_escola.colaborador.Colaborador;
import com.brunobiazon.api_escola.pessoa.Role;
import jakarta.persistence.*;
import com.brunobiazon.api_escola.endereco.Endereco;
import jakarta.validation.Valid;
import lombok.*;

@Table(name= "professores")
@Entity(name= "Professor")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Professor extends Colaborador {

    private String formacao;

    @Enumerated(EnumType.STRING)
    private Disciplina disciplina;


    public Professor(DadosCadastroProfessor dados) {
        this.setNome(dados.nome());
        this.setEmail(dados.email());
        this.setSenha(dados.senha());
        this.setCpf(dados.cpf());
        this.setTelefone(dados.telefone());
        this.setEndereco(new Endereco(dados.endereco()));
        this.setRole(Role.ROLE_COLABORADOR);
        this.setCargo(Cargo.DOCENTE);

        this.disciplina = dados.disciplina();
        this.formacao = dados.formacao();
    }

    public void atualizarDadosPorID(@Valid DadoAtualizarProfessor dadosAtualizar) {
        if(dadosAtualizar.nome() != null){
            this.setNome(dadosAtualizar.nome());
        }
        if(dadosAtualizar.email() != null){
            this.setEmail(dadosAtualizar.email());
        }
        if (dadosAtualizar.senha() != null){
            this.setSenha(dadosAtualizar.senha());
        }
        if(dadosAtualizar.telefone() != null){
            this.setTelefone(dadosAtualizar.telefone());
        }
        if(dadosAtualizar.disciplina() != null){
            this.disciplina = dadosAtualizar.disciplina();
        }
        if(dadosAtualizar.formacao() != null){
            this.formacao = dadosAtualizar.formacao();
        }
        if(dadosAtualizar.endereco() != null){
            this.setEndereco(new Endereco(dadosAtualizar.endereco()));
        }
    }
}
