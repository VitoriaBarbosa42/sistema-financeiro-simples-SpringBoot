package br.com.system.model.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Agencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String cnpj;
    private String numeroAgencia;
    @OneToMany(mappedBy = "numeroAgencia")
    private List<Conta> clientes;

    public Agencia() {}

    public Agencia(String nome, String cnpj, String numeroAgencia) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.numeroAgencia = numeroAgencia;
        this.clientes = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getNumeroAgencia() {
        return numeroAgencia;
    }

    public void setNumeroAgencia(String numeroAgencia) {
        this.numeroAgencia = numeroAgencia;
    }
}
