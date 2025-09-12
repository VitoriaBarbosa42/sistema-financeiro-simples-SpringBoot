package br.com.system.repository;

import br.com.system.model.entities.Agencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LoginAgenciaRepository extends JpaRepository <Agencia, Long> {

    @NativeQuery(value = "select numeroagencia from agencia where numeroAgencia = :numero")
    Agencia findByNumeroAgencia(String numero);

    @NativeQuery(value = "select senha from agencia where numeroAgencia = :numero")
    Agencia findBySenha(String numero);
}
