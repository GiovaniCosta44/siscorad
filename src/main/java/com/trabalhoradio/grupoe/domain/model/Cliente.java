package com.trabalhoradio.grupoe.domain.model;


import com.trabalhoradio.grupoe.domain.ValidationGroups;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Cliente {


    @NotBlank
    @Size(max = 60)
    @Column(name = "Nome")
    private String nome;

    @NotNull(groups = ValidationGroups.ClienteTaxId.class)
    @Id
    @EqualsAndHashCode.Include
    @NotBlank
    @Size(max = 14)
    @Column(name = "taxid ")
    private String taxId;

    @Size(max = 1)
    @NotBlank
    @Column(name = "Sexo")
    private String sexo;

    @Size(max = 9)
    @NotBlank
    @Column (name = "Cep")
    private String CEP;

    @Size(max = 100)
    @NotBlank
    @Column(name = "Endereco")
    private String endereco;

    @Size(max = 255)
    @NotBlank
    @Email
    private String email;

    @Size(max = 14)
    @NotBlank
    @Column(name = "Telefone")
    private String telefone;

}
