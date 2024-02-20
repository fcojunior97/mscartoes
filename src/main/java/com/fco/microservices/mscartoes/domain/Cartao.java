package com.fco.microservices.mscartoes.domain;

import com.fco.microservices.mscartoes.application.representation.CartaoOutput;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Cartao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @Enumerated(EnumType.STRING)
    private BandeiraCartao bandeira;
    private BigDecimal renda;
    private BigDecimal limiteBasico;

    public Cartao(String nome, BandeiraCartao bandeira, BigDecimal renda, BigDecimal limiteBasico) {
        this.nome = nome;
        this.bandeira = bandeira;
        this.renda = renda;
        this.limiteBasico = limiteBasico;
    }

    @Override
    public String toString() {
        return "Cartao{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", bandeira=" + bandeira +
                ", renda=" + renda +
                ", limiteBasico=" + limiteBasico +
                '}';
    }

    public CartaoOutput toCartaoOutput(){
        return new CartaoOutput(id, nome, bandeira, renda, limiteBasico);
    }



}
