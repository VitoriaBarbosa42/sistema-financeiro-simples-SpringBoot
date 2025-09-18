package br.com.system.controller;

import br.com.system.dto.CadastroUsuarioDTO;
import br.com.system.dto.ResponseCadastroClienteDTO;
import br.com.system.service.cadastro.CadastroService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class NovoUsuarioController {

    @Autowired
    private CadastroService service;

    @PostMapping("/cadastrar")
    public ResponseEntity<ResponseCadastroClienteDTO> cadastrar(@Valid @RequestBody CadastroUsuarioDTO cadastro){
        var resposta = service.cadastrarUsuario(cadastro);
        return ResponseEntity.ok(resposta);
    }
}
