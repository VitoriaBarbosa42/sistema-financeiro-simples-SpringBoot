package br.com.system.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

@Getter
@Setter
@AllArgsConstructor
public class CadastroUsuarioDTO {

    @NotBlank(message = "Campo não pode ser nulo")
    private String nome;

    @NotBlank(message = "Campo não pode ser nulo")
    private String sobrenome;


    @NotBlank(message = "Campo não pode ser nulo")
    @Size(min = 11, max = 11, message = "O CPF deve ter 11 digitos")
    @Pattern(regexp = "^\\d+$", message = "O campo deve conter apenas números.")
    @CPF(message = "CPF invalido")
    private String cpf;

    @NotBlank(message = "Campo não pode ser nulo")
    @Email(message = "Digite um email valido")
    private String email;

}
