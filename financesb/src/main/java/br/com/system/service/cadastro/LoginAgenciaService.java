package br.com.system.service.cadastro;

import br.com.system.dto.LoginAgenciaDTO;
import br.com.system.repository.LoginAgenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginAgenciaService{

    @Autowired
    LoginAgenciaRepository loginAgenciaRepository;

    public Boolean login(LoginAgenciaDTO loginAgendaDTO) {
        var agencia = loginAgenciaRepository.findByNumeroAgencia(loginAgendaDTO.getNumeroAgencia());
        var senha = loginAgenciaRepository.findBySenha(loginAgendaDTO.getNumeroAgencia());

        if(agencia == null){
            return false;
        } else if(!senha.equals(loginAgendaDTO.getSenha())){
            return false;
        }
        return true;
    }
}
