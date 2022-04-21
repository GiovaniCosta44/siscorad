package com.trabalhoradio.grupoe.domain.model;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Cliente {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Nome")
    private String nome;

    private String CPF;

    @Column(name = "Sexo")
    private String sexo;

    @Column (name = "Cep")
    private String CEP;

    @Column(name = "Endereco")
    private String endereco;

    private String email;

    @Column(name = "Telefone")
    private String telefone;


}
