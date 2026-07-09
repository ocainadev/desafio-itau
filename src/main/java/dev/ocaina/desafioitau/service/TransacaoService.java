package dev.ocaina.desafioitau.service;

import dev.ocaina.desafioitau.model.TransacaoRequest;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Service
public class TransacaoService {
    public void validarTransacao(TransacaoRequest request) {

        if (request.getValor().compareTo(BigDecimal.ZERO) < 0){
            throw new IllegalArgumentException("Erro: transacoes devem estar maior que zero.");
        }
        if (request.getDataHora().isAfter(OffsetDateTime.now())){
            throw new IllegalArgumentException("Erro: transacoes devem ser menor que data e hora de agora.");
        }
    }
}

