package com.fco.microservices.mscartoes.application.representation;

import com.fco.microservices.mscartoes.domain.BandeiraCartao;
import com.fco.microservices.mscartoes.domain.Cartao;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
public class CartaoOutput {

    private Long id;
    private String nome;
    private BandeiraCartao bandeira;
    private BigDecimal renda;
    private BigDecimal limiteBasico;

}
