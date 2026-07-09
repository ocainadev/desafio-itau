package dev.ocaina.desafioitau.controller;

import dev.ocaina.desafioitau.Repository.TransacaoRepository;
import dev.ocaina.desafioitau.docs.TransacaoControllerDoc;
import dev.ocaina.desafioitau.model.TransacaoRequest;
import dev.ocaina.desafioitau.service.TransacaoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/transacao")
public class TransacaoController implements TransacaoControllerDoc {

    private final TransacaoService transacaoService;
    private final TransacaoRepository transacaoRepository;
    public TransacaoController(TransacaoService transacaoService, TransacaoRepository transacaoRepository) {
        this.transacaoService = transacaoService;
        this.transacaoRepository = transacaoRepository;
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody TransacaoRequest request) {
        try{
            log.info("Criando um Transação de R$" + request.getValor());
            transacaoService.validarTransacao(request);
            transacaoRepository.salvarDados(request);
            log.info("Transação Criada com sucesso!");
            return ResponseEntity.status(HttpStatus.CREATED).build();

        } catch (IllegalArgumentException e){
            log.error("Erro ao validar 1 ou mais propriedades");
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
        } catch (Exception e){
            log.error("Erro no preenchimento dos campos!");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @DeleteMapping
    public ResponseEntity<Void> deletar(){
            transacaoRepository.apagarDados();
            log.info("Apagando todos os dados!");
            return ResponseEntity.status(HttpStatus.OK).build();
    }
}
