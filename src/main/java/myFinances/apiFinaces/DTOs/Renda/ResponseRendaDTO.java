package myFinances.apiFinaces.DTOs.Renda;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@Builder
@AllArgsConstructor
public class ResponseRendaDTO {

    private BigDecimal rendaFixa;
    private BigDecimal freeLance;
    private BigDecimal rendimento;
}
