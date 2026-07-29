package com.brunobiazon.api_escola.turma.domain;

import com.brunobiazon.api_escola.professor.domain.Professor;
import com.brunobiazon.api_escola.aluno.domain.Aluno;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Table(name = "Turmas")
@Entity(name = "Turma")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Turma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Etapa_ensino etapaEnsino;

    @ManyToMany
    @JoinTable(name = "turma_professores", joinColumns = @JoinColumn(name = "turma_id"), inverseJoinColumns = @JoinColumn(name = "professor_id"))
    private List<Professor> professores;

    @OneToMany(mappedBy = "turma")
    private List<Aluno> alunos;
}