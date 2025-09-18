package br.com.system.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class LoginAgenciaRequisicaoDTO {

    @NotBlank(message = "O campo não pode estar vazio")
    @JsonProperty("agencia")
    private String numeroAgencia;

    @NotBlank(message = "O campo não pode estar vazio")
    private String senha;
}
