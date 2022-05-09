package com.trabalhoradio.grupoe.domain.repository;

import com.trabalhoradio.grupoe.domain.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, String> {

    List<Cliente> findByNome(String nome);
    List<Cliente> findByNomeContaining(String nome);
    List<Cliente> findBytaxId(String taxId);
    boolean existsByEmail(String email);
}
