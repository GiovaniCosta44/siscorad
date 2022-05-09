package com.trabalhoradio.grupoe.api.controller;

import com.trabalhoradio.grupoe.domain.model.Servico;
import com.trabalhoradio.grupoe.domain.repository.ServicoRepository;
import com.trabalhoradio.grupoe.domain.service.SolicitacaoServicoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/servicos")
public class ServicoController {

    private SolicitacaoServicoService solicitacaoServicoService;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Servico solicitar(@RequestBody Servico servico){

        return solicitacaoServicoService.solicitar(servico);
    }
}
