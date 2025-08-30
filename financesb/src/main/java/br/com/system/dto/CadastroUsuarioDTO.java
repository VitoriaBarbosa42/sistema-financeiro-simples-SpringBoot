package br.com.system.dto;

import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.br.CPF;

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

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }
    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}
