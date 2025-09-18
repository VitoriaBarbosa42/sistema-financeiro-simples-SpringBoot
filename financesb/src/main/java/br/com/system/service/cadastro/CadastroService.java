package br.com.system.service.cadastro;

import br.com.system.dto.CadastroUsuarioDTO;
import br.com.system.dto.ResponseCadastroClienteDTO;
import br.com.system.model.entities.Usuario;
import br.com.system.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CadastroService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public ResponseCadastroClienteDTO cadastrarUsuario(CadastroUsuarioDTO cadastroUsuarioDto) {

        ResponseCadastroClienteDTO resposta;

        Usuario usuario = new Usuario();
        usuario.setNome(cadastroUsuarioDto.getNome());
        usuario.setSobrenome(cadastroUsuarioDto.getSobrenome());
        usuario.setCpf(cadastroUsuarioDto.getCpf());
        usuario.setEmail(cadastroUsuarioDto.getEmail());

        Usuario novoUsuario = usuarioRepository.save(usuario);
        resposta = new ResponseCadastroClienteDTO(novoUsuario.getNome(), novoUsuario.getEmail());
        return resposta;
    }

}
