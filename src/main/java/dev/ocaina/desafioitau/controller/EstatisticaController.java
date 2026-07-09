package dev.ocaina.desafioitau.controller;

import dev.ocaina.desafioitau.Repository.TransacaoRepository;
import dev.ocaina.desafioitau.docs.EstatisticaControllerDoc;
import dev.ocaina.desafioitau.model.Estatistica;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.OffsetDateTime;


@Slf4j
@RestController
@RequestMapping("/estatistica")
public class EstatisticaController implements EstatisticaControllerDoc {
    private final TransacaoRepository transacaoRepository;
    public EstatisticaController(TransacaoRepository transacaoRepository) {
        this.transacaoRepository = transacaoRepository;
    }

    @GetMapping
    public ResponseEntity<Estatistica> consultar(){
        log.info("Calculando Estatisticas de Transações dos ultimos 60 segundos");
        final var horaInicial = OffsetDateTime.now().minusSeconds(60);
        var summary = transacaoRepository.consultarEstatistica(horaInicial);
        return ResponseEntity.ok(summary);
    }
}
