package br.com.system.model.entities;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Funcionario {

    @Setter(AccessLevel.NONE)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nomecompleto", nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String matricula;

    @Column(nullable = false, length = 16)
    private String senha;

    @OneToOne(mappedBy = "funcionarios")
    private Agencia agencia;
}
