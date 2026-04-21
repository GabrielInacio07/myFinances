package myFinances.apiFinaces.Service;


import lombok.RequiredArgsConstructor;
import myFinances.apiFinaces.DTOs.Custo.CustoDTO;
import myFinances.apiFinaces.Model.Custo;
import myFinances.apiFinaces.Repository.CustoRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class CustoService {

    private final CustoRepository custoRepository;

    public void saveCusto(CustoDTO dto){

        Custo custo = Custo.builder()
                .description(dto.getDescription())
                .value(BigDecimal.valueOf(dto.getValue()))
                .category(dto.getCategory())
                .build();

        custoRepository.save(custo);
    }
}
