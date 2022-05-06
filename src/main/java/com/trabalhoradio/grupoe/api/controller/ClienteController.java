package com.trabalhoradio.grupoe.api.controller;

import java.util.List;

import com.trabalhoradio.grupoe.domain.model.Cliente;
import com.trabalhoradio.grupoe.domain.repository.ClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@RequestMapping("/clientes")
public class ClienteController {

    private ClienteRepository clienteRepository;

    @GetMapping
    public List<Cliente> listar() {
        return clienteRepository.findAll();
    }

    @GetMapping("/{clientetaxId}")
    public ResponseEntity<Cliente> buscar(@PathVariable String clientetaxId) {
        return clienteRepository.findById(clientetaxId)
                //    .map(cliente -> ResponseEntity.ok(cliente))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente adicionar(@Valid @RequestBody Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @PutMapping("/{clientetaxId}")
    public ResponseEntity<Cliente> atualizar(@PathVariable String clientetaxId, @Valid @RequestBody Cliente cliente) {
        if (!clienteRepository.existsById(clientetaxId)) {
            return ResponseEntity.notFound().build();
        }
        cliente.setTaxId(clientetaxId);
        cliente = clienteRepository.save(cliente);

        return ResponseEntity.ok(cliente);
    }

    @DeleteMapping("/{clientetaxId}")
    public ResponseEntity<Void> remover(@PathVariable String clientetaxId) {
        if (!clienteRepository.existsById(clientetaxId)) {
            return ResponseEntity.notFound().build();
        }
        clienteRepository.deleteById(clientetaxId);

        return ResponseEntity.noContent().build();
    }

}
