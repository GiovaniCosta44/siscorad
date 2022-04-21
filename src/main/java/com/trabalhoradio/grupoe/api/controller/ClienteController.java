package com.trabalhoradio.grupoe.api.controller;

import java.util.Arrays;
import java.util.List;

import com.trabalhoradio.grupoe.domain.model.Cliente;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@RestController
public class ClienteController {

    @PersistenceContext
    private EntityManager manager;


    @GetMapping("/clientes")
    public List<Cliente> listar(){
        return manager.createQuery("from Cliente", Cliente.class)
                .getResultList();
    }
}
