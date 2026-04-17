package myFinances.apiFinaces.DTOs.Renda;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
public class RendaDTO {

    private BigDecimal incomeFixed;
    private BigDecimal freeLance;
    private BigDecimal performance;

}
