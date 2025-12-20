package br.com.system.model.entities;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Conta {

    @Setter(AccessLevel.NONE)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @PrimaryKeyJoinColumn(name = "id_usuario")
    private Usuario pessoa;

    @OneToOne(mappedBy = "conta")
    @JoinColumn(name = "id_agencia")
    private Agencia agencia;

    private String numeroConta;

    private Double saldo = 0.0;

    @ManyToOne
    @JoinColumn(name = "id_transacoes")
    @Column(unique = true)
    private Transacoes transacoes;


    public Conta(Usuario pessoa, Agencia numeroAgencia, String numeroConta, Transacoes transacaes) {
        this.pessoa = pessoa;
        this.agencia = numeroAgencia;
        this.numeroConta = numeroConta;
        this.transacoes = transacaes;
    }
}
