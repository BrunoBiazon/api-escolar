
package com.brunobiazon.api_escola.professor;

import jakarta.persistence.*;
import com.brunobiazon.api_escola.endereco.Endereco;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name= "professores")
@Entity(name= "Professor")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Professor {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String email;
    private String telefone;
    private String formacao;

    @Enumerated(EnumType.STRING)
    private Disciplina disciplina;

    @Embedded
    private Endereco endereco;

    public Professor(DadosCadastroProfessor dados) {
        this.nome = dados.nome();
        this.email = dados.email();
        this.telefone = dados.telefone();
        this.disciplina = dados.disciplina();
        this.formacao = dados.formacao();
        this.endereco = new Endereco(dados.endereco());
    }

    public void atualizarDadosPorID(@Valid DadoAtualizarProfessor dadosAtualizar) {
        if(dadosAtualizar.nome() != null){
            this.nome = dadosAtualizar.nome();
        }
        if(dadosAtualizar.email() != null){
            this.email = dadosAtualizar.email();
        }
        if(dadosAtualizar.telefone() != null){
            this.telefone = dadosAtualizar.telefone();
        }
        if(dadosAtualizar.disciplina() != null){
            this.disciplina = dadosAtualizar.disciplina();
        }
        if(dadosAtualizar.formacao() != null){
            this.formacao = dadosAtualizar.formacao();
        }
        if(dadosAtualizar.endereco() != null){
            this.endereco = new Endereco(dadosAtualizar.endereco());
        }
    }
}
