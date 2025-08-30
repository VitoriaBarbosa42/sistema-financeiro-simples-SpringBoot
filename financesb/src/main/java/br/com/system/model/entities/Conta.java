package br.com.system.model.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Conta {

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

    public Conta(){}

    public Conta(Usuario pessoa, Agencia numeroAgencia, String numeroConta) {
        this.pessoa = pessoa;
        this.numeroAgencia = numeroAgencia;
        this.numeroConta = numeroConta;
        this.transacaoes = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public Usuario getPessoa() {
        return pessoa;
    }

    public void setPessoa(Usuario pessoa) {
        this.pessoa = pessoa;
    }

    public Agencia getNumeroAgencia() {
        return numeroAgencia;
    }

    public void setNumeroAgencia(Agencia numeroAgencia) {
        this.numeroAgencia = numeroAgencia;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public List<Transacoes> getTransacaoes() {
        return transacaoes;
    }

    public void setTransacaoes(List<Transacoes> transacaoes) {
        this.transacaoes = transacaoes;
    }
}
