package com.trabalhoradio.grupoe.api.assembler;

import com.trabalhoradio.grupoe.api.model.ServicoModel;
import com.trabalhoradio.grupoe.api.model.input.ServicoInput;
import com.trabalhoradio.grupoe.domain.model.Servico;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class ServicoMapper {

    private ModelMapper modelMapper;

    public ServicoModel toModel(Servico servico){
        return modelMapper.map(servico, ServicoModel.class);
    }

    public List<ServicoModel> toCollectionModel(List<Servico> servicos){
        return servicos.stream()
                .map(this::toModel)
                .collect(Collectors.toList());
    }

    public Servico toEntity(ServicoInput servicoInput) {
        return modelMapper.map(servicoInput, Servico.class);
    }

}
