package com.brunobiazon.api_escola.professor.dto;

import com.brunobiazon.api_escola.professor.domain.*;
import com.brunobiazon.api_escola.professor.dto.*;

import java.util.List;

public record DadosListagemProfessor(Long Id, String nome, String email, Disciplina discplina, String formacao, List<DadosListagemTurmasProfessor> turmas) {

    public DadosListagemProfessor(Professor professor){
        this(
                professor.getId(),
                professor.getNome(),
                professor.getEmail(),
                professor.getDisciplina(),
                professor.getFormacao(),
                professor.getTurmas() != null ? professor.getTurmas().stream().map(DadosListagemTurmasProfessor::new).toList() : List.of()
        );
    }
}