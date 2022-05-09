package com.trabalhoradio.grupoe.domain.service;


import com.trabalhoradio.grupoe.domain.exception.DomainException;
import com.trabalhoradio.grupoe.domain.model.Servico;
import com.trabalhoradio.grupoe.domain.repository.ServicoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class BuscaServicoService {

    private ServicoRepository servicoRepository;

    public Servico buscar(Long sericoId) {
        return servicoRepository.findById(sericoId)
                .orElseThrow(() -> new DomainException("Serviço não Encontrado"));
    }
}
