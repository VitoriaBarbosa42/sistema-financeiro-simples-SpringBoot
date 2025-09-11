package br.com.system.service.cadastro;

import br.com.system.dto.LoginAgenciaDTO;
import br.com.system.repository.LoginAgenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginAgenciaService{

    @Autowired
    LoginAgenciaRepository loginAgenciaRepository;
}
