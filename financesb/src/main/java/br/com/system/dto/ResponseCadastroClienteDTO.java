package br.com.system.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ResponseCadastroClienteDTO {

    private String nome;
    private String email;
}
