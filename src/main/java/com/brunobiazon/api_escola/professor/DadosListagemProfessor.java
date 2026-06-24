package com.brunobiazon.api_escola.professor;

public record DadosListagemProfessor(Long Id, String nome, String email, Disciplina discplina, String formacao) {

    public DadosListagemProfessor(Professor professor){
        this(professor.getId(), professor.getNome(), professor.getEmail(), professor.getDisciplina(), professor.getFormacao());

        }
}
