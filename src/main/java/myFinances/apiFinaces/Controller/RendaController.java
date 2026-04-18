package myFinances.apiFinaces.Controller;

import lombok.RequiredArgsConstructor;
import myFinances.apiFinaces.DTOs.Renda.RendaDTO;
import myFinances.apiFinaces.Service.RendaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/renda")
@RestController
@RequiredArgsConstructor
public class RendaController {

    private final RendaService service;

    @PostMapping
    public ResponseEntity<Void> saveIncome(@RequestBody RendaDTO dto){
        service.saveIncomeRepository(dto);

        return ResponseEntity.status(201).build();
    }


}
