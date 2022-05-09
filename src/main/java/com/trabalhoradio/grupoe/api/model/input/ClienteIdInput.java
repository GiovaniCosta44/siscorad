package com.trabalhoradio.grupoe.api.model.input;


import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class ClienteIdInput {


    @NotNull
    private String taxId;

}
