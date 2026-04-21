package myFinances.apiFinaces.Controller;

import lombok.RequiredArgsConstructor;
import myFinances.apiFinaces.DTOs.Renda.RendaDTO;
import myFinances.apiFinaces.DTOs.Renda.RendaUpdateDTO;
import myFinances.apiFinaces.DTOs.Renda.ResponseRendaDTO;
import myFinances.apiFinaces.Model.Renda;
import myFinances.apiFinaces.Service.RendaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/renda")
@RestController
@RequiredArgsConstructor
public class RendaController {

    private final RendaService service;

    @PostMapping
    public ResponseEntity<Void> saveIncome(@RequestBody RendaDTO dto, @RequestHeader("userId") Long userId){
        service.saveIncomeRepository(dto, userId);
        return ResponseEntity.status(201).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseRendaDTO> consult(@PathVariable Long id){

        Renda renda = service.consultRenda(id);

        ResponseRendaDTO dto = ResponseRendaDTO.builder()
                .description(renda.getDescription())
                .value(renda.getValue())
                .date(renda.getDate())
                .build();

        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public ResponseEntity<List<ResponseRendaDTO>> consultAll(@RequestHeader("userId") Long userId){

        List<ResponseRendaDTO> response = service.consultAllRenda(userId)
                .stream()
                .map(renda -> ResponseRendaDTO.builder()
                        .description(renda.getDescription())
                        .value(renda.getValue())
                        .date(renda.getDate())
                        .build())
                .toList();

        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody RendaUpdateDTO dto){
        service.updateRenda(id, dto);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.deleteRenda(id);
        return ResponseEntity.noContent().build();
    }
}
