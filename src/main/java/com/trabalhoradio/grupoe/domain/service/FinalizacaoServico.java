package com.trabalhoradio.grupoe.domain.service;

import com.trabalhoradio.grupoe.domain.exception.DomainException;
import com.trabalhoradio.grupoe.domain.model.Servico;
import com.trabalhoradio.grupoe.domain.model.StatusServico;
import com.trabalhoradio.grupoe.domain.repository.ServicoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class FinalizacaoServico {


    private ServicoRepository servicoRepository;
    private BuscaServicoService buscaServicoService;

    @Transactional
    public void finalizar(Long servicoId) {
        Servico servico = buscaServicoService.buscar(servicoId);

        servico.finalizar();

        servicoRepository.save(servico);
    }

}
