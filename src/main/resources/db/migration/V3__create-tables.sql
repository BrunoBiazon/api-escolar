DROP TABLE IF EXISTS professores;
-- Cria a todas as tabelas atuais
CREATE TABLE Pessoas (
    id BIGINT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    telefone VARCHAR(20) NOT NULL,
    senha VARCHAR(255) NOT NULL,
    cpf VARCHAR(14) NOT NULL UNIQUE,
    role VARCHAR(50) NOT NULL,
    logradouro VARCHAR(100) NOT NULL,
    bairro VARCHAR(100) NOT NULL,
    cep VARCHAR(9) NOT NULL,
    complemento VARCHAR(100),
    numero VARCHAR(20),
    uf CHAR(2) NOT NULL,
    cidade VARCHAR(100) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE Colaboradores (
    id BIGINT NOT NULL,
    cargo VARCHAR(50) NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT fk_colaboradores_pessoas FOREIGN KEY (id) REFERENCES Pessoas (id) ON DELETE CASCADE
);

CREATE TABLE professores (
    id BIGINT NOT NULL,
    formacao VARCHAR(100) NOT NULL,
    disciplina VARCHAR(50) NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT fk_professores_colaboradores FOREIGN KEY (id) REFERENCES Colaboradores (id) ON DELETE CASCADE
);

CREATE TABLE turmas (
    id BIGINT NOT NULL AUTO_INCREMENT,
    etapa_ensino VARCHAR(50) NOT NULL,
    PRIMARY KEY (id)
);


CREATE TABLE Alunos (
    id BIGINT NOT NULL,
    matricula VARCHAR(20) NOT NULL UNIQUE,
    nome_responsavel VARCHAR(100) NOT NULL,
    turma_id BIGINT,
    PRIMARY KEY (id),
    CONSTRAINT fk_alunos_pessoas FOREIGN KEY (id) REFERENCES Pessoas (id) ON DELETE CASCADE,
    CONSTRAINT fk_alunos_turmas FOREIGN KEY (turma_id) REFERENCES turmas (id) ON DELETE SET NULL
);

CREATE TABLE turma_professores (
    turma_id BIGINT NOT NULL,
    professor_id BIGINT NOT NULL,
    PRIMARY KEY (turma_id, professor_id),
    CONSTRAINT fk_turmaprof_turmas FOREIGN KEY (turma_id) REFERENCES turmas (id) ON DELETE CASCADE,
    CONSTRAINT fk_turmaprof_professores FOREIGN KEY (professor_id) REFERENCES professores (id) ON DELETE CASCADE
);
