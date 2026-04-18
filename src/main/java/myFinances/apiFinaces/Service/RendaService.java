package myFinances.apiFinaces.Service;

import lombok.RequiredArgsConstructor;
import myFinances.apiFinaces.DTOs.Renda.RendaDTO;
import myFinances.apiFinaces.Model.Renda;
import myFinances.apiFinaces.Repository.RendaRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@RequiredArgsConstructor
@Service
public class RendaService {

    private final RendaRepository rendaRepository;

    private void validateInput(RendaDTO dto) {

        if(dto.getIncomeFixed() == null || dto.getFreeLance() == null || dto.getPerformance() == null){
            throw new IllegalArgumentException("Nenhum campo pode estar null");
        }

        if (dto.getIncomeFixed().compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Renda fixa não pode ser negativo");
        }

        if (dto.getFreeLance().compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Freelance não pode ser negativo");
        }

        if (dto.getPerformance().compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Rendimento não pode ser negativo");
        }
    }

    public void saveIncomeRepository(RendaDTO dto) {

        validateInput(dto);

        Renda renda = Renda.builder()
                .incomeFixed(dto.getIncomeFixed())
                .freeLance(dto.getFreeLance())
                .performance(dto.getPerformance())
                .build();

        rendaRepository.save(renda);
    }
}
