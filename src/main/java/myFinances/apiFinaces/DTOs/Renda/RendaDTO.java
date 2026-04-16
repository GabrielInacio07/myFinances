package myFinances.apiFinaces.DTOs.Renda;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
public class RendaDTO {

    private BigDecimal rendaFixa;
    private BigDecimal freeLance;
    private BigDecimal rendimento;

    @Override
    public String toString() {
        return "RendaDTO{" +
                "salario=" + rendaFixa +
                ", freeLance=" + freeLance +
                ", rendimento=" + rendimento +
                '}';
    }
}
