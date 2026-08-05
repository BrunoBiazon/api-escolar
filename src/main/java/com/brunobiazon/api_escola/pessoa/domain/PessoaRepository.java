package com.brunobiazon.api_escola.pessoa.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
    Pessoa findByEmail(String email);
}
