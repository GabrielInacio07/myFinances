package myFinances.apiFinaces.Service;

import lombok.RequiredArgsConstructor;
import myFinances.apiFinaces.DTOs.Renda.RendaDTO;
import myFinances.apiFinaces.DTOs.Renda.RendaUpdateDTO;
import myFinances.apiFinaces.Model.Renda;
import myFinances.apiFinaces.Model.Usuario;
import myFinances.apiFinaces.Repository.RendaRepository;
import myFinances.apiFinaces.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@RequiredArgsConstructor
@Service
public class RendaService {

    private final RendaRepository rendaRepository;
    private final UserRepository userRepository;

    private void validateInput(RendaDTO dto) {

        if(dto.getDescription() == null || dto.getDescription().isBlank()){
            throw new IllegalArgumentException("Descrição não pode ser vazia");
        }

        if(dto.getValue() == null){
            throw new IllegalArgumentException("Valor não pode ser null");
        }

        if(dto.getValue().compareTo(BigDecimal.ZERO) < 0){
            throw new IllegalArgumentException("Valor não pode ser negativo");
        }

        if(dto.getDate() == null){
            throw new IllegalArgumentException("Data não pode ser null");
        }
    }

    public void saveIncomeRepository(RendaDTO dto,Long userId) {

        validateInput(dto);

        Usuario user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        Renda renda = Renda.builder()
                .description(dto.getDescription())
                .value(dto.getValue())
                .date(dto.getDate())
                .usuario(user)
                .build();

        rendaRepository.save(renda);
    }

    public Renda consultRenda(Long id){
        return rendaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Renda não encontrada"));
    }

    public List<Renda> consultAllRenda(Long userId){
        return rendaRepository.findByUsuarioId(userId);
    }

    public void updateRenda(Long id, RendaUpdateDTO dto){

        Renda renda = consultRenda(id);

        if(dto.getDescription() != null){

            if(dto.getDescription().isBlank()){
                throw new IllegalArgumentException("Descrição inválida");
            }

            renda.setDescription(dto.getDescription());
        }

        if(dto.getValue() != null){

            if(dto.getValue().compareTo(BigDecimal.ZERO) < 0){
                throw new IllegalArgumentException("Valor não pode ser negativo");
            }

            renda.setValue(dto.getValue());
        }

        if(dto.getDate() != null){
            renda.setDate(dto.getDate());
        }

        rendaRepository.save(renda);
    }

    public void deleteRenda(Long id){
        Renda renda = consultRenda(id);
        rendaRepository.delete(renda);
    }
}