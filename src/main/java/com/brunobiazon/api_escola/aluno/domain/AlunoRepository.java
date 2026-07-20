package com.brunobiazon.api_escola.aluno.domain;

import com.brunobiazon.api_escola.aluno.domain.*;
import com.brunobiazon.api_escola.aluno.dto.*;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
}