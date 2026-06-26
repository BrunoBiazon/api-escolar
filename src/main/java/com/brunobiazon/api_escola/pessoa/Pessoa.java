package com.brunobiazon.api_escola.pessoa;

import com.brunobiazon.api_escola.endereco.Endereco;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "Pessoas")
@Entity(name = "Pessoa")
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public abstract class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String email;
    private String telefone;
    private String senha;
    private String cpf;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Embedded
    private Endereco endereco;

}
