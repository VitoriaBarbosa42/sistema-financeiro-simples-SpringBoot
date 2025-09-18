package br.com.system.controller;

import br.com.system.dto.AgenciaLoginRespontaDTO;
import br.com.system.dto.LoginAgenciaRequisicaoDTO;
import br.com.system.service.cadastro.LoginAgenciaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class LoginAgenciaController {

    @Autowired
    private LoginAgenciaService loginService;

    @PostMapping("/login/agencia")
    public ResponseEntity<AgenciaLoginRespontaDTO> login(@Valid @RequestBody LoginAgenciaRequisicaoDTO loginAgenciaDTO){
        Boolean loginSucesso = loginService.login(loginAgenciaDTO);

        if(loginSucesso == false) {
            AgenciaLoginRespontaDTO response = new AgenciaLoginRespontaDTO("Agência ou senha incorretos.");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }
        AgenciaLoginRespontaDTO response = new AgenciaLoginRespontaDTO("Login bem-sucedido!");
        return ResponseEntity.ok(response);
    }
}
