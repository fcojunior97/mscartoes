package com.fco.microservices.mscartoes.application.representation;

import com.fco.microservices.mscartoes.domain.BandeiraCartao;
import com.fco.microservices.mscartoes.domain.Cartao;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class CartaoInput {

    private String nome;
    private BandeiraCartao bandeira;
    private BigDecimal renda;
    private BigDecimal limiteBasico;

    public Cartao toModel(){
        return new Cartao(nome, bandeira, renda, limiteBasico);
    }

    @Override
    public String toString() {
        return "CartaoInput{" +
                "nome='" + nome + '\'' +
                ", bandeira=" + bandeira +
                ", renda=" + renda +
                ", limiteBasico=" + limiteBasico +
                '}';
    }
}
