package dev.ocaina.desafioitau.docs;

import dev.ocaina.desafioitau.model.TransacaoRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

@Tag(name="Transação Controller", description = "Endingpoints para criar e deletar transações")
public interface TransacaoControllerDoc {

    @Operation(summary = "Cria Transação", description = "Recebe uma transação e adiciona em uma lista")
    @ApiResponse(responseCode="201",description = "Transação criado com sucesso")
    @ApiResponse(responseCode = "422", description = "Erro de validação capturado")
    @ApiResponse(responseCode = "400", description = "Erro indesperado no servidor")
    ResponseEntity<Void> create(TransacaoRequest request);

    @Operation(summary = "Deleta Transações", description = "Deleta toda a lista das transações cadastradas")
    @ApiResponse(responseCode="200",description = "Transações deletas")
    ResponseEntity<Void> deletar();

}
