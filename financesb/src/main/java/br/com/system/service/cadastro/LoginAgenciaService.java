package br.com.system.service.cadastro;

import br.com.system.dto.LoginAgenciaRequisicaoDTO;
import br.com.system.repository.LoginAgenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginAgenciaService{

    @Autowired
    LoginAgenciaRepository loginAgenciaRepository;

    public Boolean login(LoginAgenciaRequisicaoDTO loginAgendaDTO) {
        var agencia = loginAgenciaRepository.findByNumeroAgencia(loginAgendaDTO.getNumeroAgencia());
        if(agencia == null || !agencia.getSenha().equals(loginAgendaDTO.getSenha())) {
            return false;
        }
        return true;
        }
}

