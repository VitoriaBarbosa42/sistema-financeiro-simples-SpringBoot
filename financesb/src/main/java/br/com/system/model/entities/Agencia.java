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

    private String nome;
    private String cnpj;
    private String numeroAgencia;
    @OneToMany(mappedBy = "numeroAgencia")
    private List<Conta> clientes;

    public Agencia(String nome, String cnpj, String numeroAgencia) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.numeroAgencia = numeroAgencia;
        this.clientes = new ArrayList<>();
    }
}
