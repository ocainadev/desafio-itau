package dev.ocaina.desafioitau.docs;

import dev.ocaina.desafioitau.model.Estatistica;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

@Tag(name="Estatistica Controller", description = "Endpoints para gerar estatisticas")
public interface EstatisticaControllerDoc {

    @Operation(summary="Gerar estatisticas", description = "Consulta as transações e gera as estatisticas")
    @ApiResponse(responseCode = "200", description = "Retorna todas as estatisticas referente as transações")
    ResponseEntity<Estatistica> consultar();
}
