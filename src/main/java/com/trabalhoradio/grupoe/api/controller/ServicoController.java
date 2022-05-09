package com.trabalhoradio.grupoe.api.controller;

import com.trabalhoradio.grupoe.api.assembler.ServicoMapper;
import com.trabalhoradio.grupoe.api.model.ServicoModel;
import com.trabalhoradio.grupoe.api.model.input.ServicoInput;
import com.trabalhoradio.grupoe.domain.model.Servico;
import com.trabalhoradio.grupoe.domain.repository.ServicoRepository;
import com.trabalhoradio.grupoe.domain.service.FinalizacaoServico;
import com.trabalhoradio.grupoe.domain.service.SolicitacaoServicoService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/servicos")
public class ServicoController {

    private ServicoRepository servicoRepository;
    private SolicitacaoServicoService solicitacaoServicoService;
    private ServicoMapper servicoMapper;
    private FinalizacaoServico finalizacaoServico;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ServicoModel solicitar(@Valid @RequestBody ServicoInput servicoInput){
        Servico novoServico = servicoMapper.toEntity(servicoInput);
        Servico servicoSolicitado = solicitacaoServicoService.solicitar(novoServico);
        return servicoMapper.toModel(servicoSolicitado);
    }

    @GetMapping
    public List<ServicoModel> listar() {
        return servicoMapper.toCollectionModel(servicoRepository.findAll());

    }
    @GetMapping("/{servicoId}")
    public ResponseEntity<ServicoModel> buscar(@PathVariable Long servicoId) {
        return servicoRepository.findById(servicoId)
                .map(servico -> ResponseEntity.ok(servicoMapper.toModel(servico))
                ).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{servicoId}/finalizacao")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void finalizar(@PathVariable Long servicoId){
        finalizacaoServico.finalizar(servicoId);
    }
}
