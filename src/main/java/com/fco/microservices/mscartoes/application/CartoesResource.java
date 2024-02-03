package com.fco.microservices.mscartoes.application;

import com.fco.microservices.mscartoes.application.representation.CartaoInput;
import com.fco.microservices.mscartoes.application.representation.CartoesPorClienteResponse;
import com.fco.microservices.mscartoes.domain.Cartao;
import com.fco.microservices.mscartoes.domain.ClienteCartao;
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

    @Autowired
    private ClienteCartaoService clienteCartaoService;

    @PostMapping
    public ResponseEntity cadastrar(@RequestBody CartaoInput cartaoInput){

        System.out.println(cartaoInput);
        Cartao cartao = cartaoInput.toModel();
        System.out.println(cartaoService.salvar(cartao));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<List<Cartao>> buscaCartoesRenda(@RequestParam Long renda){
        List<Cartao> cartoes = cartaoService.buscaCartoesRendaMenorIgual(renda);


        return ResponseEntity.ok(cartoes);
    }

    @GetMapping(params = "cpf")
    public ResponseEntity<List<CartoesPorClienteResponse>> buscaCartoesPorCliente(@RequestParam("cpf") String cpf){
        List<ClienteCartao> listCartoes = clienteCartaoService.listCartoesByCpf(cpf);
        List<CartoesPorClienteResponse> listCartoesPorCliente = listCartoes.stream()
                .map(cartao -> CartoesPorClienteResponse.fromModel(cartao))
                .toList();

        return ResponseEntity.ok(listCartoesPorCliente);
    }

}
