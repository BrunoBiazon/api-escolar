package com.brunobiazon.api_escola.professor;

public record DadosListagemProfessor(String nome, String email, Disciplina discplina, String formacao) {

    public DadosListagemProfessor(Professor professor){
        this(professor.getNome(), professor.getEmail(), professor.getDisciplina(), professor.getFormacao());

        }
}
