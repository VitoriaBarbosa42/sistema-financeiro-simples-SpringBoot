package br.com.system.repository;

import br.com.system.model.entities.Agencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LoginAgenciaRepository extends JpaRepository <Agencia, Long> {

    @NativeQuery(value = "select * from agencia where numeroagencia = :numero")
    Agencia findByNumeroAgencia(@Param("numero") String numero);
}
