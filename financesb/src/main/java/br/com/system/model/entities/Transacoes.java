package br.com.system.model.entities;

import jakarta.persistence.*;

import java.util.Date;


@Entity
public class Transacoes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date data = new Date();
    private Double valor;

    @ManyToOne
    private Conta conta;

    public Transacoes() {}

    public Transacoes(Double valor) {
        this.data = new Date();
        this.valor = valor;
    }

    public Long getId() {
        return id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
}
