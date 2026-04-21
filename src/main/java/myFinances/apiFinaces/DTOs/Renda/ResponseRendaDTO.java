package myFinances.apiFinaces.DTOs.Renda;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
public class ResponseRendaDTO {

    private String description;
    private BigDecimal value;
    private LocalDateTime date;
}