package br.com.system.repository;

import br.com.system.model.entities.Agencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LoginAgenciaRepository extends JpaRepository <Agencia, Long>{

    @Query(value = "select * from agencia where numeroAgencia = :numero", nativeQuery = true)
    List<Agencia> findByNumeroAgencia(String numero);
}
