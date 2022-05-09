package com.trabalhoradio.grupoe.api.model;

import com.trabalhoradio.grupoe.domain.model.StatusServico;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.OffsetDateTime;


@Getter
@Setter
public class ServicoModel {

    private Long id;
    private ClienteResumoModel cliente;
    private float valor;
    private StatusServico status;
    private OffsetDateTime dataInicio;
    private OffsetDateTime dataFinalizacao;
    private String tipoServico;


}
