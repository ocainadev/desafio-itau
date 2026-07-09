package dev.ocaina.desafioitau.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
public class Estatistica {

    private final Long count;
    private final double sum;
    private final double avg;
    private final double min;
    private final double max;
}
