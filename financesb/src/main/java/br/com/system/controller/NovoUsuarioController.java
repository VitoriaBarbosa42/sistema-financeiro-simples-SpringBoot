package br.com.system.controller;

import br.com.system.dto.CadastroUsuarioDTO;
import br.com.system.model.entities.Usuario;
import br.com.system.repository.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuarios")
public class
NovoUsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping
    public ResponseEntity<Usuario> cadastrarUsuario(@Valid @RequestBody CadastroUsuarioDTO cadastroUsuarioDto) {
        Usuario usuario = new Usuario();
        usuario.setNome(cadastroUsuarioDto.getNome());
        usuario.setSobrenome(cadastroUsuarioDto.getSobrenome());
        usuario.setCpf(cadastroUsuarioDto.getCpf());
        usuario.setEmail(cadastroUsuarioDto.getEmail());

        Usuario novoUsuario = usuarioRepository.save(usuario);
        return ResponseEntity.ok(novoUsuario);

    }
}
