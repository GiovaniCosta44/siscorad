package com.trabalhoradio.grupoe.domain.service;

import com.trabalhoradio.grupoe.domain.exception.DomainException;
import com.trabalhoradio.grupoe.domain.model.Cliente;
import com.trabalhoradio.grupoe.domain.model.Servico;
import com.trabalhoradio.grupoe.domain.model.StatusServico;
import com.trabalhoradio.grupoe.domain.repository.ClienteRepository;
import com.trabalhoradio.grupoe.domain.repository.ServicoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;

@AllArgsConstructor
@Service
public class SolicitacaoServicoService {

    private CrudClienteService crudClienteService;
    private ServicoRepository servicoRepository;

    @Transactional
    public Servico solicitar(Servico servico) {
        Cliente cliente = crudClienteService.buscar(servico.getCliente().getTaxId());

        servico.setCliente(cliente);
        servico.setStatus(StatusServico.PENDENTE);
        servico.setDataInicio(OffsetDateTime.now());

        return servicoRepository.save(servico);
    }
}
