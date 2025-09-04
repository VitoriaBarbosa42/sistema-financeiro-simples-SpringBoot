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
    private Usuario pessoa;

    @ManyToOne
    private Agencia numeroAgencia;

    private String numeroConta;

    private Double saldo = 0.0;

    @OneToMany(mappedBy = "conta")
    private List<Transacoes> transacaoes;

    public Conta(Usuario pessoa, Agencia numeroAgencia, String numeroConta) {
        this.pessoa = pessoa;
        this.numeroAgencia = numeroAgencia;
        this.numeroConta = numeroConta;
        this.transacaoes = new ArrayList<>();
    }
}
