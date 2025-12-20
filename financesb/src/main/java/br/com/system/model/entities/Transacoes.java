package br.com.system.model.entities;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Transacoes {

    @Setter(AccessLevel.NONE)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "data_evento")
    private ZonedDateTime DataEHora;

    private Double valor;

    @OneToMany (mappedBy = "transacoes")
    private List <Conta> conta;

    public Transacoes(Double valor) {
        this.DataEHora = ZonedDateTime.now(ZoneId.of("America/Sao_Paulo"));
        this.valor = valor;
        this.conta = new ArrayList<>();
    }
}
