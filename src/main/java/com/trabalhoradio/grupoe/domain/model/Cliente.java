package com.trabalhoradio.grupoe.domain.model;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Cliente {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 60)
    @Column(name = "Nome")
    private String nome;

    @NotBlank
    @Size(max = 14)
    private String CPF;

    @NotBlank
    @Size(max = 1)
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
