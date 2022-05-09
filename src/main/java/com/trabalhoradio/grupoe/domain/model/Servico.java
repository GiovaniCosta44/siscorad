package com.trabalhoradio.grupoe.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.trabalhoradio.grupoe.domain.ValidationGroups;
import com.trabalhoradio.grupoe.domain.exception.DomainException;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.groups.ConvertGroup;
import javax.validation.groups.Default;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Setter
@Getter
@Entity
public class Servico {


    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @EqualsAndHashCode.Include
    private Long id;

    //@Valid
    //@NotNull
    private String tipo;

    //@JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private OffsetDateTime dataInicio;

    //@JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private OffsetDateTime dataFinalizacao;

    //@Valid
    //@NotNull
    private float Valor;

    //@ConvertGroup(from = Default.class, to = ValidationGroups.class)
    //@Valid
    //@NotNull
    @ManyToOne
    private Cliente cliente;

   //@JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Enumerated(EnumType.STRING)
    private StatusServico status;

    public void finalizar () {
        if (naoPodeSerFinalizado()) {
            throw new DomainException("Serviço não pode ser Finalizado");
        }
        setStatus(StatusServico.FINALIZADA);
        setDataFinalizacao(OffsetDateTime.now());
    }

    public boolean podeSerFinalizado() {
        return StatusServico.PENDENTE.equals(getStatus());
    }

    public boolean naoPodeSerFinalizado() {
        return !podeSerFinalizado();
    }



}
