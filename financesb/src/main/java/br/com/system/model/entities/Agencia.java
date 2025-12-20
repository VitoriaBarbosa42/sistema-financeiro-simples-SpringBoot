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

    @Column(name = "numeroagencia",nullable = false, unique = true)
    private String numeroAgencia;

    @Column(nullable = false, length = 16)
    private String senha;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "conta_id", unique = true)
    private Conta conta;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "funcionarios_id", unique = true)
    private Funcionario funcionarios;

    public Agencia(String nome, String numeroAgencia, String cnpj, String senha, Funcionario funcionarios, Conta conta) {
        this.nome = nome;
        this.numeroAgencia = numeroAgencia;
        this.cnpj = cnpj;
        this.senha = senha;
        this.conta = conta;
        this.funcionarios = funcionarios;
    }
}
