package com.brunobiazon.api_escola.aluno;

import com.brunobiazon.api_escola.endereco.Endereco;
import com.brunobiazon.api_escola.pessoa.Role;

public record DadosListagemAluno(Long id, String nome , String email, String senha, String cpf, String matricula,
                                 Role role, String telefone, String nome_responsavel, Endereco endereco) {

    public DadosListagemAluno(Aluno aluno){
        this(aluno.getId(), aluno.getNome(), aluno.getEmail(), aluno.getSenha(), aluno.getCpf(), aluno.getMatricula(), aluno.getRole(), aluno.getTelefone(),  aluno.getNome_responsavel(), aluno.getEndereco());
    }
}
