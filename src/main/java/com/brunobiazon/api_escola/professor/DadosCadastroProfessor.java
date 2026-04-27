package com.brunobiazon.api_escola.professor;

import com.brunobiazon.api_escola.endereco.DadosEndereco;

public record DadosCadastroProfessor(String Nome, String email, String formacao, Disciplina disciplina, DadosEndereco endereco) {

}
