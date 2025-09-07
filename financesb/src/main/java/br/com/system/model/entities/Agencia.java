package br.com.system.model.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Agencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String nome;

    @Column(nullable = false, length = 14, unique = true)
    private String cnpj;

    @Column(nullable = false, unique = true)
    private String numeroAgencia;

    @Column(nullable = false, length = 20, unique = false)
    private String senha;

    @OneToMany(mappedBy = "numeroAgencia")
    private List<Conta> clientes;

    @OneToMany(mappedBy = "agencia")
    private List<Funcionario> funcionarios;

}
