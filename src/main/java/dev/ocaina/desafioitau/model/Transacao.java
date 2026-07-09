package dev.ocaina.desafioitau.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Transacao {

    @NotNull(message = "O valor não pode ser vazio: ")
    @Positive(message = "O valor tem que ser igual ou maior que zero: ")
    private BigDecimal valor;
    private OffsetDateTime dataHora;

}
