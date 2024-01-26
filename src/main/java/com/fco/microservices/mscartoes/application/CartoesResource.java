package com.fco.microservices.mscartoes.application;

import com.fco.microservices.mscartoes.application.representation.CartaoInput;
import com.fco.microservices.mscartoes.domain.Cartao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cartoes")
public class CartoesResource {

    @Autowired
    private CartaoService cartaoService;

    @PostMapping
    public ResponseEntity cadastrar(CartaoInput cartaoInput){

        Cartao cartao = cartaoInput.toModel();
        cartaoService.salvar(cartao);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<List<Cartao>> buscaCartoesRenda(@RequestParam Long renda){
        List<Cartao> cartoes = cartaoService.buscaCartoesRendaMenorIgual(renda);


        return ResponseEntity.ok(cartoes);
    }

}
