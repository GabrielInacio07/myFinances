package myFinances.apiFinaces.service;

import lombok.RequiredArgsConstructor;
import myFinances.apiFinaces.DTOs.Renda.RendaDTO;
import myFinances.apiFinaces.model.Renda;
import myFinances.apiFinaces.repository.RendaRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RendaService {

    private final RendaRepository rendaRepository;

    public void saveIncomeRepository(RendaDTO dto){

        Renda renda = Renda.builder()
                .incomeFixed(dto.getIncomeFixed())
                .freeLance(dto.getFreeLance())
                .performance(dto.getPerformance())
                .build();

        rendaRepository.save(renda);
    }
}
