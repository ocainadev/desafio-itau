package dev.ocaina.desafioitau.Repository;

import dev.ocaina.desafioitau.model.Estatistica;
import dev.ocaina.desafioitau.model.TransacaoRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.util.StopWatch;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Repository
public class TransacaoRepository {

    private List<TransacaoRequest> listTransacoes = new ArrayList<>();

    public void salvarDados(TransacaoRequest request){
        listTransacoes.add(request);
    }

    public void limparDados(){

    }

    public void apagarDados(){
        listTransacoes.clear();
    }

    public Estatistica consultarEstatistica(OffsetDateTime horaInicial){

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        if (listTransacoes.isEmpty()) {
            return new Estatistica(0L,0,0,0,0);
        }
        final var summary = listTransacoes.stream()
                .filter(
                        t -> t.getDataHora().isAfter(horaInicial) || t.getDataHora().isEqual(horaInicial))
                .mapToDouble(t -> t.getValor().doubleValue())
                .summaryStatistics();
        stopWatch.stop();
        log.info("Essa consulta durou {} ms", stopWatch.getTotalTimeMillis());
        return new Estatistica(
                summary.getCount(),
                summary.getSum(),
                summary.getAverage(),
                summary.getMin(),
                summary.getMax());

    }
}
