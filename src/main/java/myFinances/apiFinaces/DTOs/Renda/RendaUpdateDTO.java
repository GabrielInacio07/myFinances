package myFinances.apiFinaces.DTOs.Renda;

import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
public class RendaUpdateDTO {

    private String description;
    private BigDecimal value;
    private LocalDateTime date;
}
