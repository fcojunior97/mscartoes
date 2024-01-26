package com.fco.microservices.mscartoes.application;

import com.fco.microservices.mscartoes.domain.Cartao;
import com.fco.microservices.mscartoes.infra.repository.CartaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
public class CartaoService {

    @Autowired
    private CartaoRepository cartaoRepository;

    @Transactional
    public Cartao salvar(Cartao cartao) {
        return cartaoRepository.save(cartao);
    }

    public List<Cartao> buscaCartoesRendaMenorIgual(Long renda) {
        BigDecimal rendaBigDecimal = BigDecimal.valueOf(renda);
        return cartaoRepository.findByRendaLessThanEqual(rendaBigDecimal);
    }


}
