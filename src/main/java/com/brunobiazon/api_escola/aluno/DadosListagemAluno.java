package com.brunobiazon.api_escola.aluno;

import com.brunobiazon.api_escola.endereco.Endereco;

public record DadosListagemAluno(Long id, String nome , String email, String matricula, String telefone, String nome_responsavel, Endereco endereco) {

    public DadosListagemAluno(Aluno aluno){
        this(aluno.getId(), aluno.getNome(), aluno.getEmail(), aluno.getMatricula(), aluno.getTelefone(),  aluno.getNome_responsavel(), aluno.getEndereco());
    }
}
