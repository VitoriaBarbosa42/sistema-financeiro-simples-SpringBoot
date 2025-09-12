package br.com.system.controller;

import br.com.system.dto.LoginAgenciaDTO;
import br.com.system.service.cadastro.LoginAgenciaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class LoginAgenciaController {

    @Autowired
    private LoginAgenciaService loginService;

    @GetMapping("/login/agencia")
    public ResponseEntity<Boolean> login(@Valid @RequestBody LoginAgenciaDTO loginAgenciaDTO){
        Boolean resposta = loginService.login(loginAgenciaDTO);
        return ResponseEntity.ok(resposta);
    }
}
