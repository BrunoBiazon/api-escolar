package com.brunobiazon.api_escola.professor;

import com.brunobiazon.api_escola.turma.DadosListagemTurmaSimples;

import java.util.List;

public record DadosListagemProfessor(Long Id, String nome, String email, Disciplina discplina, String formacao, List<DadosListagemTurmaSimples> turmas) {

    public DadosListagemProfessor(Professor professor){
        this(
                professor.getId(),
                professor.getNome(),
                professor.getEmail(),
                professor.getDisciplina(),
                professor.getFormacao(),
                professor.getTurmas() != null ? professor.getTurmas().stream().map(DadosListagemTurmaSimples::new).toList() : List.of()
        );
    }
}
