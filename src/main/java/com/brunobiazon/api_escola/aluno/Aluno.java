package com.brunobiazon.api_escola.aluno;

import jakarta.persistence.*;
import com.brunobiazon.api_escola.endereco.Endereco;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name= "Alunos")
@Entity(name= "Aluno")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Aluno {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String email;
    private String telefone;
    private String matricula; // 6 dígitos
    private String nome_responsavel;

    @Embedded
    private Endereco endereco;

    public Aluno(DadosCadastroAluno dados) {
        this.nome = dados.nome();
        this.email = dados.email();
        this.telefone = dados.telefone();
        this.matricula = dados.matricula();
        this.nome_responsavel = dados.nome_responsavel();
        this.endereco = new Endereco(dados.endereco());
    }
}
