package com.trabalhoradio.grupoe.domain.service;


import com.trabalhoradio.grupoe.domain.exception.DomainException;
import com.trabalhoradio.grupoe.domain.model.Cliente;
import com.trabalhoradio.grupoe.domain.repository.ClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class CrudClienteService {

    private ClienteRepository clienteRepository;

    public Cliente buscar(String clientetaxId) {
        return clienteRepository.findById(clientetaxId)
                .orElseThrow(() -> new DomainException("Cliente não Encontrado"));

    }

    @Transactional
    public Cliente salvar(Cliente cliente) {
        boolean emailEmUso = clienteRepository.existsByEmail(cliente.getEmail());

       if (emailEmUso){
          throw new DomainException("Já Existe um Cliente Cadastrado com esse e-mail");
       }
        return clienteRepository.save(cliente);
    }

    @Transactional
    public void excluir (String clientetaxId) {
        clienteRepository.deleteById(clientetaxId);
    }

}


